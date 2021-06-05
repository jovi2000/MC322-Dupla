package model;

import gameplay.TorreGameplay;

public class TorreModel extends Entidades {
    /* Atributos */
    private int dano;
    private int nivel;
    private boolean danoEmArea;

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean isDanoEmArea() {
        return danoEmArea;
    }

    public void setDanoEmArea(boolean danoEmArea) {
        this.danoEmArea = danoEmArea;
    }
}
