package gameplay;

import model.Entidade;
import model.TorreModel;

import java.util.LinkedList;

public interface IMapa {
    public LinkedList<Entidade> procurarAlvos(TorreModel torre, Entidade[][] mapa);

    public LinkedList<Entidade> procurarAlvosFlecha(TorreModel torre, Entidade[][] mapa);

    public LinkedList<Entidade> procurarAlvosCanhao(TorreModel torre, Entidade[][] mapa);
}
