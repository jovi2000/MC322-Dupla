package controller;

import model.Entidade;
import model.TitaModel;
import model.TorreModel;

import java.util.LinkedList;

public interface ITorreController {
    public void atacarTita(TorreModel torre, TitaModel tita);

    public void evoluir(TorreModel torre);

    public LinkedList<Entidade> procurarAlvos(TorreModel torre);

    public void adicionarNaLista(TorreModel torre);

}
