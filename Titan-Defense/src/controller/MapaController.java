package controller;

import model.*;

import java.util.LinkedList;

public class MapaController implements IMapaController, IRMapaModel, IRTitaController, IRTorreController, IRCidadeController {
    /* Atributos */
    private int fase; // indica qual a fase atual do jogo
    private int numeroDeTitas; // indica quantos titãs ainda serão gerados

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
        numeroDeTitas = 10;
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
        if (numeroDeTitas > 0) {
            if (numeroDeTitas == 1) {
                // sortear um numero aleatorio
            }
            else {
                /* Criando os titãs */
                setCelula(new TitaModel(), 1, 0);
                getCelula(1,0).setLinha(1); getCelula(1,0).setColuna(0);
                setCelula(new TitaModel(), 2, 0);
                getCelula(2,0).setLinha(2); getCelula(2,0).setColuna(0);
                /* Colocando eles na lista de titãs */
                titaController.adicionarNaLista((TitaModel)getCelula(1, 0));
                titaController.adicionarNaLista((TitaModel)getCelula(2, 0));
                /* Diminuir número de titãs */
                numeroDeTitas -= 2;
            }
        }
    }

    public void contruirTorreDeFlechas(int linha, int coluna) throws CompraInvalida {
        TorreModel torreDeFlechas = new TorreDeFlechas();
        torreController.connect(torreDeFlechas);
        /* Verificando se a compra é válida */
        if (cidadeController.getDinheiro() - torreController.getCusto() < 0) {
            throw new CompraInvalida("Você não possui o dinheiro necessário para realizar a compra");
        }
        else {
            mapaModel.setCelula(torreDeFlechas, linha, coluna);
            getCelula(linha, coluna).setLinha(linha);
            getCelula(linha, coluna).setColuna(coluna);
            torreController.connect((TorreModel) mapaModel.getCelula(linha, coluna));
            torreController.adicionarNaLista();
            cidadeController.diminuirDinheiro(torreController.getCusto());
        }
    }

    public void contruirTorreCanhao(int linha, int coluna) throws CompraInvalida {
        TorreModel torreCanhao = new TorreCanhao();
        torreController.connect(torreCanhao);
        /* Verificando se a compra é válida */
        if (cidadeController.getDinheiro() - torreController.getCusto() < 0) {
            throw new CompraInvalida("Você não possui o dinheiro necessário para realizar a compra");
        }
        else {
            mapaModel.setCelula(torreCanhao, linha, coluna);
            getCelula(linha, coluna).setLinha(linha);
            getCelula(linha, coluna).setColuna(coluna);
            torreController.connect((TorreModel) mapaModel.getCelula(linha, coluna));
            torreController.adicionarNaLista();
            cidadeController.diminuirDinheiro(torreController.getCusto());
        }
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
        numeroDeTitas = 10;
    }
}