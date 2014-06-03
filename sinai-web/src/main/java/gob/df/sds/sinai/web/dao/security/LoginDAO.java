package gob.df.sds.sinai.web.dao.security;

import java.util.List;

import gob.df.sds.sinai.web.bean.vo.Authority;
import gob.df.sds.sinai.web.bean.vo.Module;
import gob.df.sds.sinai.web.bean.vo.Profile;
import gob.df.sds.sinai.web.bean.vo.UserCredential;
import gob.df.sds.sinai.web.bean.vo.User;


public interface LoginDAO {
	
	public UserCredential getFullCredential(UserCredential credential);
	public User getUser(Integer userId);
	public Profile getProfile(Integer userId);
	public List<Authority> getMasterAuthorities(Integer profileId, Integer moduleId);
	public List<Module> getModules(Integer profileId);
	public void updateCredentials(UserCredential credentials);

}
