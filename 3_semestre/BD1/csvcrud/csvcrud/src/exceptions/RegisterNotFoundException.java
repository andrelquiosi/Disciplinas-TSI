package exceptions;

public class RegisterNotFoundException extends Exception {
  public RegisterNotFoundException() {
    super("Registro não encontrado");
  }
}
