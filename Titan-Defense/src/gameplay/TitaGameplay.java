package gameplay;

import model.MapaModel;
import model.TitaModel;

public class TitaGameplay {
    /* Titã ataca a cidade */
    void atacar(TitaModel tita, MapaModel cidade) {
        int vidaFinal = cidade.getVida() - tita.getDano();
        cidade.setVida(vidaFinal);
    }

    /* Verifica se o movimento que o titã deseja fazer é valido */
    public boolean verificarMovimento(TitaModel tita, MapaModel cidade) {
        /* Caso o movimento possa ser realizado */
        if () {
            // condições para o movimento ser realizado
            return true;
        }
        return false;
    }
}
