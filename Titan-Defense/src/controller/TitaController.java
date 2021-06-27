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
            connect(listaTitas.get(i));
            mapaController.movimentarTita((TitaModel)titaModel); // Muda a posição do titã no mapa
            mudarColuna(); // Muda o atributo coluna do Titã
        }
    }

    /* Método para o View usar */
    /* Funcao que percorre lista de titas para verificar se algum morreu ou chegou na cidade */
    public void verificarTitas() {
        for (int i = 0; i < listaTitas.size(); i++) {
            connect(listaTitas.get(i));
            if (verificarMorte()) {
                cidadeController.aumentarDinheiro(titaModel.getRecompensa());
                mapaController.retirarTitaDoMapa((TitaModel)titaModel); // Se morreu, o Titã é retirado do mapa
                listaTitas.remove(i);
                i--;
            }
            else {
                if (verificarAtaque(cidadeController.getColuna())) {
                    atacarCidade();
                    mapaController.retirarTitaDoMapa((TitaModel)titaModel); // Depois de atacar a cidade, o titã desaparece do mapa
                    listaTitas.remove(i);
                    i--;
                }
            }
        }
    }

    /* Titã ataca a cidade */
    public void atacarCidade() {
        cidadeController.diminuirVida(titaModel.getDano());
    }

    public void mudarColuna() {
        /* Mudando o atributo coluna do titã */
        titaModel.setColuna(titaModel.getColuna() + 1);
    }

    public boolean verificarAtaque(int colunaCidade) {
        return titaModel.getColuna() == colunaCidade;
    }

    /* Se o titã morreu retorna true, se não retorna false */
    public boolean verificarMorte() {
        return titaModel.getVida() <= 0;
    }

    public void diminuirVida(int dano) {
        titaModel.setVida(titaModel.getVida() - dano);
    }

    public int getLinha() {
        return titaModel.getLinha();
    }

    public int getColuna() {
        return titaModel.getColuna();
    }

    public void setLinha(int linha) {
        titaModel.setLinha(linha);
    }

    public void setColuna(int coluna) {
        titaModel.setColuna(coluna);
    }

    public void setDano(int dano) {
        titaModel.setDano(dano);
    }

    public void setRecompensa(int recompensa) {
        titaModel.setRecompensa(recompensa);
    }

    public void setVida(int vida) {
        titaModel.setVida(vida);
    }

    public void adicionarNaLista() {
        listaTitas.add((TitaModel)titaModel);
    }

    public boolean listaVazia() {
        return listaTitas.size() == 0;
    }

}
