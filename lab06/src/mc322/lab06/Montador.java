package mc322.lab06;

public class Montador {
	/* Atributos */
	private Caverna caverna_montador;

    /* Métodos */
	Montador() {
		this.caverna_montador = new Caverna();
	}

    boolean montarCaverna(String[] vetor_posicoes) {
		/* Percorrendo o vetor com as posições da caverna */
    	for (int i = 0; i < vetor_posicoes.length ; i++) {
    		char[] posicao_atual = vetor_posicoes[i].toCharArray();
    		Componentes novo_componente;
    		/* Encontrando a linha e a coluna da caverna, onde o componente se encontra */
    		int linha_componente = posicao_atual[0], coluna_componente = posicao_atual[2];
    		/* Instanciando o novo componente */
			if (posicao_atual[4] == 'P') {
				novo_componente = new Heroi(linha_componente, coluna_componente, 'P', caverna_montador);;
			}
			else if (posicao_atual[4] == 'O') {
				novo_componente = new Ouro(linha_componente, coluna_componente, 'O', caverna_montador);
			}
			else if (posicao_atual[4] == 'B') {
				novo_componente = new Buraco(linha_componente, coluna_componente, 'B', caverna_montador);
			}
			else /* Caso seja 'W' */ {
				novo_componente = new Wumpus(linha_componente, coluna_componente, 'W', caverna_montador);
			}
		}
    }
}
