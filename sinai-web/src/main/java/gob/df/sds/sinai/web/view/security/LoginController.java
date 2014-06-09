package gob.df.sds.sinai.web.view.security;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import gob.df.sds.sinai.common.controller.AbstractController;
import gob.df.sds.sinai.web.bean.vo.UserCredential;
import gob.df.sds.sinai.web.constant.Msg;
import gob.df.sds.sinai.web.service.security.LoginService;

@Controller
public class LoginController extends AbstractController {
	
  private LoginService service;
  
  public void setService(LoginService service) {
	this.service = service;
  }

  @RequestMapping("searchParams")
  public String  setupSingUp(ModelMap model){
	 model.addAttribute("userCredential", new UserCredential()); 
     return "security/login";
  }
  
  @RequestMapping("/singUp.do")
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
	  model.addAttribute("errMessage", errorMessage);
	  model.addAttribute("userCredential", userCredential); 
	  return "security/login";
	}
	session.setAttribute("session", service.getSession(credential.getUserId()));
    return "layout/container";
  }

}
