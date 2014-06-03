package gob.df.sds.sinai.web.constant;

import java.text.SimpleDateFormat;

public final class Literals {
	
	public static final String REFERER = "referer";
	public static final String AUTHORITY_ID = "aid";
	public static final String SELECT = "SELECCIONE";
	public static final String NAME = "NOMBRE";
	public static final String NICK_NAME = "NICK";
	public static final String DESCRIPTION = "DESCRIPTION";
	public static final String MAIL = "E-MAIL";
	public static final String PROFILE = "PERFIL";
	public static final String PSEUDONYM = "SEUDONIMO";
	public static final String DRAWER = "CAJON";
	public static final String FORNITURE = "ESTANTE";
	public static final String LAST_NAME = "APELLIDO";
	public static final String PHONE = "TELEFONO";
	public static final String POSITION = "PUESTO";

	public static final Integer SEARCH_TYPE_ID_NAME = 1;
	public static final Integer SEARCH_TYPE_ID_NICK = 2;
	public static final Integer SEARCH_TYPE_ID_MAIL = 3;
	public static final Integer SEARCH_TYPE_ID_PROFILE = 4;
	public static final Integer SEARCH_TYPE_ID_DESCRIPTION = 5;
	public static final Integer SEARCH_TYPE_ID_PSEUDONYM = 6;
	public static final Integer SEARCH_TYPE_ID_DRAWER = 7;
	public static final Integer SEARCH_TYPE_ID_FORNITURE = 8;
	public static final Integer SEARCH_TYPE_ID_LAST_NAME = 9;
	public static final Integer SEARCH_TYPE_ID_PHONE = 10;
	public static final Integer SEARCH_TYPE_ID_POSITION = 11;
	
	public static final String MARK_AT = "@";
	public static final String MARK_DOT = ".";
	public static final String MARK_UNDERSCORE = "-";
	public static final String MARK_END_OF_FILE ="\\Z";
	public static final String MARK_SLASH ="/";
	public static final String MARK_SLASH_REV ="\\";
	public static final String MARK_COMMA =",";
	public static final String MARK_MONEY ="$";

	  
	public static final int NBR_ZERO = 0;
	public static final int NBR_ONE = 1;
	public static final int NBR_TWO = 2;
	  
	public static final String STR_BLANK = " ";
	public static final String STR_EMPTY = "";
	  
	public static final String STR_DATE_FORMAT = "dd/MM/yyyy"; 
	public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(STR_DATE_FORMAT);
}
