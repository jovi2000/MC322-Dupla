package controller;

import model.Entidade;
import model.TitaModel;
import model.TorreModel;

import java.util.LinkedList;

public interface IDadosModel {
    public void movimentarTita(TitaModel tita);

    public void retirarTitaDoMapa(TitaModel tita);

    public void atacarAlvos(TorreModel torre, LinkedList<Entidade> alvos);


}
