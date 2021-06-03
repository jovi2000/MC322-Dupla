public class TorreModel extends Entidades {
    /* Atributos */
    private int dano;
    private TorreController controle;

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public TorreController getControle() {
        return controle;
    }

    public void setControle(TorreController controle) {
        this.controle = controle;
    }
}
