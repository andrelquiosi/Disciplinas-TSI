package exceptions;

public class EndOperationException extends Exception {

  public EndOperationException() {
    super("Operação cancelada");
  }

}
