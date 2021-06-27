package controller;

import model.CidadeModel;
import model.Entidade;
import model.ITitaModel;
import model.TitaModel;

public interface ITitaController {
    public void connect(ITitaModel titaModel);

    public boolean verificarAtaque(int colunaCidade);

    public void atacarCidade();

    public void mudarColuna();

    public boolean verificarMorte();

    public void diminuirVida(int dano);

    public void moverTitas();

    public void verificarTitas();

    public int getLinha();

    public int getColuna();

    public void setLinha(int linha);

    public void setColuna(int coluna);

    public void setRecompensa(int recompensa);

    public void setVida(int vida);

    public void adicionarNaLista();

    public void setDano(int dano);

    public boolean listaVazia();
}
