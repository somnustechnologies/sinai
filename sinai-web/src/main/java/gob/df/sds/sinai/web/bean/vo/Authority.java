package gob.df.sds.sinai.web.bean.vo;

import gob.df.sds.sinai.web.bean.dto.SecAuthorityDTO;

public class Authority extends SecAuthorityDTO{
	
	private Boolean isOnlyRead;

	public Boolean getIsOnlyRead() {
		return isOnlyRead;
	}

	public void setIsOnlyRead(Boolean isOnlyRead) {
		this.isOnlyRead = isOnlyRead;
	}

}
