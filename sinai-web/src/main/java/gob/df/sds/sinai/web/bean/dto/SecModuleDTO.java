package gob.df.sds.sinai.web.bean.dto;

import gob.df.sds.sinai.web.model.GenericBean;

public class SecModuleDTO extends GenericBean{
	
	private Integer id;
	private String name;
	private String Description;
	private Integer sortKey;
	
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
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Integer getSortKey() {
		return sortKey;
	}
	public void setSortKey(Integer sortKey) {
		this.sortKey = sortKey;
	}

}
