package gob.df.sds.sinai.web.dao.administration;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import gob.df.sds.sinai.web.bean.criteria.UserCriteria;
import gob.df.sds.sinai.web.bean.vo.MasterUser;
import gob.df.sds.sinai.web.bean.vo.Profile;

public interface UserAdminDAO {
	
	public List<MasterUser> searchMasterUsers(UserCriteria searchParams);
	public Integer findUserIdByMail(String mail);
	public Integer findUserIdByNickName(String nickName);
	@Transactional(rollbackFor=Exception.class)
	public void insertMasterUser(MasterUser masterUser);
	@Transactional(rollbackFor=Exception.class)
	public void deleteMasterUser(Integer userId);
	@Transactional(rollbackFor=Exception.class)
	public void updateMasterUserInformation(MasterUser masterUser);
	public List<Profile> getProfiles();
	public MasterUser getMasterUser(Integer userId);

}
