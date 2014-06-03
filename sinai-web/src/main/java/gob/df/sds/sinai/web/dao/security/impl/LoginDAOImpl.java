package gob.df.sds.sinai.web.dao.security.impl;

import java.util.List;

import gob.df.sds.sinai.web.bean.vo.Authority;
import gob.df.sds.sinai.web.bean.vo.Module;
import gob.df.sds.sinai.web.bean.vo.Profile;
import gob.df.sds.sinai.web.bean.vo.UserCredential;
import gob.df.sds.sinai.web.bean.vo.User;
import gob.df.sds.sinai.web.dao.security.LoginDAO;
import gob.df.sds.sinai.web.model.GenericDAO;

public class LoginDAOImpl extends GenericDAO implements LoginDAO {
  
  @SuppressWarnings("unchecked")
  public UserCredential getFullCredential(UserCredential credential) {
    String sqlQuery = "SELECT * FROM SEC_USER_CREDENTIALS CRED " 
				    + "WHERE CRED.NICK_NAME = ?";
    List<UserCredential> users = (List<UserCredential>)getJdbcTemplate()
                  .query(sqlQuery, new Object[]{credential.getNickName()}
                                      ,getMapperFor(UserCredential.class));
    return users.size()!=1?null:users.get(0);
  }
  
  public User getUser(Integer userId){
    String sqlQuery = "SELECT * FROM SEC_USERS USR " 
		              + "WHERE USR.ID = ?";
	return (User)getJdbcTemplate().queryForObject(sqlQuery, new Object[]{userId}
	                                               ,getMapperFor(User.class));
  }
  
  public Profile getProfile(Integer userId){
	  String sqlQuery = "SELECT * FROM SEC_PROFILES PFL " 
                      + "WHERE PFL.ID = (SELECT PROFILE_ID FROM SEC_USER_PROFILES" 
                       + "                USER_PRO WHERE USER_PRO.USER_ID = ?)";  
	  return (Profile)getJdbcTemplate().queryForObject(sqlQuery, new Object[]{userId}
                                               , getMapperFor(Profile.class));
  }
  
  @SuppressWarnings("unchecked")
  public List<Authority> getMasterAuthorities(Integer profileId
		                                           , Integer moduleId) {
	  String sqlQuery = "SELECT AUTH.ID ID, AUTH.DESCRIPTION DESCRIPTION, AUTH.MODULE_ID MODULE_ID " 
		              + "       , AUTH.NAME NAME, AUTH.TARGET TARGET, AUTH.SORT_KEY SORT_KEY "
		              + "       , PFL_AUTH.IS_ONLY_READ IS_ONLY_READ "
		              + "FROM SEC_AUTHORITIES AUTH, SEC_PROFILE_AUTHORITIES PFL_AUTH " 
		              + "WHERE  AUTH.ID = PFL_AUTH.AUTHORITY_ID " 
		              + "       AND PFL_AUTH.PROFILE_ID = ? "
		              + "       AND AUTH.MODULE_ID = ? " 
		              + "ORDER BY AUTH.SORT_KEY";
	  return (List<Authority>)getJdbcTemplate().query(sqlQuery
	       , new Object[]{profileId,moduleId}, getMapperFor(Authority.class));
  }
  
  @SuppressWarnings("unchecked")
  public List<Module> getModules(Integer profileId){
	  String sqlQuery = "SELECT * FROM SEC_MODULES MOL "
		              + "WHERE MOL.ID IN (SELECT DISTINCT(AUTH.MODULE_ID) "
		              + "                 FROM SEC_AUTHORITIES AUTH, SEC_PROFILE_AUTHORITIES PFL_AUTH "
		              + "                 WHERE AUTH.ID = PFL_AUTH.AUTHORITY_ID "
		              + "                       AND PFL_AUTH.PROFILE_ID = ?) "
		              + "ORDER BY MOL.SORT_KEY";
	  return (List<Module>)getJdbcTemplate().query(sqlQuery
	          , new Object[]{profileId}, getMapperFor(Module.class));
  }
  
  public void updateCredentials(UserCredential credentials){
	  String sqlQuery = "UPDATE SEC_USER_CREDENTIALS CRED SET CRED.ATTEMPS = ? "
		              + "      , CRED.LAST_LOGON = ? , CRED.LOCKED = ? " 
		              + "WHERE CRED.USER_ID = ? ";
	  getJdbcTemplate().update(sqlQuery, new Object[]{credentials.getAttemps()
			                , credentials.getLastLogon(), credentials.getLocked()
			                , credentials.getUserId()});
  }

}
