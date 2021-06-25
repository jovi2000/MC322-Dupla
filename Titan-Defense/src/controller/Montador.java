package controller;

import model.CidadeModel;
import model.MapaModel;
import view.CSVReader;
import view.GameView;

import java.rmi.server.UnicastRemoteObject;

public class Montador {
    public void montarJogo() {
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
        GameView gameView = new GameView();
        gameView.setCidadeController(cidadeController);
        gameView.setMapaController(mapaController);
        gameView.setTitaController(titaController);
        gameView.setTorreController(torreController);

        CSVReader csv = new CSVReader();
        csv.setDataSource("/img/historia2.csv");
        gameView.start(csv.requestCommands());
    }
}
