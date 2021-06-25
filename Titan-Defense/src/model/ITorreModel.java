package model;

public interface ITorreModel extends IEntidade {
    public int getNivel();

    public void setNivel(int nivel);

    public int getDano();

    public void setDano(int dano);

    public int getCusto();

    public void setCusto(int custo);

    public char getTipo();

    public void setTipo(char tipo);
}
