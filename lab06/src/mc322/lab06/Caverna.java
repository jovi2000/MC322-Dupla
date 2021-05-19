package mc322.lab06;

import javax.naming.CompositeName;
import java.util.LinkedList;

public class Caverna {
    /* Atributos */
    public Sala[][] matriz_caverna;

    /* Métodos */
    Caverna() {
    	this.matriz_caverna = new Sala[4][4];
    	preencherMatriz();
	}

	private void preencherMatriz() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz_caverna[i][j] = new Sala();
            }
        }
    }

    /* Retorna o index do componente na lista ligada da sala */
    public int verificarSala(int linha, int coluna, char simbolo) {
        return matriz_caverna[linha][coluna].verificaComponentes(simbolo);
	}

	public boolean solicitaAdicao(int linha, int coluna, Componentes componente) {
		return matriz_caverna[linha][coluna].adicionaComponente(componente);
	}

	public void solicitarRemocao(int linha, int coluna, char simbolo) {
    	matriz_caverna[linha][coluna].removeComponente(simbolo);
	}

    public void exibirCaverna() {
    	for (int i = 0; i < 4; i++) {
			System.out.println();
			/* Printando todos os número no começo das linhas que indicam a posição de cada linha */
			System.out.print((i + 1) + " ");
			for (int j = 0; j < 4; j++) {
				/* Caso a sala não esteja visível */
				if (!matriz_caverna[i][j].visivel) {
					System.out.print("# ");
				}
				else {
					/* Caso a lista ligada da sala esteja vazia e visivel, a sala não tem nenhum componente */
					if (matriz_caverna[i][j].lista_sala.size() == 0) {
						System.out.print("- ");
					} else {
						System.out.print(verificarPrioridade(matriz_caverna[i][j].lista_sala) + " ");
					}
				}
			}
		}
		/* Printando todos os números que mostram a posição de cada coluna */
		System.out.println(); System.out.print("  ");
		for (int n = 0; n < 4; n++) {
			System.out.print((n + 1) + " ");
		}
    }

    /* Função que verifica qual o componente de maior prioridade dentro de uma lista ligada */
    private char verificarPrioridade(LinkedList<Componentes> lista) {
    	char prioridade = ' ';
    	for (int i = 0; i < lista.size(); i++) {
    		/* Caso o componente da lista seja um Wumps, um ouro ou um buraco, ele já é prioridade */
    		if (lista.get(i).simbolo == 'W' || lista.get(i).simbolo == 'B' || lista.get(i).simbolo == 'O') {
    			prioridade = lista.get(i).simbolo;
    			return prioridade;
			}
    		else if (lista.get(i).simbolo == 'P') {
				prioridade = 'P';
			}
			else if (lista.get(i).simbolo == 'f') {
				prioridade = 'f';
			}
			else {
				prioridade = 'b';
			}
		}
		return prioridade;
	}

}
