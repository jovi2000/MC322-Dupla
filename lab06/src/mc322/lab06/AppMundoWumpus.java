package mc322.lab06;

public class AppMundoWumpus 
{
	public static void main(String[] args) 
	{
		boolean loop = true;
		while (loop)
		{
			Montador teste = new Montador();
			/*String[] vetor_teste = {"1:1,P","1:2,_","1:3,_","1:4,B","2:1,_","2:2,_", "2:3,_","2:4,_","3:1,_","3:2,B","3:3,_",
			"3:4,_","4:1,_","4:2,_","4:3,_","4:4,W"};*/
			String[] vetor_teste = {"1:1,P","1:2,_","1:3,_","1:4,B","2:1,_","2:2,_", "2:3,_","2:4,_","3:1,_","3:2,B","3:3,_",
					"3:4,B","4:1,_","4:2,_","4:3,O","4:4,W"};
			if (!teste.montarCaverna(vetor_teste)) {
				System.out.println("INVALIDO");
			}
			Controle newsave = new Controle(teste.heroi);
			loop = newsave.jogo();
		}
	}
}
