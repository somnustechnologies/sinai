package gob.df.sds.sinai.web.dao.common;

import java.util.List;

import gob.df.sds.sinai.web.bean.vo.MasterUser;
import gob.df.sds.sinai.web.bean.vo.Position;
import gob.df.sds.sinai.web.bean.vo.Profile;


public interface CommonDAO {
	
	public List<Profile> getProfiles();
	public MasterUser getMasterUser(Integer userId);
    public List<Position> getPositions();
}
