package gob.df.sds.sinai.web.view.security;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gob.df.sds.sinai.web.bean.vo.Authority;
import gob.df.sds.sinai.web.bean.vo.MasterModule;
import gob.df.sds.sinai.web.bean.vo.Session;
import gob.df.sds.sinai.web.constant.Attr;
import gob.df.sds.sinai.web.constant.Msg;
import gob.df.sds.sinai.web.model.GenericHandlerInterceptor;
import gob.df.sds.sinai.web.view.common.ErrorController;


import static gob.df.sds.sinai.web.constant.Literals.*;

@SuppressWarnings("unchecked")
public class RequestInterceptor extends GenericHandlerInterceptor {
	
  private static List<? extends Class<?>> byPassHandlers;
  
  static{
	  byPassHandlers = Arrays.asList(LoginController.class,
			                         ErrorController.class);
  }
  
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response
		                                    , Object handler) throws Exception {
    String  errorMessage = null;
    Session session = null;
    if(!byPassHandlers.contains(handler.getClass())){
       if(request.getSession() != null){
         session = (Session) request.getSession().getAttribute(Attr.SES_SESSION);
	     if(!verifySession(session)){
		   errorMessage = Msg.BAD_SESSION;
	     } else if(!verifyReferer(request)){
		   errorMessage = Msg.BAD_ACCESS_TYPE;
	     } else if(!verifyAuthority(session, request)){
		  errorMessage = Msg.BAD_AUTHORITY;
	     } 
	  } else {
		 errorMessage = Msg.BAD_SESSION;
	  }
      if(errorMessage != null){
        killSession(request);
        response.sendRedirect("" + "?errMsg=" + errorMessage);
      }
      request.getSession().setAttribute(Attr.SES_SESSION, session);
    }
	return true;
  }
  
  private boolean verifySession(Session session){
	boolean validated = false;
    if((session != null) && (session.getUser() != null) 
        && (session.getProfile() != null) && (session.getMasterModules() != null)
           && (session.getActiveAuthority() != null)) {
    	    validated = true;
      }
    return validated;
  }
  
  private boolean verifyReferer(HttpServletRequest request){
	  boolean validated = true;
	  String refererHeader = request.getHeader(REFERER);
	  if(refererHeader == null || refererHeader.trim().equals("")){
		 validated = false;  
	  }
	  return validated;
  }
  
  private boolean verifyAuthority(Session session, HttpServletRequest request){
    boolean validated = false;
    Integer requestedAuthority = request.getParameter(AUTHORITY_ID) == null 
                              ? session.getActiveAuthority().getId()
                              : new Integer(request.getParameter(AUTHORITY_ID));
    for(MasterModule modules: session.getMasterModules()){
      for(Authority authority : modules.getAutorities()){
        if(authority.getId().equals(requestedAuthority)){
          session.setActiveAuthority(authority);
          return true;
        }
      }
    }
    return validated;
  }
  
  private void killSession(HttpServletRequest request){
	  request.getSession().setAttribute(Attr.SES_SESSION, null);
  }


}
