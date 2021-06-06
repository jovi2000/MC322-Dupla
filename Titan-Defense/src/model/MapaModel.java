package model;

import model.Entidades;

public class MapaModel {
    /* Atributos */
    private Entidades[][] mapa;
    private int vida; // Vida da cidade/player
    private int dinheiro;

    public Entidades[][] getMapa() {
        return mapa;
    }

    public void setMapa(Entidades[][] mapa) {
        this.mapa = mapa;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }
}
