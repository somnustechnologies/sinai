package gob.df.sds.sinai.common.exception;

@SuppressWarnings("serial")
public abstract class AbstractException extends Exception {

  public AbstractException() {
    super();
  }

  public AbstractException(final String message) {
    super(message);
  }

  public AbstractException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public AbstractException(final Throwable cause) {
    super(cause);
  }

}
