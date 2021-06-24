package model;

public interface IMapaModel {
    public Entidade getCelula(int linha, int coluna);

    public void setCelula(Entidade novaEntidade, int linha, int coluna);
}
