package gob.df.sds.sinai.web.model;

@SuppressWarnings("serial")
public abstract class GenericException extends Exception {

  public GenericException() {
    super();
  }

  public GenericException(final String message) {
    super(message);
  }

  public GenericException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public GenericException(final Throwable cause) {
    super(cause);
  }

}
