package gob.df.sds.sinai.web.service.security;

import gob.df.sds.sinai.web.bean.vo.Session;
import gob.df.sds.sinai.web.bean.vo.UserCredential;

public interface LoginService {
	
	public UserCredential getFullCredential(UserCredential credential);
	public Boolean isPasswordCorrect(UserCredential toTestCredential
                      , UserCredential credential) throws Exception;
	public Session getSession(Integer userId);

}
