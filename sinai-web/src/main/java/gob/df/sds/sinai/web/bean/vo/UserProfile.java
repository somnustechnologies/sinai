package gob.df.sds.sinai.web.bean.vo;

import gob.df.sds.sinai.web.bean.dto.SecUserProfileDTO;


public class UserProfile extends SecUserProfileDTO {
	
	public UserProfile(){
		
	}
	
	public UserProfile(Integer userId, Integer profileId){
		this.setUserId(userId);
		this.setProfileId(profileId);
	}
	

}
