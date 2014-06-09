package gob.df.sds.sinai.common.exception.core;

import gob.df.sds.sinai.common.exception.AbstractException;

public class SystemException extends AbstractException {

	  public SystemException() {
	    super();
	  }

	  public SystemException(final String message) {
	    super(message);
	  }

	  public SystemException(final String message, final Throwable cause) {
	    super(message, cause);
	  }

	  public SystemException(final Throwable cause) {
	    super(cause);
	  }

	}