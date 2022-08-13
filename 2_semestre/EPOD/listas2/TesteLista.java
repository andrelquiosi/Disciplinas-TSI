package utfpr.pena.ed.listas;

public class TesteLista {
	
	public static void main(String []args) {
		
		ListaLigada<Integer> lista = new ListaLigada<>();
		
		lista.addInicio(1);
		
		lista.addInicio(5);
		
		lista.addInicio(7);
		
		lista.addFim(10);
		
		System.out.println(lista);
		
		System.out.println(lista.removeInicio());
		
		System.out.println(lista);
		
		ListaLigada<Aluno> lista2 = new ListaLigada<>();
		
		lista2.addFim(new Aluno("joao","2241"));
		lista2.addFim(new Aluno("ana","2399"));
		
		
		System.out.println(lista2);
		
		
	}

}

