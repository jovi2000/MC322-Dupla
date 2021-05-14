package mc322.lab06;

public class Componentes {
    // Fazer um polimorfismo para o contrutor de cada componente
    /* Atributos */
    protected int linha;
    protected int coluna;
    protected char simbolo;
    protected Caverna caverna;

    /* Métodos */

    public Componentes(int linha, int coluna, char simbolo, Caverna caverna) {
        this.linha = linha;
        this.coluna = coluna;
        this.simbolo = simbolo;
        this.caverna = caverna;
    }

    public boolean solicitarInclusao() {
        return caverna.verificarSala(linha, coluna, this);
    }

    /* Função que verifica se a posição do fedor ou da brisa está dentro ou fora da matriz. Caso esteja dentro retorna
    "true" e caso esteja fora retorna "false" */
    private boolean dentroDaMatriz(int linha, int coluna) {
        return (linha <= 3 && linha >= 0) && (coluna <= 3 && coluna >= 0);
    }

    /* Função usada pelas Classes primarias Wumpus e Buraco para adicionar os componentes secundários Fedor e Brisa */
    public void inserirSecundarios() {
        int[] vetor_posicoes = new int[8]; /* Os indices pares do vetor são as linhas e o número seguinte de cada linha
		 é sua respectiva coluna */
        int posicao_vetor = 0;

        /* Calculando todas as posicoes dos objetos da classe secundária */
        /* Posicao acima */
        int linha_secundaria = linha - 1, coluna_secundaria = coluna;
        if (dentroDaMatriz(linha_secundaria, coluna_secundaria)) {
            vetor_posicoes[posicao_vetor] = linha_secundaria;
            vetor_posicoes[posicao_vetor + 1] = coluna_secundaria;
            posicao_vetor += 2;
        }
        /* Posicao abaixo */
        linha_secundaria = linha + 1;
        coluna_secundaria = coluna;
        if (dentroDaMatriz(linha_secundaria, coluna_secundaria)) {
            vetor_posicoes[posicao_vetor] = linha_secundaria;
            vetor_posicoes[posicao_vetor + 1] = coluna_secundaria;
            posicao_vetor += 2;
        }
        /* Posicao a direita */
        linha_secundaria = linha;
        coluna_secundaria = coluna + 1;
        if (dentroDaMatriz(linha_secundaria, coluna_secundaria)) {
            vetor_posicoes[posicao_vetor] = linha_secundaria;
            vetor_posicoes[posicao_vetor + 1] = coluna_secundaria;
            posicao_vetor += 2;
        }
        /* Posicao a esquerda */
        linha_secundaria = linha;
        coluna_secundaria = coluna - 1;
        if (dentroDaMatriz(linha_secundaria, coluna_secundaria)) {
            vetor_posicoes[posicao_vetor] = linha_secundaria;
            vetor_posicoes[posicao_vetor + 1] = coluna_secundaria;
            posicao_vetor += 2;
        }

        /* Adicionando cada fedor ou brisa na sala da caverna */
        if (simbolo == 'W') {
            for (int i = 0; i < vetor_posicoes.length; i += 2) {
                Componentes novo_fedor = new Fedor(vetor_posicoes[i], vetor_posicoes[i + 1], 'f', caverna);
                caverna.verificarSala(vetor_posicoes[i], vetor_posicoes[i + 1], novo_fedor);
            }
        } else /* simbolo = 'B' */ {
            for (int i = 0; i < vetor_posicoes.length; i += 2) {
                Componentes nova_brisa = new Brisa(vetor_posicoes[i], vetor_posicoes[i + 1], 'b', caverna);
                caverna.verificarSala(vetor_posicoes[i], vetor_posicoes[i + 1], nova_brisa);
            }
        }
    }
}
