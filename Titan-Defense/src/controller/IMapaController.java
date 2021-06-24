package controller;

import model.Entidade;
import model.TitaModel;

public interface IMapaController {
    // MUDAR ESSA FUNCAO
    public void movimentarTita(TitaModel tita);

    public Entidade getCelula(int linha, int coluna);

    public void setCelula(Entidade novaEntidade ,int linha, int coluna);

    public int getFase();

    public void passarDeFase();
}
