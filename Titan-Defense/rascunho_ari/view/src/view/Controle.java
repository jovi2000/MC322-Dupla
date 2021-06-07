package view;

public class Controle {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		CSVReader csv = new CSVReader();
		csv.setDataSource("/home/arima/Área de Trabalho/mc322/view/data/historia1.csv");
		String falas[] = csv.requestCommands();
		Janela j = new Janela();
		j.historia(falas);
		//j.monta();
	}

}