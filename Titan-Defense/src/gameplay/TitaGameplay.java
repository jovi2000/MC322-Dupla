package gameplay;

import model.Entidades;
import model.MapaModel;
import model.TitaModel;

public class TitaGameplay implements IGameplay{
    /* Retorna true caso o titã tenha chegado na cidade */
    public boolean verificarAtaque(TitaModel tita, int colunaCidade) {
        return tita.getColuna() == colunaCidade;
    }

    /* Titã ataca a cidade */
    public void atacar(TitaModel tita, MapaModel mapaAtual) {
        int vidaFinal = mapaAtual.getVida() - tita.getDano();
        mapaAtual.setVida(vidaFinal);
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

    public void movimentarTita(TitaModel tita, MapaModel mapaAtual) {
        /* Mudando o atributo coluna do titã */
        int novaColuna = tita.getColuna() + tita.getMovimento();
        tita.setColuna(novaColuna);
    }

    /* Se o titã morreu retorna true, se não retorna false */
    public boolean verificarMorte(TitaModel tita) {
        return tita.getVida() <= 0;
    }
}
