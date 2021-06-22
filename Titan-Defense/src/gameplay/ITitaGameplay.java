package gameplay;

import model.Entidade;
import model.TitaModel;

public interface ITitaGameplay {
    public boolean verificarAtaque(TitaModel tita, int colunaCidade);

    public void atacarCidade(TitaModel tita, Entidade cidade);

    public boolean verificarMovimento(TitaModel tita, Entidade[][] mapa);

    public void movimentar(TitaModel tita);

    public boolean verificarMorte(TitaModel tita);
}
