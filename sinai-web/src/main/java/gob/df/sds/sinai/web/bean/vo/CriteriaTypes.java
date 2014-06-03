package gob.df.sds.sinai.web.bean.vo;

public class CriteriaTypes {
	
	private Integer id;
	private String name;
	
	public CriteriaTypes (Integer id, String name){
	  this.id = id;
	  this.name = name;
	}
	
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

}
