package model;

import model.Entidades;

public class MapaModel {
    /* Atributos */
    private Entidades[][] mapaMatriz;
    private int colunaDaCidade;
    private int vida; // Vida da cidade/player
    private int dinheiro;

    public Entidades[][] getMapaMatriz() {
        return mapaMatriz;
    }

    public void setMapaMatriz(Entidades[][] mapaMatriz) {
        this.mapaMatriz = mapaMatriz;
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

    public int getColunaDaCidade() {
        return colunaDaCidade;
    }

    public void setColunaDaCidade(int colunaDaCidade) {
        this.colunaDaCidade = colunaDaCidade;
    }
}
