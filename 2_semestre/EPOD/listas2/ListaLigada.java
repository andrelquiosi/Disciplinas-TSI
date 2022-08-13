package utfpr.pena.ed.listas;

import java.util.Iterator;

/**
 *
 * @author pena
 */
public class ListaLigada<T> implements Iterable<T> {

	
	
	private int size;
	private No<T> inicio;
	private No<T> fim;

	public No<T> getInicio() {
		return inicio;
	}

	public No<T> getFim() {
		return fim;
	}

	public int getSize() {
		return size;
	}

	public void addInicio(T valor) {
		No<T> novoNo = new No<T>(valor);
		novoNo.setProximo(inicio);
		inicio = novoNo;

		if (this.isEmpty()) {
			fim = inicio;
		}

		size++;
	}

	public void addFim(T valor) {
		No<T> novoNo = new No<T>(valor);

		if (this.isEmpty()) {
			inicio = novoNo;
			fim = inicio;
		} else {
			fim.setProximo(novoNo);
			fim = novoNo;
		}

		size++;
	}

	public T removeInicio() {
		if (this.isEmpty()) {
			return null;
		}

		T valor = inicio.getValor();
		inicio = inicio.getProximo();
		size--;

		return valor;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public T inicio() {
		return inicio.getValor();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			No<T> atual = inicio;

			@Override
			public boolean hasNext() {
				return atual != null;
			}

			@Override
			public T next() {
				if (hasNext()) {
					T data = atual.getValor();
					atual = atual.getProximo();
					return data;
				}
				return null;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("Nao implementado.");
			}

		};
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		Iterator<T> it = iterator();

		sb.append("[");
		while (it.hasNext()) {
			sb.append(it.next() + ",");
		}
		sb.setCharAt(sb.length() - 1, ']');

		return sb.toString();
	}

}
