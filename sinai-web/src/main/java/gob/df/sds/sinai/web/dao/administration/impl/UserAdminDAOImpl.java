package gob.df.sds.sinai.web.dao.administration.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import gob.df.sds.sinai.web.bean.criteria.UserCriteria;
import gob.df.sds.sinai.web.bean.vo.MasterUser;
import gob.df.sds.sinai.web.bean.vo.Profile;
import gob.df.sds.sinai.web.bean.vo.UserCredential;
import gob.df.sds.sinai.web.bean.vo.UserProfile;
import gob.df.sds.sinai.web.bean.vo.User;
import gob.df.sds.sinai.web.dao.administration.UserAdminDAO;
import gob.df.sds.sinai.web.dao.common.impl.CommonDAOImpl;
import gob.df.sds.sinai.web.dao.security.mapper.MasterUserMapper;

import static gob.df.sds.sinai.web.constant.Literals.*;

@SuppressWarnings("unchecked")
public class UserAdminDAOImpl extends CommonDAOImpl 
                 implements UserAdminDAO {
	
  public List<MasterUser> searchMasterUsers(UserCriteria searchParams) {
    String sqlQuery = "SELECT * FROM SEC_USERS USR, SEC_USER_CREDENTIALS CRED, " 
		            + "              SEC_PROFILES PFL, SEC_USER_PROFILES USR_PFL "
		            + "WHERE USR.ID = CRED.USER_ID "
		            + "      AND USR_PFL.USER_ID = USR.ID "
		            + "      AND USR_PFL.PROFILE_ID = PFL.ID ";
    List<Object> params = new ArrayList<Object>();
    if(searchParams.getCriteriaType() != null){
      if(searchParams.getCriteriaType().equals(SEARCH_TYPE_ID_NAME)){
        sqlQuery += "AND CONCAT(USR.NAME,' ',USR.LAST_NAME,' ',USR.MIDDLE_NAME) LIKE ? " ;
        params.add("%" + searchParams.getCriteriaValue() + "%");
      } else if(searchParams.getCriteriaType().equals(SEARCH_TYPE_ID_NICK)) {
        sqlQuery += "AND (CRED.NICK_NAME LIKE ?) ";
        params.add("%" + searchParams.getCriteriaValue() + "%");
      } else if(searchParams.getCriteriaType().equals(SEARCH_TYPE_ID_MAIL)){
        sqlQuery += "AND USR.MAIL LIKE ? ";
        params.add("%" + searchParams.getCriteriaValue() + "%");
      } else if(searchParams.getCriteriaType().equals(SEARCH_TYPE_ID_PROFILE)){
          sqlQuery += "AND PFL.ID = ? ";
          params.add(searchParams.getCriteriaValue());
      }
    }
    if(searchParams.getOnlyLocked()){
      sqlQuery += "AND CRED.LOCKED = ?";
      params.add(true);
    }
	return (List<MasterUser>) getJdbcTemplate().query(sqlQuery, params
			                        .toArray(), new MasterUserMapper());
	}
	
  public void insertMasterUser(MasterUser masterUser){
    Integer newUserId;
    insertUser(masterUser.getUser());
    newUserId = findUserIdByMail(masterUser.getUser().getMail());
    masterUser.getCredential().setUserId(newUserId);
    insertUserCredential(masterUser.getCredential());
    insertUserProfile(new UserProfile(newUserId, masterUser.getProfile()
		    		                                           .getId()));
  }
	  
  public void deleteMasterUser(Integer userId){
    deleteUserCredential(userId);
    deleteUserProfile(userId);
    deleteUser(userId);
  }
  
  
  public Integer findUserIdByMail(String mail){
	  Integer userId;
	  String sqlQuery = "SELECT ID FROM SEC_USERS WHERE MAIL = ?";
	  try{
		  userId = getJdbcTemplate().queryForInt(sqlQuery, new Object[]{mail});
	  } catch(EmptyResultDataAccessException erde) {
		  userId = null;
	  }
	  return userId;
  }
  
  public Integer findUserIdByNickName(String nickName){
    Integer userId;
    String sqlQuery = "SELECT USER_ID FROM SEC_USER_CREDENTIALS WHERE NICK_NAME = ?";
    try{
       userId = getJdbcTemplate().queryForInt(sqlQuery, new Object[]{nickName});
	} catch (EmptyResultDataAccessException erde) {
	   userId = null;
	}
	return userId;
  }
  
  public void updateMasterUserInformation(MasterUser masterUser) {
    updateUser(masterUser.getUser());
    updateUserProfile(masterUser.getProfile(), masterUser.getUser());
  }
  
  private void deleteUser(Integer userId){
    String sqlQuery = "DELETE FROM SEC_USERS WHERE ID = ?";
    getJdbcTemplate().update(sqlQuery, new Object[]{userId});
  }
	
  private void deleteUserCredential(Integer userId){
    String sqlQuery = "DELETE FROM SEC_USER_CREDENTIALS WHERE USER_ID = ?";
    getJdbcTemplate().update(sqlQuery, new Object[]{userId});
  }
	
  private void deleteUserProfile(Integer userId){
    String sqlQuery = "DELETE FROM SEC_USER_PROFILES WHERE USER_ID = ?";
    getJdbcTemplate().update(sqlQuery, new Object[]{userId});
  }
	
  private void insertUser(User user){
    String sqlQuery = "INSERT INTO SEC_USERS (NAME, LAST_NAME, MIDDLE_NAME, MAIL) " 
    	            + " VALUES (?,?,?,?)";
    getJdbcTemplate().update(sqlQuery, new Object[]{user.getName(), user
				 .getLastName(), user.getMiddleName(), user.getMail()});
  }
  
  private void insertUserCredential(UserCredential userCredential){
    String sqlQuery = "INSERT INTO SEC_USER_CREDENTIALS VALUES (?,?,?,?,?,?,?)";
    getJdbcTemplate().update(sqlQuery, new Object[]{userCredential.getUserId()
    		, userCredential.getNickName(), userCredential.getPassword()
    		, userCredential.getLastLogon(), userCredential.getExpireDate()
    		, userCredential.getAttemps(), userCredential.getLocked()});
    
  }  
  
  private void insertUserProfile(UserProfile userProfile){
	  String sqlQuery = "INSERT INTO SEC_USER_PROFILES VALUES (?,?)";
	  getJdbcTemplate().update(sqlQuery, new Object[]{userProfile.getUserId()
			                                  , userProfile.getProfileId()});
  }
  
  private void updateUser(User user){
	  String sqlQuery = "UPDATE SEC_USERS SET NAME = ?, LAST_NAME= ?" 
		              + "                   , MIDDLE_NAME = ?, MAIL = ? " 
		              + "WHERE ID = ?";
	  getJdbcTemplate().update(sqlQuery, new Object[]{user.getName()
			          , user.getLastName(), user.getMiddleName(), user.getMail()
			                                                   , user.getId()});
  }
  
  private void updateUserProfile(Profile profile, User user){
	  String sqlQuery = "UPDATE SEC_USER_PROFILES SET PROFILE_ID = ? "
		              + "WHERE USER_ID = ?";
	  getJdbcTemplate().update(sqlQuery, new Object[]{profile.getId()
			                                        , user.getId()});
	  
  }
}
