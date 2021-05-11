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

    boolean solicitarInclusao() {
        return caverna.colocarNaSala(linha, coluna);
    }
}
