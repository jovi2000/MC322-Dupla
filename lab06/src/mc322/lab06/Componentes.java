package mc322.lab06;

public class Componentes {
    // Fazer um polimorfismo para o contrutor de cada componente
    /* Atributos */
    protected int linha;
    protected int coluna;
    protected char simbolo;

    /* Métodos */

    protected  Componentes(int linha, int coluna, char simbolo) {
        this.linha = linha;
        this.coluna = coluna;
        this.simbolo = simbolo;
    }

}
