package controller;

import model.*;

import java.util.LinkedList;

public class TorreController implements ITorreController, IRTorreModel, IRTitaController, IRMapaController {
    /* Atributos */
    private LinkedList<TorreModel> listaTorres;

    /* Interfaces */
    private ITorreModel torreModel;
    private IMapaController mapaController;
    private ITitaController titaController;

    /* Constutor */
    public TorreController() {
        listaTorres = new LinkedList<TorreModel>();
    }

    /* Getters e Setters */

    public IMapaController getMapaController() {
        return mapaController;
    }

    public void setMapaController(IMapaController mapaController) {
        this.mapaController = mapaController;
    }

    public ITitaController getTitaController() {
        return titaController;
    }

    public void setTitaController(ITitaController titaController) {
        this.titaController = titaController;
    }
    /* Métodos */

    public void connect(ITorreModel torreModel) {
        this.torreModel = torreModel;
    }

    public void connect(ITitaController titaController) {
        this.titaController = titaController;
    }

    public void connect(IMapaController mapaController) {
        this.mapaController = mapaController;
    }

    /* Torre ataca o titã */
    public void atacarTita(TorreModel torre, TitaModel tita) {
        titaController.diminuirVida(tita, torre.getDano());
    }

    public void evoluir(TorreModel torre) {
        // Dependendo do nível, algumas caracteristicas são melhoradas
    }

    /* Função para o View */
    /* Percorre o vetor de torres para ver qual as torres que podem atacar */
    public void ataqueDasTorres() {
        for (int i = 0; i < listaTorres.size(); i++) {
            atacarAlvos(listaTorres.get(i), procurarAlvos(listaTorres.get(i)));
        }
    }

    public LinkedList<Entidade> procurarAlvos(TorreModel torre) {
        /* Torre de Flechas */
        if (torre.getTipo() == 'f') {
            return procurarAlvosFlecha(torre);
        }
        /* Torre Canhão */
        else {
            return procurarAlvosCanhao(torre);
        }
    }

    public LinkedList<Entidade> procurarAlvosFlecha(TorreModel torre) {
        LinkedList<Entidade> listaDeAlvos = new LinkedList<Entidade>();
        /* Parte de cima do mapa */
        if (torre.getLinha() == 0) {
            /* Primeira posição alvo */
            if (torre.getColuna() + 1 <= 3 && mapaController.getCelula(torre.getLinha() + 1, torre.getColuna() + 1) != null) {
                listaDeAlvos.add(mapaController.getCelula(torre.getLinha() + 1, torre.getColuna() + 1));
            }
            /* Segunda posição alvo */
            else if (mapaController.getCelula(torre.getLinha() + 1, torre.getColuna()) != null) {
                listaDeAlvos.add(mapaController.getCelula(torre.getLinha() + 1, torre.getColuna()));
            }
            /* Terceira posição alvo */
            else if (mapaController.getCelula(torre.getLinha() + 2, torre.getColuna()) != null) {
                listaDeAlvos.add(mapaController.getCelula(torre.getLinha() + 2, torre.getColuna()));
            }
            /* Quarta posição alvo */
            else if (torre.getColuna() - 1 >= 0 && mapaController.getCelula(torre.getLinha() + 1, torre.getColuna() - 1) != null) {
                listaDeAlvos.add(mapaController.getCelula(torre.getLinha() + 1, torre.getColuna() - 1));
            }
        }
        /* Parte de baixo do mapa */
        else {
            /* Primeira posição alvo */
            if (torre.getColuna() + 1 <= 3 && mapaController.getCelula(torre.getLinha() - 1,torre.getColuna() + 1) != null) {
                listaDeAlvos.add(mapaController.getCelula(torre.getLinha() - 1,torre.getColuna() + 1));
            }
            /* Segunda posição alvo */
            else if (mapaController.getCelula(torre.getLinha() - 1, torre.getColuna()) != null) {
                listaDeAlvos.add(mapaController.getCelula(torre.getLinha() - 1, torre.getColuna()));
            }
            /* Terceira posição alvo */
            else if (mapaController.getCelula(torre.getLinha() - 2, torre.getColuna()) != null) {
                listaDeAlvos.add(mapaController.getCelula(torre.getLinha() - 2, torre.getColuna()));
            }
            /* Quarta posição alvo */
            else if (torre.getColuna() - 1 >= 0 && mapaController.getCelula(torre.getLinha() - 1, torre.getColuna() - 1)  != null) {
                listaDeAlvos.add(mapaController.getCelula(torre.getLinha() - 1, torre.getColuna() - 1));
            }
        }
        return listaDeAlvos;
    }

    public LinkedList<Entidade> procurarAlvosCanhao(TorreModel torre) {
        LinkedList<Entidade> listaDeAlvos = new LinkedList<Entidade>();
        /* Parte de cima do mapa */
        if (torre.getLinha() == 0) {
            /* Primeira posição alvo */
            if (torre.getColuna() + 1 <= 3 && mapaController.getCelula(torre.getLinha() + 1, torre.getColuna() + 1) != null) {
                listaDeAlvos.add(mapaController.getCelula(torre.getLinha() + 1, torre.getColuna() + 1));
            }
            /* Segunda posição alvo */
            if (mapaController.getCelula(torre.getLinha() + 1, torre.getColuna()) != null) {
                listaDeAlvos.add(mapaController.getCelula(torre.getLinha() + 1, torre.getColuna()));
            }
            /* Terceira posição alvo */
            if (torre.getColuna() - 1 >= 0 && mapaController.getCelula(torre.getLinha() + 1, torre.getColuna() - 1) != null) {
                listaDeAlvos.add(mapaController.getCelula(torre.getLinha() + 1, torre.getColuna() - 1));
            }
        }
        /* Parte de baixo do mapa */
        else {
            if (torre.getColuna() + 1 <= 3 && mapaController.getCelula(torre.getLinha() - 1, torre.getColuna() + 1) != null) {
                listaDeAlvos.add(mapaController.getCelula(torre.getLinha() - 1, torre.getColuna() + 1));
            }
            /* Segunda posição alvo */
            if (mapaController.getCelula(torre.getLinha() - 1, torre.getColuna()) != null) {
                listaDeAlvos.add(mapaController.getCelula(torre.getLinha() - 1, torre.getColuna()));
            }
            /* Terceira posição alvo */
            if (torre.getColuna() - 1 >= 0 && mapaController.getCelula(torre.getLinha() - 1, torre.getColuna() - 1) != null) {
                listaDeAlvos.add(mapaController.getCelula(torre.getLinha() - 1, torre.getColuna() - 1));
            }
        }
        return listaDeAlvos;
    }

    public void atacarAlvos(TorreModel torre, LinkedList<Entidade> alvos) {
        for (int i = 0; i < alvos.size(); i++) {
            atacarTita(torre, (TitaModel)alvos.get(i));
        }
    }

    public void adicionarNaLista(TorreModel torre) {
        listaTorres.add(torre);
    }
}


