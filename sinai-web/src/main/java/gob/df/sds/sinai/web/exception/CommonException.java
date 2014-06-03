package gob.df.sds.sinai.web.exception;

import gob.df.sds.sinai.web.model.GenericException;


@SuppressWarnings("serial")
public class CommonException extends GenericException {

  public CommonException() {
    super();
  }

  public CommonException(final String message) {
    super(message);
  }

  public CommonException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public CommonException(final Throwable cause) {
    super(cause);
  }

}
