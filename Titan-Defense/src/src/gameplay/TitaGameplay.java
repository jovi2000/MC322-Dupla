package gameplay;

import model.Entidade;
import model.TitaModel;

public class TitaGameplay implements ITita {
    /* Retorna true caso o titã tenha chegado na cidade */
    public boolean verificarAtaque(TitaModel tita, int colunaCidade) {
        return tita.getColuna() == colunaCidade;
    }

    /* Titã ataca a cidade */
    public void atacar(Entidade tita, Entidade cidade) {
        int vidaFinal = cidade.getVida() - tita.getDano();
        cidade.setVida(vidaFinal);
    }

    /* Verifica se o movimento que o titã deseja fazer é valido */
    public boolean verificarMovimento(TitaModel tita, Entidade[][] mapa) {
        /* Caso o movimento possa ser realizado */
        if () {
            // condições para o movimento ser realizado
            return true;
        }
        return false;
    }

    public void movimentar(TitaModel tita) {
        /* Mudando o atributo coluna do titã */
        int novaColuna = tita.getColuna() + tita.getMovimento();
        tita.setColuna(novaColuna);
    }

    /* Se o titã morreu retorna true, se não retorna false */
    public boolean verificarMorte(TitaModel tita) {
        return tita.getVida() <= 0;
    }

}
