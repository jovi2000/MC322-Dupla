package model;

import gameplay.TorreGameplay;

public class TorreModel extends Entidades {
    /* Atributos */
    private int dano;
    private TorreGameplay controle;

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public TorreGameplay getControle() {
        return controle;
    }

    public void setControle(TorreGameplay controle) {
        this.controle = controle;
    }
}
