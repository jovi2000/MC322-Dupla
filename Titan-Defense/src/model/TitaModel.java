package model;

public class TitaModel extends Entidade implements ITitaModel {
    /* Atributos */
    private int dano;
    private int recompensa;

    /* Construtor */
    public TitaModel() {
        vida = 100;
        dano = 10;
        recompensa = 15;
    }

    /* Getters e Setters */

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(char tipo) {
        this.recompensa = tipo;
    }
}
