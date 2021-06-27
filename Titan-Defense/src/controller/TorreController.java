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
    public void atacarTita(TitaModel tita) {
        titaController.connect(tita);
        titaController.diminuirVida(torreModel.getDano());
    }

    public void evoluir() {
        torreModel.setDano(torreModel.getDano() + 5);
        torreModel.setNivel(torreModel.getNivel() + 1);
        if (torreModel.getNivel() == 2) {
            torreModel.setCusto(torreModel.getCusto() + 5);
        }
    }

    /* Função para o View */
    /* Percorre o vetor de torres para ver qual as torres que podem atacar */
    public void ataqueDasTorres() {
        for (int i = 0; i < listaTorres.size(); i++) {
            connect(listaTorres.get(i));
            atacarAlvos(procurarAlvos());
        }
    }

    public LinkedList<Entidade> procurarAlvos() {
        /* Torre de Flechas */
        if (torreModel.getTipo() == 'f') {
            return procurarAlvosFlecha((TorreModel)torreModel);
        }
        /* Torre Canhão */
        else {
            return procurarAlvosCanhao((TorreModel)torreModel);
        }
    }

    public LinkedList<Entidade> procurarAlvosFlecha(TorreModel torre) {
        LinkedList<Entidade> listaDeAlvos = new LinkedList<Entidade>();
        /* Parte de cima do mapa */
        if (torre.getLinha() == 0) {
            /* Primeira posição alvo */
            if (torre.getColuna() + 1 <= 3 && mapaController.getCelula(torre.getLinha() + 1, torre.getColuna() + 1) != null) {
                /* A vida precisa ser maior que zero para a torre atacar */
                if (mapaController.getCelula(torre.getLinha() + 1, torre.getColuna() + 1).getVida() > 0) {
                    listaDeAlvos.add(mapaController.getCelula(torre.getLinha() + 1, torre.getColuna() + 1));
                }
            }
            /* Segunda posição alvo */
            if (mapaController.getCelula(torre.getLinha() + 1, torre.getColuna()) != null && listaDeAlvos.size() == 0) {
                if (mapaController.getCelula(torre.getLinha() + 1, torre.getColuna()).getVida() > 0) {
                    listaDeAlvos.add(mapaController.getCelula(torre.getLinha() + 1, torre.getColuna()));
                }
            }
            /* Terceira posição alvo */
            if (mapaController.getCelula(torre.getLinha() + 2, torre.getColuna()) != null && listaDeAlvos.size() == 0) {
                if (mapaController.getCelula(torre.getLinha() + 2, torre.getColuna()).getVida() > 0) {
                    listaDeAlvos.add(mapaController.getCelula(torre.getLinha() + 2, torre.getColuna()));
                }
            }
            /* Quarta posição alvo */
            if (torre.getColuna() - 1 >= 0 && mapaController.getCelula(torre.getLinha() + 1, torre.getColuna() - 1) != null
            && listaDeAlvos.size() == 0) {
                if (mapaController.getCelula(torre.getLinha() + 1, torre.getColuna() - 1).getVida() > 0) {
                    listaDeAlvos.add(mapaController.getCelula(torre.getLinha() + 1, torre.getColuna() - 1));
                }
            }
        }
        /* Parte de baixo do mapa */
        else {
            /* Primeira posição alvo */
            if (torre.getColuna() + 1 <= 3 && mapaController.getCelula(torre.getLinha() - 1,torre.getColuna() + 1) != null) {
                if (mapaController.getCelula(torre.getLinha() - 1,torre.getColuna() + 1).getVida() > 0) {
                    listaDeAlvos.add(mapaController.getCelula(torre.getLinha() - 1, torre.getColuna() + 1));
                }
            }
            /* Segunda posição alvo */
            if (mapaController.getCelula(torre.getLinha() - 1, torre.getColuna()) != null && listaDeAlvos.size() == 0) {
                if (mapaController.getCelula(torre.getLinha() - 1, torre.getColuna()).getVida() > 0) {
                    listaDeAlvos.add(mapaController.getCelula(torre.getLinha() - 1, torre.getColuna()));
                }
            }
            /* Terceira posição alvo */
            if (mapaController.getCelula(torre.getLinha() - 2, torre.getColuna()) != null && listaDeAlvos.size() == 0) {
                if (mapaController.getCelula(torre.getLinha() - 2, torre.getColuna()).getVida() > 0) {
                    listaDeAlvos.add(mapaController.getCelula(torre.getLinha() - 2, torre.getColuna()));
                }
            }
            /* Quarta posição alvo */
            if (torre.getColuna() - 1 >= 0 && mapaController.getCelula(torre.getLinha() - 1, torre.getColuna() - 1)  != null
            && listaDeAlvos.size() == 0) {
                if (mapaController.getCelula(torre.getLinha() - 1, torre.getColuna() - 1).getVida() > 0) {
                    listaDeAlvos.add(mapaController.getCelula(torre.getLinha() - 1, torre.getColuna() - 1));
                }
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

    public void atacarAlvos(LinkedList<Entidade> alvos) {
        for (int i = 0; i < alvos.size(); i++) {
            atacarTita((TitaModel)alvos.get(i));
        }
    }

    public void adicionarNaLista() {
        listaTorres.add((TorreModel)torreModel);
    }

    public int getCusto() {
        return torreModel.getCusto();
    }

    public void setCusto(int custo) {
        torreModel.setCusto(custo);
    }
}


