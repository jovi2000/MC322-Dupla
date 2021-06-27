package controller;

import model.Entidade;
import model.ITorreModel;
import model.TitaModel;
import model.TorreModel;

import java.util.LinkedList;

public interface ITorreController {
    public void connect(ITorreModel torreModel);

    public void atacarTita(TitaModel tita);

    public void evoluir();

    public void adicionarNaLista();

    public void ataqueDasTorres();

    public int getCusto();

    public void setCusto(int custo);
}
