package gob.df.sds.sinai.web.bean.dto;

import gob.df.sds.sinai.web.model.GenericBean;

public class SecProfileAuthorityDTO extends GenericBean{
	
	private Integer authorityId;
	private Integer profileId;
	private Integer accessTypeId;
	
	public Integer getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}
	public Integer getProfileId() {
		return profileId;
	}
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}
	public Integer getAccessTypeId() {
		return accessTypeId;
	}
	public void setAccessTypeId(Integer accessTypeId) {
		this.accessTypeId = accessTypeId;
	}
	
}
