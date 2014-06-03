package gob.df.sds.sinai.web.view.administration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import gob.df.sds.sinai.web.bean.criteria.UserCriteria;
import gob.df.sds.sinai.web.bean.vo.MasterUser;
import gob.df.sds.sinai.web.constant.Attr;
import gob.df.sds.sinai.web.constant.Maps;
import gob.df.sds.sinai.web.constant.Msg;
import gob.df.sds.sinai.web.constant.Views;
import gob.df.sds.sinai.web.exception.CommonException;
import gob.df.sds.sinai.web.service.administration.UserAdminService;

import static gob.df.sds.sinai.web.constant.Literals.*;

@Controller
@SessionAttributes(Attr.SES_LAST_SEARCH_PARAMS)
public class UserAdministrationController {
	
  private UserAdminService service;
	
  public void setService(UserAdminService service) {
	this.service = service;
  }

  @RequestMapping(Maps.SETUP_USERS)
  public String  setupSearchUser(ModelMap model){
    model.addAttribute(Attr.REQ_PROFILES, service.getProfiles()); 
    model.addAttribute(Attr.REQ_SEARCH_PARAMS, new UserCriteria());
    return Views.USERS;
  }
  
  @RequestMapping(Maps.SEARCH_USERS)
  public String  searchUser(@ModelAttribute(Attr.REQ_SEARCH_PARAMS) UserCriteria
		                                         searchParams, ModelMap model) {
	model.addAttribute(Attr.SES_LAST_SEARCH_PARAMS,searchParams);
    model.addAttribute(Attr.REQ_MASTER_USERS, service
    		                                  .searchMasterUsers(searchParams)); 
    return Views.USERS_TABLE;
  }

  @RequestMapping(Maps.SETUP_DELETE_USER)
  public String  setupDeleteUser(ModelMap model) {
	  return Views.DELETE_USER;
  }
  
  @RequestMapping(Maps.DELETE_USERS)
  public String  deleteUser(@RequestParam String chainIds, ModelMap model) {
	service.deleteMasterUsers(chainIds);
	model.addAttribute(Attr.REQ_INF_MESSAGE, Msg.DELETE_USERS_OK);
	return searchUser((UserCriteria) model.get(Attr.SES_LAST_SEARCH_PARAMS)
			                                                      , model);
  } 
  
  @RequestMapping(Maps.SETUP_CREATE_USER)
  public String  setupCreateUser(ModelMap model) {
	  model.addAttribute(Attr.REQ_PROFILES, service.getProfiles()); 
	  model.addAttribute(Attr.REQ_NEW_MASTER_USER, new MasterUser());
	  return Views.CREATE_USER;
  }
  
  @RequestMapping(Maps.CREATE_USER)
  public String  CreateUser(@ModelAttribute MasterUser newMasterUser
		                    , ModelMap model) throws CommonException {
	  UserCriteria searchUserParams = new UserCriteria(SEARCH_TYPE_ID_MAIL
			                         , newMasterUser.getUser().getMail());
	  if(service.existUserMail(newMasterUser.getUser().getMail())){
		  model.addAttribute(Attr.REQ_ERR_MESSAGE, Msg.BAD_USER_MAIL);
	  } else if(service.existUserNickName(newMasterUser.getCredential()
			                                          .getNickName())){
		  model.addAttribute(Attr.REQ_ERR_MESSAGE, Msg.BAD_USER_NICK_NAME);
	  } else {
	      service.insertMasterUser(newMasterUser);
	      model.addAttribute(Attr.REQ_INF_MESSAGE, Msg.ADD_USER_OK);
	  }
	  return searchUser(searchUserParams, model);
  }
  
  @RequestMapping(Maps.SETUP_UPDATE_USER_INFORMATION)
  public String  setupUpdateUser(@RequestParam Integer userId, ModelMap model) {
	  model.addAttribute(Attr.REQ_MASTER_USER, service.getMasterUser(userId));
	  model.addAttribute(Attr.REQ_PROFILES, service.getProfiles()); 
	  return Views.EDIT_USER;
  }
  
  @RequestMapping(Maps.UPDATE_USER_INFORMATION)
  public String  updateUser(@ModelAttribute MasterUser masterUser, ModelMap model) {
	  service.updateMasterUserInformation(masterUser);
	  model.addAttribute(Attr.REQ_INF_MESSAGE, Msg.UPDATE_USER_OK);
	  return searchUser((UserCriteria) model.get(Attr.SES_LAST_SEARCH_PARAMS)
                                                                    , model);
  }

}
