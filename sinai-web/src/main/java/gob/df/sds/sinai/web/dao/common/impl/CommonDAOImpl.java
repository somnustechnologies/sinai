package gob.df.sds.sinai.web.dao.common.impl;

import java.util.List;

import gob.df.sds.sinai.web.bean.vo.MasterUser;
import gob.df.sds.sinai.web.bean.vo.Position;
import gob.df.sds.sinai.web.bean.vo.Profile;
import gob.df.sds.sinai.web.dao.security.mapper.MasterUserMapper;
import gob.df.sds.sinai.web.model.GenericDAO;


@SuppressWarnings("unchecked")
public class CommonDAOImpl extends GenericDAO {
	
  public List<Profile> getProfiles(){
	String sqlQuery = "SELECT * FROM SEC_PROFILES";
	return (List<Profile>) getJdbcTemplate().query(sqlQuery
			                , getMapperFor(Profile.class));
  }
	
  public List<Position> getPositions(){
	String sqlQuery = "SELECT * FROM POSITIONS";
	return (List<Position>) getJdbcTemplate().query(sqlQuery
				                , getMapperFor(Position.class));
  }
	
  public MasterUser getMasterUser(Integer userId){
	String sqlQuery = "SELECT * " 
		            + "FROM SEC_USERS USR, SEC_USER_CREDENTIALS CRED, " 
                    + "     SEC_PROFILES PFL, SEC_USER_PROFILES USR_PFL "
                    + "WHERE USR.ID = ? " 
                    + "      AND CRED.USER_ID = USR.ID "
                    + "      AND USR_PFL.USER_ID = USR.ID "
                    + "      AND USR_PFL.PROFILE_ID = PFL.ID";
	return (MasterUser) getJdbcTemplate().queryForObject(sqlQuery
	              , new Object[]{userId},new MasterUserMapper());
  }

}
