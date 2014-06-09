package gob.df.sds.sinai.web.dao.security.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import gob.df.sds.sinai.web.bean.vo.MasterUser;
import gob.df.sds.sinai.web.bean.vo.Profile;
import gob.df.sds.sinai.web.bean.vo.UserCredential;
import gob.df.sds.sinai.web.bean.vo.User;

public class MasterUserMapper implements RowMapper {

	public  Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		MasterUser masterUser = new MasterUser();
		masterUser.setUser(getUser(rs));
		masterUser.setCredential(getCredential(rs));
		masterUser.setProfile(getProfile(rs));
		return masterUser;
	}
	
	private User getUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt(1));
		user.setName(rs.getString(2));
		user.setLastName(rs.getString(3));
		user.setMiddleName(rs.getString(4));
		user.setMail(rs.getString(5));
		return user;
	}
	
	private UserCredential getCredential(ResultSet rs) throws SQLException {
		UserCredential credential = new UserCredential();
		credential.setUserId(rs.getInt(6));
		credential.setNickName(rs.getString(7));
		credential.setPassword(rs.getString(8));
		credential.setLastLogon(rs.getDate(9));
		credential.setExpireDate(rs.getDate(10));
		credential.setAttemps(rs.getInt(11));
		credential.setLocked(rs.getBoolean(12));
		return credential;
	}
	
	private Profile getProfile(ResultSet rs) throws SQLException {
		Profile profile = new Profile();
		profile.setId(rs.getInt(13));
		profile.setName(rs.getString(14));
		profile.setDescription(rs.getString(15));
		return profile;
	}
	
}
