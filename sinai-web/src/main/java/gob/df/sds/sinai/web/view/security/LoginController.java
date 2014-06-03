package gob.df.sds.sinai.web.view.security;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import gob.df.sds.sinai.web.bean.vo.UserCredential;
import gob.df.sds.sinai.web.constant.Attr;
import gob.df.sds.sinai.web.constant.Maps;
import gob.df.sds.sinai.web.constant.Msg;
import gob.df.sds.sinai.web.constant.Views;
import gob.df.sds.sinai.web.model.GenericController;
import gob.df.sds.sinai.web.service.security.LoginService;

@Controller
public class LoginController extends GenericController {
	
  private LoginService service;
  
  public void setService(LoginService service) {
	this.service = service;
  }

  @RequestMapping(Maps.SETUP_SIGN_UP)
  public String  setupSingUp(ModelMap model){
	 model.addAttribute(Attr.REQ_USER_CREDENTIALS, new UserCredential()); 
     return Views.LOGIN;
  }
  
  @RequestMapping(Maps.SIGN_UP)
  public String singUp(@ModelAttribute UserCredential userCredential
		     , ModelMap model, HttpSession session) throws Exception {
	UserCredential credential = service.getFullCredential(userCredential);
	String errorMessage = null;
	if(credential == null){
		errorMessage = Msg.BAD_USER;
	} else if(credential.getLocked()){
		errorMessage = Msg.LOCKED_USER;
	} else if(!service.isPasswordCorrect(userCredential, credential)){
		errorMessage = Msg.BAD_PASSWORD;
	}
	if(errorMessage != null){
	  model.addAttribute(Attr.REQ_ERR_MESSAGE, errorMessage);
	  model.addAttribute(Attr.REQ_USER_CREDENTIALS, userCredential); 
	  return Views.LOGIN;
	}
	session.setAttribute(Attr.SES_SESSION, service.getSession(credential
			                                             .getUserId()));
    return Views.CONTAINER;
  }

}
