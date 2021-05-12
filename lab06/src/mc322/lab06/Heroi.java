package mc322.lab06;

public class Heroi extends Componentes {
    /* Atributos */
    private int flecha;
    private boolean equipada;

    public Heroi(int linha, int coluna, char simbolo, Caverna caverna) {
        super(linha, coluna, simbolo, caverna);
    	this.flecha = 1;
    	this.equipada = false;
    }
}
