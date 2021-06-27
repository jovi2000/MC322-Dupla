package controller;

import model.*;

import java.util.LinkedList;
import java.util.Random;

public class MapaController implements IMapaController, IRMapaModel, IRTitaController, IRTorreController, IRCidadeController {
    /* Atributos */
    private int fase; // indica qual a fase atual do jogo
    private int numeroDeTitas; // indica quantos titãs ainda serão gerados
    private boolean geradoAnteriomente; // indica se titãs foram gerados na rodada anterior

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
        numeroDeTitas = 11;
        geradoAnteriomente = false;
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
            Random random = new Random();
            /* Caso o número sorteado seja 1 o(s) titã(s) é(são) gerado(s), e caso seja 0 nenhum titã é gerado */
            int gerar = random.nextInt(2);
            /* Caso na rodada passada nenhum titã tenha sido gerado, na rodada atual é certeza de que será gerado */
            if (gerar == 1 || !geradoAnteriomente) {
                if (numeroDeTitas == 1) {
                    Random random2 = new Random();
                    int linhaSorteada = random2.nextInt(2);
                    /* Criando o titã */
                    setCelula(new TitaModel(), linhaSorteada + 1, 0);
                    titaController.connect((TitaModel)getCelula(linhaSorteada + 1, 0));
                    titaController.setLinha(linhaSorteada + 1); titaController.setColuna(0);
                    titaController.setDano(10 + (2 * (fase-1))); titaController.setVida(gerarVida());
                    titaController.setRecompensa(15 + 2*(fase-1));
                    /* Colocando ele na lista de titãs */
                    titaController.adicionarNaLista();
                    /* Diminuir número de titãs */
                    numeroDeTitas -= 1;
                    geradoAnteriomente = true;
                } else {
                    /* Criando o titã 1 */
                    setCelula(new TitaModel(), 1, 0);
                    titaController.connect((TitaModel)getCelula(1, 0));
                    titaController.setLinha(1); titaController.setColuna(0);
                    titaController.setDano(10 + (2 * (fase-1))); titaController.setVida(gerarVida());
                    titaController.setRecompensa(15 + 2*(fase-1));
                    titaController.adicionarNaLista();
                    /* Criando o titã 2 */
                    setCelula(new TitaModel(), 2, 0);
                    titaController.connect((TitaModel)getCelula(2, 0));
                    titaController.setLinha(2); titaController.setColuna(0);
                    titaController.setDano(10 + (2 * (fase-1))); titaController.setVida(gerarVida());
                    titaController.setRecompensa(15 + 2*(fase-1));
                    titaController.adicionarNaLista();
                    /* Diminuir número de titãs */
                    numeroDeTitas -= 2;
                    geradoAnteriomente = true;
                }
            }
            else {
                geradoAnteriomente = false;
            }
        }
    }

    //MUDAR DPS
    public void contruirTorreDeFlechas(int linha, int coluna) throws CompraInvalida {
        TorreModel torreDeFlechas = new TorreDeFlechas();
        torreController.connect(torreDeFlechas);
        /* Verificando se a compra é válida */
        if (cidadeController.getDinheiro() - torreController.getCusto() < 0) {
            throw new CompraInvalida("Você não possui o dinheiro necessário para realizar a compra");
        }
        else {
            /* Criando a torre e colocando no mapa */
            mapaModel.setCelula(torreDeFlechas, linha, coluna);
            getCelula(linha, coluna).setLinha(linha);
            getCelula(linha, coluna).setColuna(coluna);
            /* Adicionando a torre na lista de torres */
            torreController.connect((TorreModel) mapaModel.getCelula(linha, coluna));
            torreController.adicionarNaLista();
            /* Tirando o dinheiro da cidade */
            cidadeController.diminuirDinheiro(torreController.getCusto());
            /* Mudando o custo da torre para o custo da evolução */
            torreController.setCusto(10);
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
            /* Criando a torre e colocando no mapa */
            mapaModel.setCelula(torreCanhao, linha, coluna);
            getCelula(linha, coluna).setLinha(linha);
            getCelula(linha, coluna).setColuna(coluna);
            /* Adicionando a torre na lista de torres */
            torreController.connect((TorreModel)mapaModel.getCelula(linha, coluna));
            torreController.adicionarNaLista();
            /* Tirando o dinheiro da cidade */
            cidadeController.diminuirDinheiro(torreController.getCusto());
            /* Mudando o custo da torre para o custo da evolução */
            torreController.setCusto(10);
        }
    }

    /* Método para o View */
    public void evoluirTorre(int linha, int coluna) throws CompraInvalida {
        torreController.connect((TorreModel)getCelula(linha, coluna));
        if (cidadeController.getDinheiro() - torreController.getCusto() < 0) {
            throw new CompraInvalida("Você não possui o dinheiro necessário para realizar a compra");
        }
        else {
            /* Tirando o dinheiro da cidade */
            cidadeController.diminuirDinheiro(torreController.getCusto());
            torreController.evoluir();
        }
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

    public int getNumeroDeTitas() {
        return numeroDeTitas;
    }

    public void passarDeFase() {
        fase += 1;
        Random random = new Random();
        int gerar = random.nextInt(5) + 1;
        numeroDeTitas = 10 + gerar;
        geradoAnteriomente = false;
    }

    private int gerarVida() {
        Random random = new Random();
        int vida = random.nextInt(100) + 1;
        return 100 + 20 * (fase - 1) + vida;
    }
}