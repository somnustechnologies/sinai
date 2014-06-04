package gob.df.sds.sinai.web.view.operation;

import gob.df.sds.sinai.web.bean.criteria.UserCriteria;
import gob.df.sds.sinai.web.constant.Attr;
import gob.df.sds.sinai.web.model.GenericController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AffiliateManagementController extends GenericController {

	
  @RequestMapping("/affiliateManagement/show.do")
  public String  setupSearch(ModelMap model){ 
	model.addAttribute(Attr.REQ_SEARCH_PARAMS, new UserCriteria());
    return "operation/affiliateManagement/searchAffiliate";
  }
  
  @RequestMapping("/affiliateManagement/search.do")
  public String  search(@ModelAttribute(Attr.REQ_SEARCH_PARAMS) UserCriteria
		                                         searchParams, ModelMap model) { 
	  return "operation/affiliateManagement/_affiliateTable";
  }
  
}
