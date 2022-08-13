package exceptions;

public class ConnectionRefusedException extends Exception {
  public ConnectionRefusedException() {
    super("Conexão Recusada: Este registro já está sendo acessado!");
  }
}
