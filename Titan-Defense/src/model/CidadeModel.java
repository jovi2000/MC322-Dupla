package model;

public class CidadeModel extends Entidade implements ICidadeModel {
    /* Atributos */
    private int dinheiro;

    /* Construtor */
    public CidadeModel() {
        //dinheiro = x;
        //vida = y
        //setColuna(z);
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

}
