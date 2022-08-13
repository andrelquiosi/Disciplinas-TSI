package listas;

/**
 *
 * @author pena
 */
public class No<T> {

   private T valor;
   private No<T> proximo;// referencia


   public No(T valor) {
      this.valor = valor;
      this.proximo = null;
   }

   public T getValor() {
      return valor;
   }

   public void setValor(T valor) {
      this.valor = valor;
   }

   public No<T> getProximo() {
      return proximo;
   }

   public void setProximo(No<T> valor) {
      this.proximo = valor;
   }
}

