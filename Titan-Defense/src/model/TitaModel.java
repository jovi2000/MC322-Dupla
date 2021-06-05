package model;

import gameplay.TitaGameplay;
import model.Entidades;

public class TitaModel extends Entidades {
    /* Atributos */
    private int dano;
    private int vida;
    private int movimento; // Quantos blocos o titã anda por tempo

    /* Getters e Setters */
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

    public int getMovimento() {
        return movimento;
    }

    public void setMovimento(int movimento) {
        this.movimento = movimento;
    }

    /* Métodos */

    public void movimentar() {

    }
}
