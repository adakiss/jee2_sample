package hu.adakiss.sample.exception;

public class SampleAppException extends RuntimeException {

  private static final long serialVersionUID = 5918671167143241401L;

  public SampleAppException(final String message) {
    super(message);
  }
}
