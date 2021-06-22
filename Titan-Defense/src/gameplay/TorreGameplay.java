package gameplay;

import model.*;

import java.util.LinkedList;

public class TorreGameplay implements ITorreGameplay, IRTorreModel, IRTitaModel {
    ITorreModel torreModel;
    ITitaModel titaModel;

    public void connect(ITorreModel torreModel) {
        this.torreModel = torreModel;
    }

    public void connect(ITitaModel titaModel) {
        this.titaModel = titaModel;
    }

    /* Torre ataca o titã */
    public void atacarTita(TorreModel torre, Entidade tita) {
        int vidaFinal = tita.getVida() - torre.getDano();
        tita.setVida(vidaFinal);
    }

    public void evoluir(TorreModel torre) {
        // Dependendo do nível, algumas caracteristicas são melhoradas
    }

    public LinkedList<Entidade> procurarAlvos(TorreModel torre, Entidade[][] mapa) {
        LinkedList<Entidade> listaDeAlvos;
        /* Torre de Flechas */
        if (torre.getTipo() == 'f') {
            listaDeAlvos = procurarAlvosFlecha(torre, mapa);
        }
        /* Torre Canhão */
        else {
            listaDeAlvos = procurarAlvosCanhao(torre, mapa);
        }
        return listaDeAlvos;
    }

    public LinkedList<Entidade> procurarAlvosFlecha(TorreModel torre, Entidade[][] mapa) {
        LinkedList<Entidade> listaDeAlvos = new LinkedList<Entidade>();
        /* Parte de cima do mapa */
        if (torre.getLinha() == 0) {
            /* Primeira posição alvo */
            if (torre.getColuna() + 1 <= 3 && mapa[torre.getLinha() + 1][torre.getColuna() + 1] != null) {
                listaDeAlvos.add(mapa[torre.getLinha() + 1][torre.getColuna() + 1]);
            }
            /* Segunda posição alvo */
            else if (mapa[torre.getLinha() + 1][torre.getColuna()] != null) {
                listaDeAlvos.add(mapa[torre.getLinha() + 1][torre.getColuna()]);
            }
            /* Terceira posição alvo */
            else if (mapa[torre.getLinha() + 2][torre.getColuna()] != null) {
                listaDeAlvos.add(mapa[torre.getLinha() + 2][torre.getColuna()]);
            }
            /* Quarta posição alvo */
            else if (torre.getColuna() - 1 >= 0 && mapa[torre.getLinha() + 1][torre.getColuna() - 1] != null) {
                listaDeAlvos.add(mapa[torre.getLinha() + 1][torre.getColuna() - 1]);
            }
        }
        /* Parte de baixo do mapa */
        else {
            /* Primeira posição alvo */
            if (torre.getColuna() + 1 <= 3 && mapa[torre.getLinha() - 1][torre.getColuna() + 1] != null) {
                listaDeAlvos.add(mapa[torre.getLinha() - 1][torre.getColuna() + 1]);
            }
            /* Segunda posição alvo */
            else if (mapa[torre.getLinha() - 1][torre.getColuna()] != null) {
                listaDeAlvos.add(mapa[torre.getLinha() - 1][torre.getColuna()]);
            }
            /* Terceira posição alvo */
            else if (mapa[torre.getLinha() - 2][torre.getColuna()] != null) {
                listaDeAlvos.add(mapa[torre.getLinha() - 2][torre.getColuna()]);
            }
            /* Quarta posição alvo */
            else if (torre.getColuna() - 1 >= 0 && mapa[torre.getLinha() - 1][torre.getColuna() - 1] != null) {
                listaDeAlvos.add(mapa[torre.getLinha() - 1][torre.getColuna() - 1]);
            }
        }
        return listaDeAlvos;
    }

    public LinkedList<Entidade> procurarAlvosCanhao(TorreModel torre, Entidade[][] mapa) {
        LinkedList<Entidade> listaDeAlvos = new LinkedList<Entidade>();
        /* Parte de cima do mapa */
        if (torre.getLinha() == 0) {
            /* Primeira posição alvo */
            if (torre.getColuna() + 1 <= 3 && mapa[torre.getLinha() + 1][torre.getColuna() + 1] != null) {
                listaDeAlvos.add(mapa[torre.getLinha() + 1][torre.getColuna() + 1]);
            }
            /* Segunda posição alvo */
            if (mapa[torre.getLinha() + 1][torre.getColuna()] != null) {
                listaDeAlvos.add(mapa[torre.getLinha() + 1][torre.getColuna()]);
            }
            /* Terceira posição alvo */
            if (torre.getColuna() - 1 >= 0 && mapa[torre.getLinha() + 1][torre.getColuna() - 1] != null) {
                listaDeAlvos.add(mapa[torre.getLinha() + 1][torre.getColuna() - 1]);
            }
        }
        /* Parte de baixo do mapa */
        else {
            if (torre.getColuna() + 1 <= 3 && mapa[torre.getLinha() - 1][torre.getColuna() + 1] != null) {
                listaDeAlvos.add(mapa[torre.getLinha() - 1][torre.getColuna() + 1]);
            }
            /* Segunda posição alvo */
            if (mapa[torre.getLinha() - 1][torre.getColuna()] != null) {
                listaDeAlvos.add(mapa[torre.getLinha() - 1][torre.getColuna()]);
            }
            /* Terceira posição alvo */
            if (torre.getColuna() - 1 >= 0 && mapa[torre.getLinha() - 1][torre.getColuna() - 1] != null) {
                listaDeAlvos.add(mapa[torre.getLinha() - 1][torre.getColuna() - 1]);
            }
        }
        return listaDeAlvos;
    }
}


