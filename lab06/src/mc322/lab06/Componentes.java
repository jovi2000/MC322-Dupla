package mc322.lab06;

import java.util.LinkedList;

public class Componentes {
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
        return caverna.solicitaAdicao(linha, coluna, this);
    }

    /* Função que verifica se a posição do fedor ou da brisa está dentro ou fora da matriz. Caso esteja dentro retorna
    "true" e caso esteja fora retorna "false" */
    public boolean dentroDaMatriz(int linha, int coluna) {
        return (linha <= 3 && linha >= 0) && (coluna <= 3 && coluna >= 0);
    }

    /* Função usada pelas Classes primarias Wumpus e Buraco para adicionar os componentes secundários Fedor e Brisa */
    public void inserirSecundarios() {
        LinkedList<Integer> lista_posicoes = new LinkedList<Integer>(); /* Os indices pares da lista são as linhas e o
        número seguinte de cada linha é sua respectiva coluna */

        /* Calculando todas as posicoes dos objetos da classe secundária */
        /* Posicao acima */
        int linha_secundaria = linha - 1, coluna_secundaria = coluna;
        if (dentroDaMatriz(linha_secundaria, coluna_secundaria)) {
            lista_posicoes.add(linha_secundaria);
            lista_posicoes.add(coluna_secundaria);
        }
        /* Posicao abaixo */
        linha_secundaria = linha + 1;
        coluna_secundaria = coluna;
        if (dentroDaMatriz(linha_secundaria, coluna_secundaria)) {
            lista_posicoes.add(linha_secundaria);
            lista_posicoes.add(coluna_secundaria);
        }
        /* Posicao a direita */
        linha_secundaria = linha;
        coluna_secundaria = coluna + 1;
        if (dentroDaMatriz(linha_secundaria, coluna_secundaria)) {
            lista_posicoes.add(linha_secundaria);
            lista_posicoes.add(coluna_secundaria);
        }
        /* Posicao a esquerda */
        linha_secundaria = linha;
        coluna_secundaria = coluna - 1;
        if (dentroDaMatriz(linha_secundaria, coluna_secundaria)) {
            lista_posicoes.add(linha_secundaria);
            lista_posicoes.add(coluna_secundaria);
        }

        /* Adicionando cada fedor ou brisa na sala da caverna */
        if (simbolo == 'W') {
            for (int i = 0; i < lista_posicoes.size(); i += 2) {
                Componentes novo_fedor = new Fedor(lista_posicoes.get(i), lista_posicoes.get(i+1), 'f', caverna);
                caverna.solicitaAdicao(lista_posicoes.get(i), lista_posicoes.get(i+1), novo_fedor);
            }
        } else /* simbolo = 'B' */ {
            for (int i = 0; i < lista_posicoes.size(); i += 2) {
                Componentes nova_brisa = new Brisa(lista_posicoes.get(i), lista_posicoes.get(i+1), 'b', caverna);
                caverna.solicitaAdicao(lista_posicoes.get(i), lista_posicoes.get(i+1), nova_brisa);
            }
        }
    }

    /* Classe especifica do componente Heroi */
    public int controleHeroi(String comando) {
        return 0;
    }

    public void removerFedores() {
    }
}
