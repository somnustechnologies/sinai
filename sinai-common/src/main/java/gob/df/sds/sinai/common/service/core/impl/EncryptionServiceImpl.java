package gob.df.sds.sinai.common.service.core.impl;

import gob.df.sds.sinai.common.exception.core.SystemException;
import gob.df.sds.sinai.common.service.AbstractService;
import gob.df.sds.sinai.common.service.core.EncryptionService;

import java.security.MessageDigest;

//import org.apache.commons.codec.binary.Base64;

public class EncryptionServiceImpl extends AbstractService 
                            implements EncryptionService {
  private String algorithm;
	
  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }
	
  public Boolean compare(String plainInput, String encryptedInput) 
                                          throws SystemException {
    return encryptedInput.equals(encrypt(plainInput));
  }

  public String encrypt(String plainInput) throws SystemException {
    MessageDigest digester;
    String encyptedOutput ;
    try{
       digester = MessageDigest.getInstance(algorithm);
       digester.reset();
       digester.update(plainInput.getBytes());
       //encyptedOutput = new String((new Base64()).encode(digester.digest()));
    } catch(Exception e){
       throw new SystemException(e);
    }
    //return encyptedOutput;
    return null;
  }

}
