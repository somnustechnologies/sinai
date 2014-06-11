package gob.df.sds.sinai.web.view.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class RequestInterceptor extends HandlerInterceptorAdapter {
  
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response
		                                    , Object handler) throws Exception {
	UserService userService = UserServiceFactory.getUserService();
	response.sendRedirect(userService.createLoginURL(request.getRequestURI()));
	return true;
  }

}
