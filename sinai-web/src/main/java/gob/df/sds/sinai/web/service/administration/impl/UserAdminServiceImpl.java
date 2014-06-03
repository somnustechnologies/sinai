package gob.df.sds.sinai.web.service.administration.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gob.df.sds.sinai.web.bean.criteria.UserCriteria;
import gob.df.sds.sinai.web.bean.vo.MasterUser;
import gob.df.sds.sinai.web.bean.vo.Profile;
import gob.df.sds.sinai.web.dao.administration.UserAdminDAO;
import gob.df.sds.sinai.web.exception.CommonException;
import gob.df.sds.sinai.web.service.administration.UserAdminService;
import gob.df.sds.sinai.web.service.security.EncryptionService;
import gob.df.sds.sinai.web.util.Utilities;

import static gob.df.sds.sinai.web.constant.Literals.*;

public class UserAdminServiceImpl implements UserAdminService{
	
  private UserAdminDAO dao;
  private EncryptionService encrypter;

  public void setEncrypter(EncryptionService encrypter) {
	this.encrypter = encrypter;
  }

  public void setDao(UserAdminDAO dao) {
    this.dao = dao;
  }
	
  public List<MasterUser> searchMasterUsers(UserCriteria searchParams){
	List<MasterUser> masterUsers = new ArrayList<MasterUser>();
	if(searchParams != null){
		masterUsers = dao.searchMasterUsers(searchParams);
	}
    return masterUsers;
  }
	
  public List<Profile> getProfiles(){
    return dao.getProfiles();
  }
	
  public MasterUser getMasterUser(Integer userId){
    return dao.getMasterUser(userId);
  }
	
  public void deleteMasterUsers(String chainIds){
	String [] userIds = chainIds.split(MARK_COMMA);
	for(int i=0;i<userIds.length;i++){
	   dao.deleteMasterUser(new Integer(userIds[i]));	
	}
  }
  
  public void insertMasterUser(MasterUser masterUser) throws CommonException{
	  String randomPassword =  Utilities.getRandomString(8);
	  masterUser.getCredential().setAttemps(0);
	  masterUser.getCredential().setExpireDate(new Date());
	  masterUser.getCredential().setLastLogon(new Date());
	  masterUser.getCredential().setPassword(encrypter.encrypt(masterUser
			          .getCredential().getNickName() +  randomPassword));
	  dao.insertMasterUser(masterUser);
	  System.out.println(randomPassword);
  }
  
  public void updateMasterUserInformation(MasterUser masterUser){
	  dao.updateMasterUserInformation(masterUser);
  }
  
  public boolean existUserMail(String mail){
	  return dao.findUserIdByMail(mail) != null;
  }
  
  public boolean existUserNickName(String nickName){
	  return dao.findUserIdByNickName(nickName) != null;
  }

}
