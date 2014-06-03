package gob.df.sds.sinai.web.service.administration;

import java.util.List;

import gob.df.sds.sinai.web.bean.criteria.UserCriteria;
import gob.df.sds.sinai.web.bean.vo.MasterUser;
import gob.df.sds.sinai.web.bean.vo.Profile;
import gob.df.sds.sinai.web.exception.CommonException;


public interface UserAdminService {
	
	public List<Profile> getProfiles();
	public List<MasterUser> searchMasterUsers(UserCriteria searchParams);
	public MasterUser getMasterUser(Integer userId);
	public void insertMasterUser(MasterUser masterUser) throws CommonException;
	public void updateMasterUserInformation(MasterUser masterUser);
	public void deleteMasterUsers(String chainIds);
	public boolean existUserMail(String mail);
	public boolean existUserNickName(String nickName);
}
