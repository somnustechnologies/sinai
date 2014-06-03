package gob.df.sds.sinai.web.bean.dto;

import gob.df.sds.sinai.web.model.GenericBean;

public class SecUserProfileDTO extends GenericBean{
	
	private Integer userId;
	private Integer profileId;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProfileId() {
		return profileId;
	}
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

}
