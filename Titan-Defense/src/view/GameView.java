package view;

import controller.*;
import model.Entidade;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameView implements ActionListener, IRMapaController, IRCidadeController, IRTitaController, IRTorreController {
    IMapaController controle;
    /* Imagens */
    private JFrame janela = new JFrame("Ataque ao titã");
    private ImageIcon teto_vazio = new ImageIcon(getClass().getResource("/img/teto.jpg"));
    private ImageIcon predio1 = new ImageIcon(getClass().getResource("/img/predio1.jpg"));
    private ImageIcon predio2 = new ImageIcon(getClass().getResource("/img/predio2.jpg"));
    private ImageIcon piso = new ImageIcon(getClass().getResource("/img/piso.jpg"));
    private ImageIcon vida_img = new ImageIcon(getClass().getResource("/img/vida.jpg"));
    private ImageIcon gold_img = new ImageIcon(getClass().getResource("/img/gold.jpg"));
    private ImageIcon hannes = new ImageIcon(getClass().getResource("/img/muralha.jpg"));
    private ImageIcon muralha = new ImageIcon(getClass().getResource("/img/muralha.jpg"));
    private ImageIcon colossau = new ImageIcon(getClass().getResource("/img/colossau.jpg"));
    private ImageIcon erro = new ImageIcon(getClass().getResource("/img/erro.jpg"));
    private ImageIcon titan = new ImageIcon(getClass().getResource("/img/titan.jpg"));
    private ImageIcon torreDeFlechas = new ImageIcon(getClass().getResource("/img/TorreDeFlechas.png"));
    private ImageIcon torreCanhao = new ImageIcon(getClass().getResource("/img/torreCanhao.png"));

    private JLabel[][] teto_campo, piso_campo;
    private String[] falas, tipo_torre, evolucao;
    private int vida, gold, n_historia;


    //
    private JButton next = new JButton("NEXT");
    private JButton info = new JButton("???");
    private JButton start = new JButton("play");
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
        vida = 200;
        gold = 150;
        n_historia = 1;
        celula = new JComboBox[2][12];
        teto_campo = new JLabel[2][12];
        piso_campo = new JLabel[2][12];
        String[] p1 = {"Vago","Canhão","flecha"};
        tipo_torre = p1;
        String[] p2 = {"  ", "evoluir"};
        evolucao = p2;
    }

    public void start(String[] falas) throws InterruptedException {
        this.falas = falas;
        menu();
        historia();
        partida();
    }

    private void menu()
    {

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
            Thread.sleep(1500);
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
            Thread.sleep(1500);
            //System.out.print("");
            for (int x = 0; x < 2; x++)
            {
                for (int y = 0; y < 12; y++)
                {
                    int j;
                    if (x==0) j=1;
                    else j=2;
                    Entidade ponteiroMapa = mapaController.getCelula(x, y);
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
            /*if (n_historia >= 16)
            {
                celula[0][3].removeAllItems();
                //celula[0][3].insert(evolucao);
                System.out.println("saiu");
                n_historia = 0;
                teto_campo[0][3].setIcon(colossau);
            }*/
            if (cidadeController.getVida() <= 0) {
                loop = 1;
            }
            /* else {
                mapaController.passarDeFase();
                JOptionPane.showMessageDialog(null, "Os titans evoluirão estão ficando maiores capitão!!!");
            } */
        }
        if (loop == 1)//derrota
        {

        }
        else
        {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub
        if (e.getSource() == next ) n_historia+= 2;
        else if (e.getSource() == info ) JOptionPane.showMessageDialog(null, "teste!\n21354");
        else if (e.getSource() == start )
        {
            titaController.moverTitas();
            mapaController.gerarTitas();
            torreController.ataqueDasTorres();
            titaController.verificarTitas();

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
                    switch (pp)
                    {
                        case "Canhão":
                            mapaController.contruirTorre(j, y, pp);
                            celula[x][y].removeAllItems();
                            teto_campo[x][y].setIcon(torreCanhao);
                            System.out.println(" 1 ");
                            break;
                        case "flecha":
                            mapaController.contruirTorre(j, y, pp);
                            celula[x][y].removeAllItems();
                            teto_campo[x][y].setIcon(torreDeFlechas);
                            System.out.println(" 2 ");
                            break;
                        case "evoluir":
                            mapaController.evoluirTorre(j, y);
                            //teto_campo[x][y].setIcon(trocarrrr);
                            System.out.println(" 3 ");
                            break;
                    }
                }
            }
        }
        System.out.println("entro");
    }
}