package gob.df.sds.sinai.web.bean.dto;

import java.util.Date;

import gob.df.sds.sinai.web.model.GenericBean;

public class SecUserCredentialDTO extends GenericBean {
	
	private Integer userId;
	private String nickName;
	private String password;
	private Date lastLogon;
	private Date expireDate;
	private Integer attemps;
	private Boolean locked;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastLogon() {
		return lastLogon;
	}
	public void setLastLogon(Date lastLogon) {
		this.lastLogon = lastLogon;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public Integer getAttemps() {
		return attemps;
	}
	public void setAttemps(Integer attemps) {
		this.attemps = attemps;
	}
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

}
