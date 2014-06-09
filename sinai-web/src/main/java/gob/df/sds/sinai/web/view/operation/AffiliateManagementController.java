package gob.df.sds.sinai.web.view.operation;

import gob.df.sds.sinai.common.controller.AbstractController;
import gob.df.sds.sinai.web.bean.criteria.UserCriteria;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AffiliateManagementController extends AbstractController {

	
  @RequestMapping("/affiliateManagement/show.do")
  public String  setupSearch(ModelMap model){ 
	model.addAttribute("searchParams", new UserCriteria());
    return "operation/affiliateManagement/searchAffiliate";
  }
  
  @RequestMapping("/affiliateManagement/search.do")
  public String  search(@ModelAttribute("searchParams") UserCriteria searchParams
		                                                      , ModelMap model) { 
	  return "operation/affiliateManagement/_affiliateTable";
  }
  
}
