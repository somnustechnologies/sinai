package gob.df.sds.sinai.web.bean.dto;

import gob.df.sds.sinai.common.bean.AbstractBean;

public class SecProfileDTO extends AbstractBean {
	
	private Integer id;
	private String name;
	private String description;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
