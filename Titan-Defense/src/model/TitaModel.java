package model;

import gameplay.TitaGameplay;
import model.Entidades;

public class TitaModel extends Entidades {
    /* Atributos */
    private int dano;
    private int vida;

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

}
