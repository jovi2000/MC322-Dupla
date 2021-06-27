package controller;

import model.CidadeModel;
import model.MapaModel;
import view.CSVReader;
import view.GameView;

import java.rmi.server.UnicastRemoteObject;

public class Montador {
    private GameView gameView;

    public Montador() {
        gameView = new GameView();
    }

    public GameView getGameView() {
        return gameView;
    }

    public void montarJogo() throws InterruptedException {
        MapaController mapaController = new MapaController();
        CidadeController cidadeController = new CidadeController();
        TitaController titaController = new TitaController();
        TorreController torreController = new TorreController();
        MapaModel mapaModel = new MapaModel();
        CidadeModel cidadeModel = new CidadeModel();

        /* Referenciando */

        // MapaController
        mapaController.setMapaModel(mapaModel);
        mapaController.setCidadeController(cidadeController);
        mapaController.setTorreController(torreController);
        mapaController.setTitaController(titaController);

        // CidadeController
        cidadeController.setCidadeModel(cidadeModel);

        // TitaController
        titaController.setCidadeController(cidadeController);
        titaController.setMapaController(mapaController);

        // TorreController
        torreController.setMapaController(mapaController);
        torreController.setTitaController(titaController);

        // GameView
        gameView.setCidadeController(cidadeController);
        gameView.setMapaController(mapaController);
        gameView.setTitaController(titaController);
        gameView.setTorreController(torreController);

    }
}
