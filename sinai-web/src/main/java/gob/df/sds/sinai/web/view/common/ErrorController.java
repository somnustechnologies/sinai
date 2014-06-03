package gob.df.sds.sinai.web.view.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import gob.df.sds.sinai.web.constant.Maps;
import gob.df.sds.sinai.web.constant.Views;
import gob.df.sds.sinai.web.model.GenericController;

@Controller
public class ErrorController extends GenericController{
	
  @RequestMapping(Maps.PAGE_NOT_FOUND)
  public String  pageNotFound(ModelMap model){
    return Views.PAGE_NOT_FOUND;
  }

}
