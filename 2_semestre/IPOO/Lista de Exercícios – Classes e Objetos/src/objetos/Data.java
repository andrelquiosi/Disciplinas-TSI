package objetos;

public class Data {
	
	int dia, mes,ano;

	public Data(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public String formatarData() {
		return "Data " + dia + "/" + mes + "/" + ano;
	}
	

}
