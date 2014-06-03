package gob.df.sds.sinai.web.service.security;

import gob.df.sds.sinai.web.exception.CommonException;

public interface EncryptionService {
	
	public String encrypt(String plainInput) throws CommonException;
	public Boolean compare(String plainInput, String encryptedInput) 
	                                         throws CommonException;

}
