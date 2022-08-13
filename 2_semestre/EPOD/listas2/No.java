package utfpr.pena.ed.listas;

/**
 *
 * @author pena
 */
public class No<T> {

   private T valor;
   private No<T> proximo;// referencia

   public No() {
   }

   public No(T valor) {
      this.valor = valor;
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

