package gob.df.sds.sinai.common.util;

import java.util.Date;
import java.util.Random;

public class Utilities {
	
private static String validAlfaNumericCharacters = "ABCDEFGHIJKLMNOPQRSTWXYZabcdefghijklmnopqrstuvwxyz1234567890_-.,";

	
	public static String formatLeftZero(String string, int length){
		String formatedString = string;
		for(int i=string.length();i<length;i++){
			formatedString = "0" + formatedString;
		}
		return formatedString;
	}
	
	public static String notNull(Object string){
		if(string == null){
			return "";
		}
		return string.toString();
	}
	
  public static String getRandomString(Integer stringLenght){
    StringBuilder string = new StringBuilder();
    Random generator = new Random(new Date().getTime());
    for(int i=0;i<stringLenght;i++) {
      string.append(validAlfaNumericCharacters.charAt(generator
    		   .nextInt(validAlfaNumericCharacters.length())));
    }
    return string.toString();
  }

}
