package mc322.lab06;

import java.util.LinkedList;

public class Wumpus extends Componentes {
	/* Atributo */
	LinkedList<Integer> posicoes_fedores; /*  Os indices pares da lista são as linhas e o número seguinte de
	cada linha é sua respectiva coluna */

	public Wumpus(int linha, int coluna, char simbolo, Caverna caverna) {
		super(linha, coluna, simbolo, caverna);
		posicoes_fedores =  new LinkedList<Integer>();
	}

	/* O método em Wumpus tem uma diferença do método em Componentes, que é a atribuição do atributo poisicoes_fedores */
	public void inserirSecundarios() {

		/* Calculando todas as posicoes dos objetos da classe secundária */
		/* Posicao acima */
		int linha_secundaria = linha - 1, coluna_secundaria = coluna;
		if (dentroDaMatriz(linha_secundaria, coluna_secundaria)) {
			posicoes_fedores.add(linha_secundaria);
			posicoes_fedores.add(coluna_secundaria);
		}
		/* Posicao abaixo */
		linha_secundaria = linha + 1;
		coluna_secundaria = coluna;
		if (dentroDaMatriz(linha_secundaria, coluna_secundaria)) {
			posicoes_fedores.add(linha_secundaria);
			posicoes_fedores.add(coluna_secundaria);
		}
		/* Posicao a direita */
		linha_secundaria = linha;
		coluna_secundaria = coluna + 1;
		if (dentroDaMatriz(linha_secundaria, coluna_secundaria)) {
			posicoes_fedores.add(linha_secundaria);
			posicoes_fedores.add(coluna_secundaria);
		}
		/* Posicao a esquerda */
		linha_secundaria = linha;
		coluna_secundaria = coluna - 1;
		if (dentroDaMatriz(linha_secundaria, coluna_secundaria)) {
			posicoes_fedores.add(linha_secundaria);
			posicoes_fedores.add(coluna_secundaria);
		}

		/* Adicionando cada fedor na sala da caverna */
		for (int i = 0; i < posicoes_fedores.size(); i += 2) {
			Componentes novo_fedor = new Fedor(posicoes_fedores.get(i), posicoes_fedores.get(i+1), 'f', caverna);
			caverna.solicitaAdicao(posicoes_fedores.get(i), posicoes_fedores.get(i+1), novo_fedor);
		}
	}

	public void removerFedores() {
		for (int i = 0; i < posicoes_fedores.size(); i += 2) {
			caverna.solicitarRemocao(posicoes_fedores.get(i), posicoes_fedores.get(i+1), 'f');
		}
	}
}
