package gob.df.sds.sinai.web.bean.vo;

import gob.df.sds.sinai.common.bean.AbstractBean;

public class MasterUser extends AbstractBean {
	
	private User user;
	private UserCredential credential;
	private Profile profile;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserCredential getCredential() {
		return credential;
	}
	public void setCredential(UserCredential credential) {
		this.credential = credential;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}
