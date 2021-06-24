package model;

public class MapaModel implements IMapaModel {
    private Entidade[][] matrizMapa;

    public Entidade getCelula(int linha, int coluna) {
        return matrizMapa[linha][coluna];
    }

    public void setCelula(Entidade novaEntidade, int linha, int coluna) {
        matrizMapa[linha][coluna] = novaEntidade;
    }
}
