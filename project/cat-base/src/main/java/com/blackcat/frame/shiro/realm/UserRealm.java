package com.blackcat.frame.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.blackcat.frame.core.model.SysUser;
import com.blackcat.frame.core.service.SysUserService;

public class UserRealm  extends AuthorizingRealm {
	@Autowired
	private SysUserService userService;
	/** 
     * 授权方法，在配有缓存的情况下，只加载一次。 
     */ 
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(); 
        
       // info.setRoles(roles);
        /*info.*/
		return info;
	}

	/** 
     * 登陆认证 
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToke = (UsernamePasswordToken)token;  
        String username = usernamePasswordToke.getUsername();  
        SysUser user = userService.queryUserDetail(username);
        if(user != null) {
        	return new SimpleAuthenticationInfo(user.getUserid(),user.getPasswd(),this.getName());         	
        } else {
        	return null;
        }
	}

}
