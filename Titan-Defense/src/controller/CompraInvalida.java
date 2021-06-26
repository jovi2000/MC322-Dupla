package controller;

/* Classe Exceção */
public class CompraInvalida extends Exception {
    public CompraInvalida() {
        super();
    }

    public CompraInvalida(String message) {
        super(message);
    }
}
