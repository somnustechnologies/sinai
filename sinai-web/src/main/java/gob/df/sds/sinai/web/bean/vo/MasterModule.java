package gob.df.sds.sinai.web.bean.vo;

import java.util.List;

public class MasterModule {
	
	private Module module;
	List<Authority> autorities;
	
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public List<Authority> getAutorities() {
		return autorities;
	}
	public void setAutorities(List<Authority> autorities) {
		this.autorities = autorities;
	}
	
	

}
