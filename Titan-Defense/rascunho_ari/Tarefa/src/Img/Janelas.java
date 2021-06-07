package Img;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Janelas 
{
	static JFrame janela = new JFrame("Meu primeiro frame em Java");
	public static void main(String[] args) 
	{
		 janela.setSize(1300,1000);
		 janela.setLayout(new GridLayout(7, 12));
		 janela.setVisible(true);
		 ImageIcon teto = new ImageIcon("/home/arima/Área de Trabalho/mc322/Tarefa/data/teto.jpg");
		 ImageIcon predio1 = new ImageIcon("/home/arima/Área de Trabalho/mc322/Tarefa/data/predio1.jpg");
		 ImageIcon predio2 = new ImageIcon("/home/arima/Área de Trabalho/mc322/Tarefa/data/predio2.jpg");
		 ImageIcon piso = new ImageIcon("/home/arima/Área de Trabalho/mc322/Tarefa/data/piso.jpg");

		 
		 for (int i = 0; i < 12; i++)
		 {
			 JComboBox tipo_torre = new JComboBox();
			 tipo_torre.addItem("Vago");
			 tipo_torre.addItem("canhão");
			 tipo_torre.addItem("flecha");
			 janela.add(tipo_torre);
		 }
		 for (int i = 0; i < 12; i++)
		 {
			 JLabel teto_campo = new JLabel(teto);
		 	 janela.add(teto_campo);
		 }
		 for (int i = 0; i < 12; i++)
		 {
			 JLabel campo = new JLabel(predio1);
		 	 janela.add(campo);
		 }
		 for (int i = 0; i < 12; i++)
		 {
			 JLabel campo = new JLabel(piso);
		 	 janela.add(campo);
		 }
		 for (int i = 0; i < 12; i++)
		 {
			 JLabel campo = new JLabel(predio2);
		 	 janela.add(campo);
		 }
		 for (int i = 0; i < 12; i++)
		 {
			 JLabel campo = new JLabel(teto);
		 	 janela.add(campo);
		 }
		 for (int i = 0; i < 12; i++)
		 {
			 JComboBox tipo_torre = new JComboBox();
			 tipo_torre.addItem("Vago");
			 tipo_torre.addItem("canhão");
			 tipo_torre.addItem("flecha");
			 janela.add(tipo_torre);
		 }
	}

}
