package model;

import gameplay.TorreGameplay;

public class TorreModel extends Entidades {
    /* Atributos */
    private int nivel;
    private boolean danoEmArea;

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
