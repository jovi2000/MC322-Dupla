package controller;

import model.*;

import java.util.LinkedList;

public class MapaController implements IMapaController, IRMapaModel, IRTitaController, IRTorreController, IRCidadeController {
    /* Atributos */
    private int fase; // indica qual a fase atual do jogo

    /* Interfaces */
    private IMapaModel mapaModel;
    private ICidadeController cidadeController;
    private ITitaController titaController;
    private ITorreController torreController;

    /* Getters e Setters */
    public IMapaModel getMapaModel() {
        return mapaModel;
    }

    public void setMapaModel(IMapaModel mapaModel) {
        this.mapaModel = mapaModel;
    }

    public ICidadeController getCidadeController() {
        return cidadeController;
    }

    public void setCidadeController(ICidadeController cidadeController) {
        this.cidadeController = cidadeController;
    }

    public ITitaController getTitaController() {
        return titaController;
    }

    public void setTitaController(ITitaController titaController) {
        this.titaController = titaController;
    }

    public ITorreController getTorreController() {
        return torreController;
    }

    public void setTorreController(ITorreController torreController) {
        this.torreController = torreController;
    }

    /* Construtor */
    public MapaController() {
        fase = 1;
    }

    /* Métodos */
    public void connect(IMapaModel mapaModel) {
        this.mapaModel = mapaModel;
    }

    public void connect(ITitaController titaController) {
        this.titaController = titaController;
    }

    public void connect(ITorreController torreController) {
        this.torreController = torreController;
    }

    public void connect(ICidadeController cidadeController) {
        this.cidadeController = cidadeController;
    }

    /* Muda a posição do titã no mapa */
    public void movimentarTita(TitaModel tita) {
        retirarTitaDoMapa(tita);
        mapaModel.setCelula(tita, titaController.getLinha(), titaController.getColuna() + 1); // Muda para a outra posição
    }

    public void retirarTitaDoMapa(TitaModel tita) {
        /* Tirando o titã do mapa */
        mapaModel.setCelula(null, titaController.getLinha(), titaController.getColuna());
    }

    public void gerarTitas() {
        //Dependendo da fase terá um vetor com um certo número de titãs que irão spawnar
        // Colocar cada titã que nasce na lista
    }

    public void contruirTorre(int linha, int coluna, String tipo) {
        if (tipo.equals("flecha")) {
            mapaModel.setCelula(new TorreDeFlechas(), linha, coluna);
        }
        else {
            mapaModel.setCelula(new TorreCanhao(), linha, coluna);
        }
        torreController.connect((TorreModel)mapaModel.getCelula(linha, coluna));
        torreController.adicionarNaLista();
        cidadeController.diminuirDinheiro(torreController.getCusto());
    }

    /* Método para o View */
    public void evoluirTorre(int linha, int coluna) {
        torreController.connect((TorreModel)getCelula(linha, coluna));
        torreController.evoluir();
    }

    public Entidade getCelula(int linha, int coluna) {
        return mapaModel.getCelula(linha, coluna);
    }

    public void setCelula(Entidade novaEntidade, int linha, int coluna) {
        mapaModel.setCelula(novaEntidade, linha, coluna);
    }

    public int getFase() {
        return fase;
    }

    public void passarDeFase() {
        fase += 1;
    }
}