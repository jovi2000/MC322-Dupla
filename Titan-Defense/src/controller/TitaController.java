package controller;

import model.*;

import java.util.LinkedList;

public class TitaController implements ITitaController, IRTitaModel, IRCidadeController, IRMapaController {
    /* Atributos */
    private LinkedList<TitaModel> listaTitas;

    /* Interfaces */
    private IMapaController mapaController;
    private ICidadeController cidadeController;
    private ITitaModel titaModel;

    /* Constutor */

    public TitaController() {
        listaTitas = new LinkedList<TitaModel>();
    }

    /* Getters e Setters */

    public IMapaController getMapaController() {
        return mapaController;
    }

    public void setMapaController(IMapaController mapaController) {
        this.mapaController = mapaController;
    }

    public ICidadeController getCidadeController() {
        return cidadeController;
    }

    public void setCidadeController(ICidadeController cidadeController) {
        this.cidadeController = cidadeController;
    }

    public ITitaModel getTitaModel() {
        return titaModel;
    }

    public void setTitaModel(ITitaModel titaModel) {
        this.titaModel = titaModel;
    }

    /* Métodos */
    public void connect(IMapaController mapaController) {
        this.mapaController = mapaController;
    }

    public void connect(ICidadeController cidadeController) {
        this.cidadeController = cidadeController;
    }

    public void connect(ITitaModel titaModel) {
        this.titaModel = titaModel;
    }

    /* Retorna true caso o titã tenha chegado na cidade */
    public boolean verificarAtaque(TitaModel tita, int colunaCidade) {
        return tita.getColuna() == colunaCidade;
    }

    /* Método para o View usar */
    public void moverTitas() {
        for (int i = 0; i < listaTitas.size(); i++) {
            mudarColuna(listaTitas.get(i)); // Muda o atributo coluna do Titã
            mapaController.movimentarTita(listaTitas.get(i)); // Muda a posição do titã no mapa
        }
    }

    /* Método para o View usar */
    /* Funcao que percorre lista de titas para verificar se algum morreu ou chegou na cidade */
    public void verificarTitas() {
        for (int i = 0; i < listaTitas.size(); i++) {
            if (verificarMorte(listaTitas.get(i))) {
                cidadeController.aumentarDinheiro(listaTitas.get(i).getRecompensa());
                mapaController.retirarTitaDoMapa(listaTitas.get(i)); // Se morreu, o Titã é retirado do mapa
            }
            else {
                if (verificarAtaque(listaTitas.get(i), cidadeController.getColunaModel())) {
                    atacarCidade(listaTitas.get(i));
                    mapaController.retirarTitaDoMapa(listaTitas.get(i)); // Depois de atacar a cidade, o titã desaparece do mapa
                }
            }
        }
    }

    /* Titã ataca a cidade */
    public void atacarCidade(TitaModel tita) {
        cidadeController.diminuirVida(tita.getDano());
    }

    public void mudarColuna(TitaModel tita) {
        /* Mudando o atributo coluna do titã */
        tita.setColuna(tita.getColuna() + 1);
    }

    /* Se o titã morreu retorna true, se não retorna false */
    public boolean verificarMorte(TitaModel tita) {
        return tita.getVida() <= 0;
    }

    public void diminuirVida(Entidade torre, int dano) {
        torre.setVida(torre.getVida() - dano);
    }

    public int getLinha(TitaModel tita) {
        return tita.getLinha();
    }

    public int getColuna(TitaModel tita) {
        return tita.getColuna();
    }

    public void adicionarNaLista(TitaModel tita) {
        listaTitas.add(tita);
    }

    public boolean listaVazia() {
        return listaTitas.size() == 0;
    }

}
