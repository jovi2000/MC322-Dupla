package controller;

import model.Entidade;
import model.TitaModel;

public interface IMapaController {
    public void movimentarTita(TitaModel tita);

    public void retirarTitaDoMapa(TitaModel tita);

    public void contruirTorre(int linha, int coluna, String tipo);

    public void gerarTitas();

    public void evoluirTorre(int linha, int coluna);

    public Entidade getCelula(int linha, int coluna);

    public void setCelula(Entidade novaEntidade ,int linha, int coluna);

    public int getFase();

    public void passarDeFase();
}
