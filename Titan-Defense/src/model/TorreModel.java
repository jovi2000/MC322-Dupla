package model;

public class TorreModel extends Entidade {
    /* Atributos */
    private int nivel;
    private boolean danoEmArea;
    private int dano;

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

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
}
