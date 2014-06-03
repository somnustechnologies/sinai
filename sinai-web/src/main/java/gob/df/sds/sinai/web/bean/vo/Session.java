package gob.df.sds.sinai.web.bean.vo;

import java.util.List;

public class Session {
	
	private User user;
	private Profile profile; 
	private Authority activeAuthority;
	private List<MasterModule> masterModules;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Authority getActiveAuthority() {
		return activeAuthority;
	}
	public void setActiveAuthority(Authority activeAuthority) {
		this.activeAuthority = activeAuthority;
	}
	public List<MasterModule> getMasterModules() {
		return masterModules;
	}
	public void setMasterModules(List<MasterModule> masterModules) {
		this.masterModules = masterModules;
	}
	
}
