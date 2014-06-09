package gob.df.sds.sinai.web.service.security.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gob.df.sds.sinai.common.service.AbstractService;
import gob.df.sds.sinai.common.service.core.EncryptionService;
import gob.df.sds.sinai.web.bean.vo.Authority;
import gob.df.sds.sinai.web.bean.vo.MasterModule;
import gob.df.sds.sinai.web.bean.vo.Module;
import gob.df.sds.sinai.web.bean.vo.Profile;
import gob.df.sds.sinai.web.bean.vo.Session;
import gob.df.sds.sinai.web.bean.vo.UserCredential;
import gob.df.sds.sinai.web.bean.vo.User;
import gob.df.sds.sinai.web.dao.security.LoginDAO;
import gob.df.sds.sinai.web.service.security.LoginService;

public class LoginServiceImpl extends AbstractService implements LoginService{
	
	
  private LoginDAO dao;
  private EncryptionService encrypter;
	
  public void setDao(LoginDAO dao) {
    this.dao = dao;
  }

  public void setEncrypter(EncryptionService encrypter) {
	this.encrypter = encrypter;
  }

  public UserCredential getFullCredential(UserCredential credential){
    return dao.getFullCredential(credential);
  }
	
  public Boolean isPasswordCorrect(UserCredential toTestCredential
			                   , UserCredential credential) throws Exception {
    Boolean isPasswordCorrect = encrypter.compare(toTestCredential.getNickName() 
    		        + toTestCredential.getPassword(), credential.getPassword());
    saveLogonAttemp(credential, isPasswordCorrect);
    return isPasswordCorrect;
  }
	
  private void saveLogonAttemp(UserCredential credential, boolean successful) {
    if(successful){
      credential.setAttemps(0);
      credential.setLastLogon(new Date());
    } else {
      credential.setAttemps(credential.getAttemps() + 1);
      if(credential.getAttemps() >= 3){
        credential.setLocked(true);
      }
    }
    dao.updateCredentials(credential);
  }
  
  public Session getSession(Integer userId){
    Session session = new Session();
    List<MasterModule> masterModules = new ArrayList<MasterModule>();
    MasterModule masterModule;
    User user = dao.getUser(userId);
    Profile profile = dao.getProfile(userId);
    for(Module module: dao.getModules(profile.getId())){
    	masterModule = new MasterModule();
    	masterModule.setModule(module);
    	masterModule.setAutorities(shadowAuthorities(dao
    			       .getMasterAuthorities(profile.getId(), module.getId())));
    	masterModules.add(masterModule);
    }
    session.setUser(user);
    session.setProfile(profile);
    session.setMasterModules(masterModules);
    session.setActiveAuthority(new Authority());
    return session;
  }
  
  private List<Authority> shadowAuthorities(List<Authority> authorities){
	  Integer seed = null;
	  synchronized(Thread.currentThread()){
		  seed = (int) new Date().getTime();
	  }
	  for(int i=0;i<authorities.size();i++){
		  authorities.get(i).setId(authorities.get(i).getId() * seed);
	  }
	  return authorities;
  }

}
