package gameplay;

import model.Entidade;
import model.TorreModel;

import java.util.LinkedList;

public interface ITorreGameplay {
    public void atacarTita(TorreModel torre, Entidade tita);

    public void evoluir(TorreModel torre);

    public LinkedList<Entidade> procurarAlvos(TorreModel torre, Entidade[][] mapa);

}
