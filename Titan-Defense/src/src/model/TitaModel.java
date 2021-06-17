package model;

public class TitaModel extends Entidade {
    /* Atributos */
    private int movimento; // Quantos blocos o titã anda por tempo
    private int dano;

    /* Getters e Setters */

    public int getMovimento() {
        return movimento;
    }

    public void setMovimento(int movimento) {
        this.movimento = movimento;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
}
