package view;

import controller.Montador;

public class AppMain {
    public static void main(String[] args) {
        Montador montador = new Montador();
        montador.montarJogo();
        GameView gameView = montador.getGameView();
        CSVReader csv = new CSVReader();
        csv.setDataSource("/img/historia2.csv");
        gameView.start(csv.requestCommands());
    }
}
