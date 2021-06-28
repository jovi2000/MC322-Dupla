package controller;

import model.Entidade;
import model.TitaModel;

public interface IMapaController {
    public void movimentarTita(TitaModel tita);

    public void retirarTitaDoMapa(TitaModel tita);

    public void construirTorre(int linha, int coluna, String tipo) throws CompraInvalida;

    public void gerarTitas();

    public void evoluirTorre(int linha, int coluna) throws CompraInvalida;

    public Entidade getCelula(int linha, int coluna);

    public void setCelula(Entidade novaEntidade ,int linha, int coluna);

    public int getFase();

    public int getNumeroDeTitas();

    public void passarDeFase();
}
