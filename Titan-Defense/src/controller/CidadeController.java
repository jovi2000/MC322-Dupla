package controller;

import model.CidadeModel;
import model.ICidadeModel;

public class CidadeController implements ICidadeController, IRCidadeModel {
    private ICidadeModel cidadeModel;

    public CidadeController() {

    }

    public void connect(CidadeModel cidadeModel) {
        this.cidadeModel = cidadeModel;
    }

    public void diminuirVida(int dano) {
        cidadeModel.setVida(cidadeModel.getVida() - dano);
    }

    public void aumentarDinheiro(int recompensa) {
        cidadeModel.setDinheiro(cidadeModel.getDinheiro() + recompensa);
    }

    public void diminuirDinheiro(int gasto) {
        cidadeModel.setDinheiro(cidadeModel.getDinheiro() - gasto);
    }

    public int getColunaModel() {
        return cidadeModel.getColuna();
    }

    public int getVida() {
        return cidadeModel.getVida();
    }

    public int getDinheiro() {
        return cidadeModel.getDinheiro();
    }
}
