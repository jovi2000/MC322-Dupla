package view;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Janela 
{
	JFrame janela = new JFrame("Ataque ao titã");
	ImageIcon teto = new ImageIcon("/home/arima/Área de Trabalho/mc322/view/data/teto.jpg");
	ImageIcon predio1 = new ImageIcon("/home/arima/Área de Trabalho/mc322/view/data/predio1.jpg");
	ImageIcon predio2 = new ImageIcon("/home/arima/Área de Trabalho/mc322/view/data/predio2.jpg");
	ImageIcon piso = new ImageIcon("/home/arima/Área de Trabalho/mc322/view/data/piso.jpg");
	ImageIcon vida_img = new ImageIcon("/home/arima/Área de Trabalho/mc322/view/data/vida.jpg");
	ImageIcon gold_img = new ImageIcon("/home/arima/Área de Trabalho/mc322/view/data/gold.jpg");
	ImageIcon hannes = new ImageIcon("/home/arima/Área de Trabalho/mc322/view/data/Hannes.jpg");
	
	
	JLabel[][] celula;
	int vida, gold, n_historia;
	Janela()
	{
		 janela.setSize(1300,1000);
		 janela.setVisible(true);
		 vida = 100;
		 gold = 1234;
		 n_historia = 0;
		 celula = new JLabel[9][12];
	}
	void historia(String[] falas) 
	{
		janela.setLayout(new BorderLayout());
		
		JLabel hannes_img = new JLabel(hannes);
		janela.add(BorderLayout.WEST, hannes_img);
		
		JLabel fala_txt = new JLabel();
		fala_txt.setText(falas[n_historia]);
		janela.add(BorderLayout.CENTER, fala_txt);

		/*JButton next = new JButton("NEXT");
		janela.add(BorderLayout.SOUTH, next);
		Janela action = new Janela();
		next.addActionListener(action);*/
	}
	void monta()
	{
		janela.setLayout(new GridLayout(9, 12));
		for(int x = 0; x < 9; x++)
		{
			for (int y = 0; y < 12; y++)
			{
				if (x == 0 || x == 7)
				{
					JComboBox tipo_torre = new JComboBox();
					tipo_torre.addItem("Vago");
					tipo_torre.addItem("canhão");
					tipo_torre.addItem("flecha");	
					janela.add(tipo_torre);
				}
				else if (x == 1 || x == 6)
				{
					JLabel teto_campo = new JLabel(teto);
					janela.add(teto_campo);
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
					JLabel campo = new JLabel(piso);
					janela.add(campo);
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
				 	 
		for (int i = 4; i < 11; i++)
		{
			JLabel campo = new JLabel(piso);
			janela.add(campo);
		}	
		janela.add(new JButton("Start"));
	}

}