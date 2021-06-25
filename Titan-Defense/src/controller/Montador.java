package controller;

import model.CidadeModel;
import model.MapaModel;
import view.GameView;

import java.rmi.server.UnicastRemoteObject;

public class Montador {
    GameView gameView = new GameView();
    public void montarJogo() {
        MapaController mapaController = new MapaController();
        CidadeController cidadeController = new CidadeController();
        TitaController titaController = new TitaController();
        TorreController torreController = new TorreController();
        MapaModel mapaModel = new MapaModel();
        CidadeModel cidadeModel = new CidadeModel();

        /* Referenciando */

        // GameView
        gameView.setCidadeController(cidadeController);
        gameView.setMapaController(mapaController);
        gameView.setTitaController(titaController);
        gameView.setTorreController(torreController);

        // MapaController
        mapaController.setMapaModel(mapaModel);
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

    }
    public GameView getGameView() {
        return gameView;
    }
}
