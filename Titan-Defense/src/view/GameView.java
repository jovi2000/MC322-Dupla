package view;

import controller.*;
import model.Entidade;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameView implements ActionListener, IRMapaController, IRCidadeController, IRTitaController, IRTorreController {
    IMapaController controle;
    /* Imagens */
    private JFrame janela = new JFrame("Ataque ao titã");
    private JFrame game_over = new JFrame("Ataque ao titã");
    private ImageIcon teto_vazio = new ImageIcon(getClass().getResource("/img/teto.jpg"));
    private ImageIcon predio1 = new ImageIcon(getClass().getResource("/img/ruinasMarrom.jpg"));
    private ImageIcon predio2 = new ImageIcon(getClass().getResource("/img/predio2.jpg"));
    private ImageIcon piso = new ImageIcon(getClass().getResource("/img/chaoDePedra2.jpg"));
    private ImageIcon vida_img = new ImageIcon(getClass().getResource("/img/gold.jpg"));
    private ImageIcon gold_img = new ImageIcon(getClass().getResource("/img/vida.jpg"));
    private ImageIcon hannes = new ImageIcon(getClass().getResource("/img/predio2.jpg"));
    private ImageIcon muralha = new ImageIcon(getClass().getResource("/img/muralha.jpg"));
    private ImageIcon colossau = new ImageIcon(getClass().getResource("/img/colossau.jpg"));
    private ImageIcon erro = new ImageIcon(getClass().getResource("/img/erro.jpg"));
    private ImageIcon titan = new ImageIcon(getClass().getResource("/img/titan.jpg"));
    private ImageIcon torreDeFlechas = new ImageIcon(getClass().getResource("/img/TorreDeFlechas.png"));
    private ImageIcon torreCanhao = new ImageIcon(getClass().getResource("/img/torreCanhao.png"));

    private JLabel[][] teto_campo, piso_campo;
    private String[] falas, tipo_torre, evolucao;
    private int vida, gold, n_historia, aleatorio;


    //
    private JButton next = new JButton("NEXT");
    private JButton info = new JButton("Help");
    private JButton start = new JButton("Play");
    private JComboBox[][] celula;

    /* Interfaces */
    private IMapaController mapaController;
    private ICidadeController cidadeController;
    private ITitaController titaController;
    private ITorreController torreController;

    /* Getters e Setters */
    public IMapaController getMapaController() {
        return mapaController;
    }

    public void setMapaController(IMapaController mapaController) {
        this.mapaController = mapaController;
    }

    public ICidadeController getCidadeController() {
        return cidadeController;
    }

    public void setCidadeController(ICidadeController cidadeController) {
        this.cidadeController = cidadeController;
    }

    public ITitaController getTitaController() {
        return titaController;
    }

    public void setTitaController(ITitaController titaController) {
        this.titaController = titaController;
    }

    public ITorreController getTorreController() {
        return torreController;
    }

    public void setTorreController(ITorreController torreController) {
        this.torreController = torreController;
    }

    /* Connects */
    public void connect(IMapaController mapaController) {
        this.mapaController = mapaController;
    }

    public void connect(ICidadeController cidadeController) {
        this.cidadeController = cidadeController;
    }

    public void connect(ITitaController titaController) {
        this.titaController = titaController;
    }

    public void connect(ITorreController torreController) {
        this.torreController = torreController;
    }

    String pp;


    public GameView()
    {
        janela.setSize(1300,1000);
        janela.setVisible(true);
        aleatorio = 0;
        vida = 200;
        gold = 150;
        n_historia = 1;
        celula = new JComboBox[2][12];
        teto_campo = new JLabel[2][12];
        piso_campo = new JLabel[2][12];
        String[] p1 = {"Vago","Canhão","Flecha"};
        tipo_torre = p1;
    }

    public void start(String[] falas) throws InterruptedException {
        this.falas = falas;
        //historia();
        partida();
        end();
    }

    public void end() throws InterruptedException {
        n_historia = 0;
        janela.setVisible(false);
        game_over.setSize(1300,100);
        game_over.setVisible(true);
        game_over.setLayout(new BorderLayout());
        if(vida <= 0)
        {
            JLabel img;
            JLabel img_hannes = new JLabel(hannes);
            img= img_hannes;
            game_over.add(BorderLayout.CENTER, img);
            game_over.repaint();

        }
        else
        {
            game_over.setLayout(new BorderLayout());
            JLabel img;
            JLabel img_hannes = new JLabel(hannes);
            img= img_hannes;
            game_over.add(BorderLayout.CENTER, img);
            next.addActionListener(this);
            game_over.add(BorderLayout.SOUTH, next);
            while (n_historia > 2)
            {
                Thread.sleep(250);
            }
            game_over.remove(img);
            JLabel fala_txt = new JLabel();
            fala_txt.setText("voce salvol" + vida + "Digite seu nome");
            game_over.add(BorderLayout.CENTER, fala_txt);
            JTextField caixa = new JTextField(10);
            game_over.add(BorderLayout.CENTER, caixa);
            while (n_historia > 4)
            {
                Thread.sleep(250);
            }
        }
    }



    private void historia() throws InterruptedException {
        janela.setLayout(new BorderLayout());

        JLabel img;
        JLabel img_hannes = new JLabel(hannes);
        img= img_hannes;
        janela.add(BorderLayout.WEST, img);

        JLabel fala_txt = new JLabel();
        fala_txt.setText(falas[n_historia]);
        janela.add(BorderLayout.CENTER, fala_txt);
        next.addActionListener(this);
        janela.add(BorderLayout.SOUTH, next);

        int loop = falas.length;
        loop--;
        int chave = 1;
        int fechadura = 1;
        while (n_historia < loop)
        {
            Thread.sleep(250);
            fala_txt.setText(falas[n_historia]);
            janela.repaint();
            if (chave != fechadura)
            {
                if (chave == 1) img.setIcon(hannes);
                else if (chave == 2) img.setIcon(colossau);
                else if (chave == 2) img.setIcon(muralha);
                else img.setIcon(erro);
                fechadura = chave;
            }
            switch(falas[n_historia-1])
            {
                case "hannes":
                    chave = 1;
                    break;
                case "colossau":
                    chave = 2;
                    break;
                case "muralha":
                    chave = 3;
                    break;
                default:
                    chave = 4;
                    break;
            }
        }
        janela.remove(next);
        janela.remove(fala_txt);
        janela.remove(img);
    }

    private void partida() throws InterruptedException {
        janela.setLayout(new GridLayout(9, 12));
        janela.repaint();
        for(int x = 0; x < 9; x++)
        {
            for (int y = 0; y < 12; y++)
            {
                if (x == 0 || x == 7)
                {
                    int j;
                    if (x==0) j=0;
                    else j=1;
                    celula[j][y] = new JComboBox(tipo_torre);
                    celula[j][y].addActionListener(this);
                    janela.add(celula[j][y]);
                }
                else if (x == 1 || x == 6)
                {
                    int j;
                    if (x==1) j = 0;
                    else j = 1;
                    JLabel teto = new JLabel(teto_vazio);
                    teto_campo[j][y] = teto;
                    janela.add(teto_campo[j][y]);
                }
                else if (x == 2 || x == 5)
                {
                    if (x == 2)
                    {
                        JLabel campo = new JLabel(predio1);
                        janela.add(campo);
                    }
                    else
                    {
                        JLabel campo = new JLabel(predio2);
                        janela.add(campo);
                    }
                }
                else if (x == 3 || x == 4)
                {
                    int j;
                    if (x==3) j = 0;
                    else j = 1;
                    JLabel piso_vazio = new JLabel(piso);
                    piso_campo[j][y] = piso_vazio;
                    janela.add(piso_campo[j][y]);
                }
            }
        }

        JLabel vida_campo = new JLabel(vida_img);
        janela.add(vida_campo);
        JLabel vida_print = new JLabel();
        String vidaa = "" + vida;
        vida_print.setText(vidaa);
        janela.add(vida_print);

        JLabel gold_campo = new JLabel(gold_img);
        janela.add(gold_campo);
        JLabel gold_print = new JLabel();
        String goldd = "" + gold;
        gold_print.setText(goldd);
        janela.add(gold_print);

        for (int i = 4; i < 10; i++)
        {
            JLabel campo = new JLabel(piso);
            janela.add(campo);
        }
        info.addActionListener(this);
        janela.add(info);
        start.addActionListener(this);
        janela.add(start);
        int loop = 0;
        while(loop == 0)
        {
            janela.repaint();
            vida = cidadeController.getDinheiro();
            gold = cidadeController.getVida();
            goldd = "" + gold;
            gold_print.setText(goldd);
            vidaa = "" + vida;
            vida_print.setText(vidaa);
            Thread.sleep(250);
            //System.out.print("");
            for (int x = 0; x < 2; x++)
            {
                for (int y = 0; y < 12; y++)
                {
                    int j;
                    if (x==0) j=1;
                    else j=2;
                    Entidade ponteiroMapa = mapaController.getCelula(j, y);
                    if (ponteiroMapa == null)
                    {
                        piso_campo[x][y].setIcon(piso);
                    }
                    else
                    {
                        piso_campo[x][y].setIcon(titan);
                    }

                }
            }
            if (cidadeController.getVida() <= 0 || mapaController.getFase() == 5) {
                loop = 1;
            }
            if (aleatorio == 1 && titaController.listaVazia()) {
                mapaController.passarDeFase();
                JOptionPane.showMessageDialog(null, "Você passou de fase!!\nOs titans estão evoluindo e ficando maiores, capitão!!!");
                aleatorio = 0;
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub
        if (e.getSource() == next ) n_historia+= 2;
        else if (e.getSource() == info ) JOptionPane.showMessageDialog(null, "Vida dos titans: 70, 74, 78, 82, 86 (conforme a fase)\n\nDano das Torres:\nFlecha: 25, 30, 35 (conforme o nivel)\nCanhão: 15, 20 ,25 (conforme o nivel)\n\nCusto:\nFlecha: 70; Canhão: 90 \nEvoluir para o Nivel 2: 10\nEvoluir para o Nivel 3: 15 \n\nComo as torres dão dano: \nO canhão da dano simultâneo nas 3 celulas da linha mais proxima a ele\n+ + + C + + +\n# # *  *  *  # #\n# # # # # # #\n+ + + + + + +\n \nA torre de flecha da dano em T no titan mais proximo da cidade conforme o alcance\n+ + + F + + +\n# # 4 2 1 # #\n# # # 3 # # #\n+ + + + + + +");
        else if (e.getSource() == start )
        {
            titaController.moverTitas();
            mapaController.gerarTitas();
            torreController.ataqueDasTorres();
            titaController.verificarTitas();
            aleatorio = 1;
        }

        for (int x = 0; x < 2; x++)
        {
            for (int y = 0; y < 12; y++)
            {
                if  (e.getSource() == celula[x][y])
                {
                    pp = (String) celula[x][y].getSelectedItem();
                    int j;
                    if (x==0) j=0;
                    else j=3;
                    boolean compraValida = true;
                    switch (pp)
                    {
                        case "Canhão":
                            try {
                                mapaController.contruirTorreCanhao(j, y);
                            }
                            catch (CompraInvalida erro) {
                                compraValida = false;
                                celula[x][y].setSelectedItem("Vago");
                                JOptionPane.showMessageDialog(null, erro.getMessage());
                            }
                            if (compraValida) {
                                celula[x][y].removeAllItems();
                                teto_campo[x][y].setIcon(torreCanhao);
                                celula[x][y].addItem("Nível 1");
                                celula[x][y].addItem("Evoluir 2");
                            }
                            compraValida = true;
                            break;
                        case "Flecha":
                            try {
                                mapaController.contruirTorreDeFlechas(j, y);
                            }
                            catch (CompraInvalida erro) {
                                compraValida = false;
                                celula[x][y].setSelectedItem("Vago");
                                JOptionPane.showMessageDialog(null, erro.getMessage());
                            }
                            if (compraValida) {
                                celula[x][y].removeAllItems();
                                teto_campo[x][y].setIcon(torreDeFlechas);
                                celula[x][y].addItem("Nível 1");
                                celula[x][y].addItem("Evoluir 2");
                            }
                            compraValida = true;
                            break;
                        case "Evoluir 2":
                            try {
                                mapaController.evoluirTorre(j, y);
                            }
                            catch (CompraInvalida erro) {
                                compraValida = false;
                                celula[x][y].setSelectedItem("Nível 1");
                                JOptionPane.showMessageDialog(null, erro.getMessage());
                            }
                            if (compraValida) {
                                celula[x][y].removeAllItems();
                                celula[x][y].addItem("Nível 2");
                                celula[x][y].addItem("Evoluir 3");
                            }
                            compraValida = true;
                            break;
                        case "Evoluir 3":
                            try {
                                mapaController.evoluirTorre(j, y);
                            }
                            catch (CompraInvalida erro) {
                                compraValida = false;
                                celula[x][y].setSelectedItem("Nível 2");
                                JOptionPane.showMessageDialog(null, erro.getMessage());
                            }
                            if (compraValida) {
                                celula[x][y].removeAllItems();
                                celula[x][y].addItem("Nível 3");
                            }
                            compraValida = true;
                            break;
                    }
                }
            }
        }
        System.out.println("entro");
    }
}