package mc322.lab06;

public class AppMundoWumpus 
{
	public static void main(String[] args) 
	{
		int loop = 0;
		while (loop == 0)
		{
			Montador teste = new Montador();
			/*String[] vetor_teste = {"1:1,P","1:2,_","1:3,_","1:4,B","2:1,_","2:2,_", "2:3,_","2:4,_","3:1,_","3:2,B","3:3,_",
			"3:4,_","4:1,_","4:2,_","4:3,_","4:4,W"};*/
			String[] vetor_teste = {"1:1,P","1:2,_","1:3,_","1:4,B","2:1,_","2:2,_", "2:3,_","2:4,_","3:1,_","3:2,B","3:3,_",
					"3:4,B","4:1,_","4:2,_","4:3,O","4:4,W"};
			if (teste.montarCaverna(vetor_teste)) {
				for (int i = 0; i < 4; i++) {
					System.out.println();
					for (int j = 0; j < 4; j++) {
						if (teste.caverna_principal.matriz_caverna[i][j].lista_sala.size() == 0) {
							System.out.print("-");
						}
						else {
							System.out.print(teste.caverna_principal.matriz_caverna[i][j].lista_sala.get(0).simbolo);
						}
					}
				}
			}
			else System.out.println("INVALIDO");
			Controle newsave = new Controle(teste.caverna_principal);
			boolean sair = newsave.jogo();
			if (sair = false) loop = 1;
		}
	}
}
