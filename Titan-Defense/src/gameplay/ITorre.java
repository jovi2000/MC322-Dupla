package gameplay;

import model.Entidade;
import model.TorreModel;

import java.util.LinkedList;

public interface ITorre {
    public void evoluir(TorreModel torre);

    public void atacar(TorreModel torre, Entidade tita)

    public LinkedList<Entidade> procurarAlvos(TorreModel torre, Entidade[][] mapa);

    public LinkedList<Entidade> procurarAlvosFlecha(TorreModel torre, Entidade[][] mapa);

    public LinkedList<Entidade> procurarAlvosCanhao(TorreModel torre, Entidade[][] mapa);
}
