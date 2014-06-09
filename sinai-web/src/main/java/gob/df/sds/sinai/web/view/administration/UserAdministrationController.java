package gob.df.sds.sinai.web.view.administration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import gob.df.sds.sinai.common.controller.AbstractController;
import gob.df.sds.sinai.common.exception.core.SystemException;
import gob.df.sds.sinai.web.bean.criteria.UserCriteria;
import gob.df.sds.sinai.web.bean.vo.MasterUser;
import gob.df.sds.sinai.web.constant.Msg;
import gob.df.sds.sinai.web.service.administration.UserAdminService;
import static gob.df.sds.sinai.web.constant.Literals.*;

@Controller
@SessionAttributes("lastSearchParams")
public class UserAdministrationController  extends AbstractController {
	
  private UserAdminService service;
	
  public void setService(UserAdminService service) {
	this.service = service;
  }

  @RequestMapping("/usersAdministration.do")
  public String  setupSearchUser(ModelMap model){
    model.addAttribute("profiles", service.getProfiles()); 
    model.addAttribute("searchParams", new UserCriteria());
    return "administration/user/searchUser";
  }
  
  @RequestMapping("/usersAdministration/seachUsers.do")
  public String  searchUser(@ModelAttribute("searchParams") UserCriteria
		                                 searchParams, ModelMap model) {
	model.addAttribute("lastSearchParams", searchParams);
    model.addAttribute("masterUsers", service.searchMasterUsers(searchParams)); 
    return "administration/user/_userTable";
  }

  @RequestMapping("/usersAdministration/setupDeleteUser.do")
  public String  setupDeleteUser(ModelMap model) {
	  return "administration/user/_deleteUser";
  }
  
  @RequestMapping("/usersAdministration/deleteUsers.do")
  public String  deleteUser(@RequestParam String chainIds, ModelMap model) {
	service.deleteMasterUsers(chainIds);
	model.addAttribute("infMessage", Msg.DELETE_USERS_OK);
	return searchUser((UserCriteria) model.get("lastSearchParams"), model);
  } 
  
  @RequestMapping("/usersAdministration/setupCreateUser.do")
  public String  setupCreateUser(ModelMap model) {
	  model.addAttribute("profiles", service.getProfiles()); 
	  model.addAttribute("newMasterUser", new MasterUser());
	  return "administration/user/_createUser";
  }
  
  @RequestMapping("/usersAdministration/createUser.do")
  public String  CreateUser(@ModelAttribute MasterUser newMasterUser
		                  , ModelMap model) throws SystemException {
	  UserCriteria searchUserParams = new UserCriteria(SEARCH_TYPE_ID_MAIL
			                         , newMasterUser.getUser().getMail());
	  if(service.existUserMail(newMasterUser.getUser().getMail())){
		  model.addAttribute("errMessage", Msg.BAD_USER_MAIL);
	  } else if(service.existUserNickName(newMasterUser.getCredential()
			                                          .getNickName())){
		  model.addAttribute("errMessage", Msg.BAD_USER_NICK_NAME);
	  } else {
	      service.insertMasterUser(newMasterUser);
	      model.addAttribute("infMessage", Msg.ADD_USER_OK);
	  }
	  return searchUser(searchUserParams, model);
  }
  
  @RequestMapping("/usersAdministration/setupUpdateUserInformation.do")
  public String  setupUpdateUser(@RequestParam Integer userId, ModelMap model) {
	  model.addAttribute("masterUser", service.getMasterUser(userId));
	  model.addAttribute("profiles", service.getProfiles()); 
	  return "administration/user/_editUserInformation";
  }
  
  @RequestMapping("/usersAdministration/updateUserInformation.do")
  public String  updateUser(@ModelAttribute MasterUser masterUser, ModelMap model) {
	  service.updateMasterUserInformation(masterUser);
	  model.addAttribute("infMessage", Msg.UPDATE_USER_OK);
	  return searchUser((UserCriteria) model.get("lastSearchParams"), model);
  }

}
