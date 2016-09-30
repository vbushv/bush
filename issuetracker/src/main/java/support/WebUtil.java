package support;

/**
 * FileName : WebUtil.java
 * Date		: 2012. 2. 22
 */

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.WebRequest;


public class WebUtil {


    private Logger log = Logger.getLogger(this.getClass());

    /**
     * parameter 값을 가저와서 Integer형으로 변환하는 메소드
     * 값이 없거나 int값이 아니면 null을 return 함
     * @param request
     * @param param
     * @return Integer형 값
     */
    public static Integer parseInt(WebRequest request , String param){

        Integer iret = 0;
        String ret = request.getParameter(param);
        if (ret != null) {
            try{
                iret = Integer.parseInt(ret);

            }catch(NumberFormatException nfe){
                new WebUtil().log.debug(nfe.toString());
                return null;
            }

            return iret;
        }else{
            new WebUtil().log.debug("해당하는 param값이 request에  없음");
            return null;
        }
    }

    /**
     * parameter 값을 가저와서 Integer형으로 변환하는 메소드
     * 값이 없거나 int값이 아니면 defaultValue를 가져옴
     * @param request
     * @param param
     * @param defaultValue 디폴트 값
     * @return
     */
    public static Integer parseInt(WebRequest request , String param, Integer defaultValue){
        Integer iret = 0;
        String ret = request.getParameter(param);
        if (ret != null) {
            try{
                iret = Integer.parseInt(ret);
            }catch(NumberFormatException nfe){
                new WebUtil().log.debug(nfe.toString());
                return defaultValue;
            }
            return iret;
        }else{
            new WebUtil().log.debug("해당하는 param값이 request에  없어서 defaultValue로 대체");
            return defaultValue;
        }
    }

    /**
     * 변수를 Integer형으로 변환하는 메소드
     * 값이 없거나 int값이 아니면 defaultValue를 가져옴
     * @param src
     * @param defaultValue 디폴트 값
     * @return
     */    
    public static Integer parseInt(String src, Integer defaultValue){
        Integer iret = 0;
        String ret = src;
        if (ret != null) {
            try{
                iret = Integer.parseInt(ret);
            }catch(NumberFormatException nfe){
                new WebUtil().log.debug(nfe.toString());
                return defaultValue;
            }
            return iret;
        }else{
            new WebUtil().log.debug("해당하는 param값이 request에  없어서 defaultValue로 대체");
            return defaultValue;
        }
    }    
    

    public static boolean isEmptyOrNull(String str) {
        boolean ret = false;
        if(str == null || str.equals("null"))
            ret =  true;
        else
        {
            if(str.trim().equals("")){
                ret =true;
            }
        }
        return ret;
    }

    public static String ifelse(String src, String tar, String trueValue, String falseValue) {
        if(src.equals(tar) ){
            return trueValue;
        }else{
            return falseValue;
        }
    }

    public static String isnull(String src , String defaultValue){
        if(src == null || src.equals("null")) return defaultValue;
        else return src; 
    }

    public static Object isnullObject(Object src , Object defaultValue){
        if (src == null) return defaultValue;
        else return src; 
    }
    
    public static String dateToStr(Date date, String format){
    	SimpleDateFormat formatter=new SimpleDateFormat(format);
    	String dateString=formatter.format(date);
    	
    	return dateString;    	
    }
    
    public static String shortStr(String src, int limit){
    	String appendStr="...";
    	String returnStr = "";
    	if(src.length() > limit){
    		returnStr=shortStr(src,limit,appendStr);
    	}else{
    		returnStr = src;
    	}
    	return returnStr;
    	
    }
    
    public static String shortStr(String src , int limit , String appendStr){
    	String transStr=src.substring(0,limit+1);    
    	transStr=transStr+appendStr;
    	return transStr;
    }
    
    public static String moneyFormat(Object src){
    	String money = NumberFormat.getInstance().format(src);
    	return money;    
    }

    public static String[] cutStr(String src, String delim){
    	String[] sd = src.split(delim);
    	return sd;
    }
}
