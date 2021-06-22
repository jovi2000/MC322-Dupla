package model;

public interface ITorreModel extends IEntidade {
    public int getNivel();

    public void setNivel(int nivel);

    public int getDano();

    public void setDano(int dano);

    public char getTipo();

    public void setTipo(char tipo);
}
