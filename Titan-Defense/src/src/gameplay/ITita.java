package gameplay;

import model.Entidade;
import model.TitaModel;

public interface ITita {
    public void atacar(Entidade tita, Entidade cidade);
    // Quem ta no parametro cede
    // QUem requer solicita

    public boolean verificarMovimento(TitaModel tita, Entidade[][] mapa);

    public void movimentar(TitaModel tita);

    public boolean verificarMorte(TitaModel tita);
}
