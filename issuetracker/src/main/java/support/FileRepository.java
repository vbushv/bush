package support;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileRepository {
	private String path;
	private String realPath;

	private static final Log log = LogFactory.getLog(FileRepository.class);

    private String targetFileFullPath ;
    
    public FileRepository(String path) {
        this.path = path;
        File saveFolder = new File(path);
        if(!saveFolder.exists() || saveFolder.isFile()){
            saveFolder.mkdirs();
        }
    }
    
    /**
     * saveFile()메소드를 실행할때<br>
     * realPath를 지정해주지 않았을경우<br>
     * 기본으로 ...RealPath/file/폴더를 realPath로 저장할 폴더를 정함<br>
     * <br>
     * -realPath지정방법-<br>
     * setPath(Temp); -> ...RealPath/Temp/로 저장할 폴더를 지정함<br>
     * @param sourcefile
     * @param request
     * @return
     * @throws IOException
     */
    public String saveFile(MultipartFile sourcefile, HttpServletRequest request) throws IOException{
    	//String realPath =  getRealPath();
    	String realPath = getRealPath();
    	isDir(realPath);
        
        if ((sourcefile==null)||(sourcefile.isEmpty())) return null;

        String ext =  sourcefile.getOriginalFilename().substring( sourcefile.getOriginalFilename().lastIndexOf('.') + 1, sourcefile.getOriginalFilename().length() );        

        String key = UUID.randomUUID().toString();
        //String targetFilePath = path+"\\"+ key +"." + ext;
        String targetFilePath = realPath+""+ key +"." + ext;

        this.targetFileFullPath  = targetFilePath ;
        sourcefile.transferTo(new File(targetFilePath));
        //realPath 초기화
        setRealPath(null);
        return key+"."+ext;
    }

    public String saveFile(MultipartFile sourcefile, HttpServletRequest request, String filename) throws IOException{
    	String realPath =  getRealPath();
    	isDir(realPath);

        if ((sourcefile==null)||(sourcefile.isEmpty())) return null;

        String targetFilePath = realPath+""+ filename;

        this.targetFileFullPath  = targetFilePath ;
        sourcefile.transferTo(new File(targetFilePath));
        //realPath 초기화
        setRealPath(null);
        return filename;
    }
    
    public String saveExcelFile(MultipartFile sourcefile, HttpServletRequest request) throws IOException{
    	String realPath =  getRealPath();
    	isDir(realPath);
        
        if ((sourcefile==null)||(sourcefile.isEmpty())) return null;

        String filename = sourcefile.getOriginalFilename();
        String targetFilePath = realPath+""+ filename;

        this.targetFileFullPath  = targetFilePath ;
        sourcefile.transferTo(new File(targetFilePath));
        //realPath 초기화
        setRealPath(null);
        return filename;
    }
    
    public String downloadFile(File file, HttpServletRequest request ,HttpServletResponse response) throws IOException{

    	String name;
    	String ext;

    	FileInputStream fis=new FileInputStream(file);
		ServletOutputStream out=response.getOutputStream();
		byte[] buffer=new byte[1024];
		int readBytes=-1;
		while((readBytes=fis.read(buffer,0,1024))!=-1){
			out.write(buffer,0,readBytes);
		}

		fis.close();
		out.close();

	    return file.getName();
	}
    
    /**
     * 디렉토리 존재확인<br>
     * 없을경우 자동생성<br>
     * @param directoryName
     * @return boolean
     */
    public boolean isDir(String directoryName){
    	File dir = new File(directoryName);
        if(!dir.isDirectory()){
        	return dir.mkdirs();
        }
        return true;
    }

    public String getTargetFileFullPath(){
        return this.targetFileFullPath ;
    }

    public String  getFilePath(String fileName){
    	return this.path + "\\" + fileName ;
    }



    public FileInputStream getFileInputStream(String fileName) throws IOException {
    	FileInputStream fis = null;
		fis  = new FileInputStream(this.getFilePath(fileName));
    	return fis;
    }
    
    
    /**
     * 정해진 RealPath를 가져옴<br>
     * realPath가 미지정일 경우 ...realpath/file/temp폴더를 realPath로 함<br>
     * @return
     */
    public String getRealPath() {
    	if(null == realPath){
    		return "\\WEB-INF\\file\\temp\\";
    	}
		return realPath;
	}

    /**
     * realPath를 파라메타 realPath로 지정해준다<br>
     * ex> setPath(File)로 할경우<br>
     * ...realPath/File/ 폴더에 저장이 된다<br>
     * @param realPath
     */
	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}

}