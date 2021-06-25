package model;

public class MapaModel implements IMapaModel {
    /* Atributo */
    private Entidade[][] matrizMapa;

    /* Construtor */
    public MapaModel() {
        matrizMapa = new Entidade[4][12];
    }

    public Entidade getCelula(int linha, int coluna) {
        return matrizMapa[linha][coluna];
    }

    public void setCelula(Entidade novaEntidade, int linha, int coluna) {
        matrizMapa[linha][coluna] = novaEntidade;
    }
}
