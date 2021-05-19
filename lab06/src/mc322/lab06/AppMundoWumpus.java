package mc322.lab06;

public class AppMundoWumpus {
	public static void main(String[] args) {
		AppMundoWumpus.executaJogo(args[0]);
	}

	static void executaJogo(String entrada) {

		/* Relizando os processos com a Classe CSVReader que resulta em um vetor com cada movimento que será realizado */
		CSVHandling csv = new CSVHandling();
		csv.setDataSource(entrada);
		String[][] commands = csv.requestCommands();

		/* Montando a caverna */
		Montador montar = new Montador();
		if (!montar.montarCaverna(commands)) {
			System.out.println("Caverna inválida!");
		}

		/* Começando o jogo */
		boolean jogar = true;
		while (jogar) {
			Controle novo_jogo = new Controle(montar.heroi);
			jogar = novo_jogo.jogo();
		}
	}
}

