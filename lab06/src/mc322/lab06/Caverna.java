package mc322.lab06;

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

    public boolean verificarSala(int linha, int coluna, Componentes componente) {
        return matriz_caverna[linha][coluna].adicionaComponente(componente);
	}
    

}
