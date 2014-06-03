package gob.df.sds.sinai.web.bean.criteria;

import gob.df.sds.sinai.web.bean.vo.CriteriaTypes;

import java.util.Arrays;
import java.util.List;

import static gob.df.sds.sinai.web.constant.Literals.*;

public class UserCriteria {
	
	private List<CriteriaTypes> criteriaTypes;
	private Integer criteriaType;
	private String criteriaValue;
	private Boolean onlyLocked;

	public UserCriteria(){
      criteriaTypes = Arrays.asList(
                    new CriteriaTypes(SEARCH_TYPE_ID_NAME, NAME) 
                  , new CriteriaTypes(SEARCH_TYPE_ID_NICK, NICK_NAME)
                  , new CriteriaTypes(SEARCH_TYPE_ID_MAIL, MAIL)
                  , new CriteriaTypes(SEARCH_TYPE_ID_PROFILE, PROFILE));
	}
	
	public UserCriteria (Integer criteriaType, String criteriaValue) {
		this();
		this.criteriaType = criteriaType;
		this.criteriaValue = criteriaValue;
		this.onlyLocked = false;
	}

	public List<CriteriaTypes> getCriteriaTypes() {
		return criteriaTypes;
	}

	public void setCriteriaTypes(List<CriteriaTypes> criteriaTypes) {
		this.criteriaTypes = criteriaTypes;
	}

	public Integer getCriteriaType() {
		return criteriaType;
	}

	public void setCriteriaType(Integer criteriaType) {
		this.criteriaType = criteriaType;
	}

	public String getCriteriaValue() {
		return criteriaValue;
	}

	public void setCriteriaValue(String criteriaValue) {
		this.criteriaValue = criteriaValue;
	}

	public Boolean getOnlyLocked() {
		return onlyLocked;
	}

	public void setOnlyLocked(Boolean onlyLocked) {
		this.onlyLocked = onlyLocked;
	}

}
