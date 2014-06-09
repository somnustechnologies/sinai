package gob.df.sds.sinai.web.bean.dto;

import gob.df.sds.sinai.common.bean.AbstractBean;

public class SecUserProfileDTO extends AbstractBean {
	
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
