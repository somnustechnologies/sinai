package gob.df.sds.sinai.common.controller.core;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import gob.df.sds.sinai.common.controller.AbstractController;

@Controller
public class ErrorController extends AbstractController{
	
  @RequestMapping("/error/pageNotFound.do")
  public String  pageNotFound(ModelMap model){
    return "common/pageNotFound";
  }

}
