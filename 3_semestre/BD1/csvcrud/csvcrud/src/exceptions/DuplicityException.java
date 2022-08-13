package exceptions;

public class DuplicityException extends Exception {
  public DuplicityException() {
    super("Já existe um registro com o id informado");
  }
}
