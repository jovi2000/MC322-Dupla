package controller;

import gameplay.TitaGameplay;
import gameplay.TorreGameplay;
import model.*;

import java.util.LinkedList;
import java.util.Timer;

public class MapaController {
    /* Atributos */
    private TitaGameplay titaGameplay;
    private TorreGameplay torreGameplay;
    private MapaModel mapa;
    private LinkedList<TitaModel> listaTitas;
    private LinkedList<TorreModel> listaTorres;

    /* Toda vez que o timer for acionado, os titãs nascem, os titãs andam e as torres atiram. Depois dessas ações o
    vetor de titas é percorrido para verificar se algum tita morreu ou chegou na cidade */

    public void movimentoDosTitas() {
        for (int i = 0; i < listaTitas.size(); i++) {
            if (titaGameplay.verificarMovimento(listaTitas.get(i), mapa)) {
                titaGameplay.movimentarTita(listaTitas.get(i), mapa);
                movimentarTita(listaTitas.get(i));
            }
        }
    }

    /* Muda a posição do titã no mapa */
    public void movimentarTita(TitaModel tita) {
        Entidades[][] mapaAtual = mapa.getMapaMatriz();
        mapaAtual[tita.getLinha()][tita.getColuna()] = null;
        mapaAtual[tita.getLinha()][tita.getColuna() + tita.getMovimento()] = tita;
        mapa.setMapaMatriz(mapaAtual);
    }

    /* Percorre o vetor de torres para ver qual as torres que podem atacar */
    void ataqueDasTorres() {
        for (int i = 0; i < listaTorres.size(); i++) {
        }
    }

    /* Funcao que percorre vetor de titas para ver se algum morreu ou chegou na cidade */
    public void verificarTitas() {
        for (int i = 0; i < listaTitas.size(); i++) {
            if (titaGameplay.verificarMorte(listaTitas.get(i))) {
                retirarTitaDoMapa(listaTitas.get(i));
            }
            else {
                if (titaGameplay.verificarAtaque(listaTitas.get(i), mapa.getColunaDaCidade())) {
                    titaGameplay.atacar(listaTitas.get(i), mapa);
                    retirarTitaDoMapa(listaTitas.get(i));
                }
            }
        }
    }

    public void contruirTorre(int linha, int coluna, char tipo) {
        Entidades[][] mapaAtual = mapa.getMapaMatriz();
        if (tipo == 'f') {
            mapaAtual[linha][coluna] = new TorreDeFlechas();
        }
        else {
            mapaAtual[linha][coluna] = new TorreCanhao();
        }
        mapa.setMapaMatriz(mapaAtual);
    }

    public void evoluirTorre(int linha, int coluna) {
        Entidades[][] mapaAtual = mapa.getMapaMatriz();
        torreGameplay.evoluir(mapaAtual[linha][coluna]);
        mapa.setMapaMatriz(mapaAtual);
    }

    public void gerarTitas() {

    }

    public void retirarTitaDoMapa(TitaModel tita) {
        /* Tirando o titã do mapa */
        Entidades[][] mapaAtual = mapa.getMapaMatriz();
        mapaAtual[tita.getLinha()][tita.getColuna()] = null;
        mapa.setMapaMatriz(mapaAtual);
    }

}
