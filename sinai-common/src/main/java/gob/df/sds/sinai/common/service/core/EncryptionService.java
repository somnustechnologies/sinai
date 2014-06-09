package gob.df.sds.sinai.common.service.core;

import gob.df.sds.sinai.common.exception.core.SystemException;

public interface EncryptionService {
	
	public String encrypt(String plainInput) throws SystemException;
	public Boolean compare(String plainInput, String encryptedInput) 
	                                         throws SystemException;

}
