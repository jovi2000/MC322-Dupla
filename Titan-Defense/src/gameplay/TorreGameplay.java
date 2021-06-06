package gameplay;

import model.TitaModel;
import model.TorreModel;

public class TorreGameplay {
    /* Torre ataca o titã */
    void atacar(TorreModel torre, TitaModel tita) {
        int vidaFinal = tita.getVida() - torre.getDano();
        tita.setVida(vidaFinal);
    }

    void evoluir(TorreModel torre) {
        // Dependendo do nível, algumas caracteristicas são melhoradas
    }
}
