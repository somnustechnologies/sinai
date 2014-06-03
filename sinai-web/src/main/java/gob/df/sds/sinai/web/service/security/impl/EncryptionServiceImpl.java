package gob.df.sds.sinai.web.service.security.impl;

import java.security.MessageDigest;

import gob.df.sds.sinai.web.exception.CommonException;
import gob.df.sds.sinai.web.model.GenericService;
import gob.df.sds.sinai.web.service.security.EncryptionService;

//import org.apache.commons.codec.binary.Base64;

public class EncryptionServiceImpl extends GenericService 
                               implements EncryptionService {
  private String algorithm;
	
  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }
	
  public Boolean compare(String plainInput, String encryptedInput) 
                                          throws CommonException {
    return encryptedInput.equals(encrypt(plainInput));
  }

  public String encrypt(String plainInput) throws CommonException {
    MessageDigest digester;
    String encyptedOutput ;
    try{
       digester = MessageDigest.getInstance(algorithm);
       digester.reset();
       digester.update(plainInput.getBytes());
       //encyptedOutput = new String((new Base64()).encode(digester.digest()));
    } catch(Exception e){
       throw new CommonException(e);
    }
    //return encyptedOutput;
    return null;
  }

}
