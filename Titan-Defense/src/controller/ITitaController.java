package controller;

import model.CidadeModel;
import model.Entidade;
import model.TitaModel;

public interface ITitaController {
    public boolean verificarAtaque(TitaModel tita, int colunaCidade);

    public void atacarCidade(TitaModel tita);

    public void mudarColuna(TitaModel tita);

    public boolean verificarMorte(TitaModel tita);

    public void diminuirVida(Entidade tita, int dano);

    public void moverTitas();

    public void verificarTitas();

    public int getLinha(TitaModel tita);

    public int getColuna(TitaModel tita);

    public boolean listaVazia();

}
