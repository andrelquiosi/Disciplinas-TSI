package exe02;

public class TesteContas {

	public static void main(String[] args) {

		Corrente C1 = new Corrente("André", "123.456.789-1", "01/02/2020", 1000);
		Corrente C2 = new Corrente("Felipe", "125.455.785-2", "02/03/2021", 2000);
		Especial E1 = new Especial("Genesio", "456.456.789-8", "06/08/2020", 1000, 1000, 10.5);
		Investimento I1 = new Investimento("Caio", "123.741.789-5", "04/10/2020",0, 0.8);
		
		Conta[] contas = new Conta[] {C1,C2,E1,I1};
		
		//FILTRA POR CPF
		String CPF = "123.456.789-1";
		for(Conta s : contas) {
			if (s.getCPF().equals(CPF)) {
				s.setSaldo(50);//ADICIONAR SALDO A CONTA DO CPF ESPECIFICADO
				s.atualizar(0.2);//ATUALIZAR A CONTA DO CPF ESPECIFICADO
				
				System.out.println(s.toString());
			}
		}
		
	}

}
