package model;

public class TorreModel extends Entidade implements ITorreModel {
    /* Atributos */
    protected int nivel;
    protected int dano;
    protected char tipo;
    // custo

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
}
