package controller;

import model.*;

import java.util.LinkedList;

public class MapaController implements IREntidadeController, IRMapaModel, IMapaController {
    /* Atributos */
    private int fase; // indica qual a fase atual do jogo

    /* Interfaces */
    private IEntidadeController entidadeController;
    private IMapaModel mapa;

    /* Toda vez que o timer for acionado, os titãs nascem, os titãs andam e as torres atiram. Depois dessas ações o
    vetor de titas é percorrido para verificar se algum tita morreu ou chegou na cidade */

    public void connect(IEntidadeController entidadeController) {
        this.entidadeController = entidadeController;
    }

    public void connect(IMapaModel mapa) {
        this.mapa = mapa;
    }

    /* Muda a posição do titã no mapa */
    public void movimentarTita(TitaModel tita) {
        retirarTitaDoMapa(tita);
        mapa.setCelula(tita, entidadeController.getLinha(tita), entidadeController.getColuna(tita) + 1); // Muda para a outra posição
    }

    public void retirarTitaDoMapa(TitaModel tita) {
        /* Tirando o titã do mapa */
        mapa.setCelula(null, entidadeController.getLinha(tita), entidadeController.getColuna(tita));
    }

    public void gerarTitas() {
        //Dependendo da fase terá um vetor com um certo número de titãs que irão spawnar
        // Colocar cada titã que nasce no vetor
    }

    public void contruirTorre(int linha, int coluna, String tipo) {
        if (tipo == "flecha") {
            mapa.setCelula(new TorreDeFlechas(), linha, coluna);
        }
        else {
            mapa.setCelula(new TorreCanhao(), linha, coluna);
        }
        entidadeController.adicionarNaLista((TorreModel)mapa.getCelula(linha, coluna));
    }

    public void evoluirTorre(int linha, int coluna) {
        entidadeController.evoluir((TorreModel)getCelula(linha, coluna));
    }

    public Entidade getCelula(int linha, int coluna) {
        return mapa.getCelula(linha, coluna);
    }

    public void setCelula(Entidade novaEntidade, int linha, int coluna) {
        mapa.setCelula(novaEntidade, linha, coluna);
    }

    public int getFase() {
        return fase;
    }

    public void passarDeFase() {
        fase += 1;
    }
}