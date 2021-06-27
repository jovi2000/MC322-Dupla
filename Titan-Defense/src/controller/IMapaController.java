package controller;

import model.Entidade;
import model.TitaModel;

public interface IMapaController {
    public void movimentarTita(TitaModel tita);

    public void retirarTitaDoMapa(TitaModel tita);

    public void contruirTorreDeFlechas(int linha, int coluna) throws CompraInvalida;

    public void contruirTorreCanhao(int linha, int coluna) throws CompraInvalida;

    public void gerarTitas();

    public void evoluirTorre(int linha, int coluna) throws CompraInvalida;

    public Entidade getCelula(int linha, int coluna);

    public void setCelula(Entidade novaEntidade ,int linha, int coluna);

    public int getFase();

    public int getNumeroDeTitas();

    public void passarDeFase();
}
