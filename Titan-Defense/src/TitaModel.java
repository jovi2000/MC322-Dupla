public class TitaModel extends Entidades {
    /* Atributos */
    private int dano;
    private int vida;
    private TitaController controle;

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public TitaController getControle() {
        return controle;
    }

    public void setControle(TitaController controle) {
        this.controle = controle;
    }
}
