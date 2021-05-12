package mc322.lab06;

public class Montador {
	/* Atributos */
	public Caverna caverna_principal;
	private int contador_wumpus;
	private int contador_buraco;
	private int contador_heroi;
	private int contador_ouro;

    /* Métodos */
	Montador() {
		this.caverna_principal = new Caverna();
	}

    public boolean montarCaverna(String[] vetor_celulas) {
		boolean validar = true;

		if (contador_wumpus > 1 || contador_heroi > 1 || contador_ouro > 1 || contador_buraco > 3) {
			return false;
		}
		else {
			/* Percorrendo o vetor com as posições da caverna */
			for (int i = 0; i < vetor_celulas.length; i++) {
				char[] posicao_atual = vetor_celulas[i].toCharArray();
				Componentes novo_componente; /* Componente que será adicionado na Caverna */

				/* Encontrando a linha e a coluna da caverna, onde o componente se encontra */
				int linha_componente = posicao_atual[0] - '1', coluna_componente = posicao_atual[2] - '1';
				/* Instanciando o novo componente */
				if (posicao_atual[4] == 'P') {
					novo_componente = new Heroi(linha_componente, coluna_componente, 'P', this.caverna_principal);
					if (linha_componente != 0 || coluna_componente != 0) {
						return false;
					}
					contador_heroi++;
				}
				else if (posicao_atual[4] == 'O') {
					novo_componente = new Ouro(linha_componente, coluna_componente, 'O', this.caverna_principal);
					contador_ouro++;
				}
				else if (posicao_atual[4] == 'B') {
					novo_componente = new Buraco(linha_componente, coluna_componente, 'B', this.caverna_principal);
					contador_buraco++;
				}
				else if (posicao_atual[4] == 'W') {
					novo_componente = new Wumpus(linha_componente, coluna_componente, 'W', this.caverna_principal);
					contador_wumpus++;
				}
				else /* Caso a posição seja vazia (_) */ {
					novo_componente = null;
				}

				/* Verificar se o novo componente não é vazio */
				if (novo_componente != null) {
					/* Caso a inserção seja valida, o componente será adicionado na sala da caverna */
					if (novo_componente.solicitarInclusao()) {
					/* Caso o componente tenha sido adicionado na caverna, se esse componente for um Wumpus ou um Buraco,
					suas respectivas classes secundárias serão criadas */
						if (novo_componente.simbolo == 'W' || novo_componente.simbolo == 'B') {
							novo_componente.inserirSecundarios();
						}
					}
					/* Caso a inserção seja invalida, o componente não será adiconado na sala da caverna e será avisado
					para a Classe de controle que a caverna é invalida */
					else {
						validar = false;
						break;
					}
				}
			}
		}
		/* Verificando se a caverna possui o número mínimo de cada Componente */
		if (contador_buraco < 2 || contador_ouro < 1 || contador_wumpus < 1 || contador_heroi < 1) {
			return false;
		}

    	/* Retorna para a função de controle se a caverna é valida ou não */
    	return validar;
    }
}
