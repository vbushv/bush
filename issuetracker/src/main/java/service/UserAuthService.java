package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import dao.UserManagerDAO;

public class UserAuthService implements UserDetailsService  {

    @Autowired
    private UserManagerDAO userManagerDAO;
    
    @Autowired
    private HttpSession session;

    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException, DataAccessException {
        
    	log.debug("userId ===> "+userId);
    	log.debug("///////////////////////////////////////////////////////////////");
    	HashMap hashMap = new HashMap();
    	hashMap = userManagerDAO.getPwdByUserId(userId);
        log.debug("===============================================================");
        
        log.debug("====>"+hashMap.get("USER_PASS"));

        UserDetails ud = null;
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		session.setAttribute("userId", hashMap.get("USER_ID"));
		session.setAttribute("userName", hashMap.get("USER_NAME"));

		ud = new User((String)hashMap.get("USER_ID"), (String)hashMap.get("USER_PASS"), true, true, true, true, authorities);
		
        return ud;
    }
}
