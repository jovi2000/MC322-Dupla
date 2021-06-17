package controller;

import gameplay.TitaGameplay;
import gameplay.TorreGameplay;
import model.*;

import java.util.LinkedList;

public class MapaController implements IDadosView, IDadosModel , IController {
    /* Atributos */
    private TitaGameplay titaGameplay;
    private TorreGameplay torreGameplay;
    private Entidade[][] mapa;
    private CidadeModel cidade;
    private LinkedList<TitaModel> listaTitas;
    private LinkedList<TorreModel> listaTorres;

    /* Toda vez que o timer for acionado, os titãs nascem, os titãs andam e as torres atiram. Depois dessas ações o
    vetor de titas é percorrido para verificar se algum tita morreu ou chegou na cidade */

    public void movimentoDosTitas() {
        for (int i = 0; i < listaTitas.size(); i++) {
            if (titaGameplay.verificarMovimento(listaTitas.get(i), mapa)) {
                titaGameplay.movimentar(listaTitas.get(i)); // Muda o atributo coluna do Titã
                movimentarTita(listaTitas.get(i)); // Muda a posição do titã no mapa
            }
        }
    }

    /* Muda a posição do titã no mapa */
    public void movimentarTita(TitaModel tita) {
        mapa[tita.getLinha()][tita.getColuna()] = null;
        mapa[tita.getLinha()][tita.getColuna() + tita.getMovimento()] = tita;
    }

    /* Funcao que percorre vetor de titas para verificar se algum morreu ou chegou na cidade */
    public void verificarTitas() {
        for (int i = 0; i < listaTitas.size(); i++) {
            if (titaGameplay.verificarMorte(listaTitas.get(i))) {
                retirarTitaDoMapa(listaTitas.get(i)); // Se morreu, o Titã é retirado do mapa
            }
            else {
                if (titaGameplay.verificarAtaque(listaTitas.get(i), cidade.getColuna())) {
                    titaGameplay.atacar(listaTitas.get(i), cidade);
                    retirarTitaDoMapa(listaTitas.get(i)); // Depois de atacar a cidade, o titã desaparece do mapa
                }
            }
        }
    }

    public void retirarTitaDoMapa(TitaModel tita) {
        /* Tirando o titã do mapa */
        mapa[tita.getLinha()][tita.getColuna()] = null;
    }

    public void gerarTitas() {
        //Dependendo da fase terá um vetor com um certo número de titãs que irão spawnar
        // Colocar cada titã que nasce no vetor
    }

    /* Percorre o vetor de torres para ver qual as torres que podem atacar */
    public void ataqueDasTorres() {
        LinkedList<Entidade> listaDeAlvos;
        for (int i = 0; i < listaTorres.size(); i++) {
            listaDeAlvos = torreGameplay.procurarAlvos(listaTorres.get(i), mapa);
            atacarAlvos(listaTorres.get(i), listaDeAlvos);
        }
    }

    public void atacarAlvos(TorreModel torre, LinkedList<Entidade> alvos) {
        for (int i = 0; i < alvos.size(); i++) {
            torreGameplay.atacar(torre, alvos.get(i));
        }
    }

    public void contruirTorre(int linha, int coluna, char tipo) {
        if (tipo == 'f') {
            mapa[linha][coluna] = new TorreDeFlechas();
        }
        else {
            mapa[linha][coluna] = new TorreCanhao();
        }
        listaTorres.add((TorreModel)mapa[linha][coluna]);
    }

    public void evoluirTorre(int linha, int coluna) {
        torreGameplay.evoluir((TorreModel)mapa[linha][coluna]);
    }
}