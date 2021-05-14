package mc322.lab06;

import java.util.Scanner;

public class Controle {
    /* Atributo */
    Heroi heroi;
    Caverna caverna;
    String player;
    boolean game_over;
    Scanner keyboard = new Scanner(System.in);
    int score;//+1000 sai d caverna c ouro, -1000 herói morto;
    //-15 p cada movimento na caverna;-100 usar flecha;+500 matar o Wumpus
    Controle(Caverna caverna)
    {
    	this.caverna = caverna;
    	game_over = false;
    	score = 0;
    }
    boolean jogo()
    {
    	System.out.print("Nome do novo Jogador");
    	String  nome = keyboard.nextLine();
    	player = nome;
    	while (game_over == false)
    	{
    		caverna.mostra();// mostra pra printata a caverna não prograsmado
    		System.out.print("\n\nPlayer: " + player + "\n\nScore: " + score + "\n");
    		String  comando = keyboard.nextLine();
    		/*int n = ????.controle_heroi(comando); //Não sei como chama o heroi****************
    		score += n;
    		if (n == 0) System.out.print("COMANDO INVALIDO");
    		if (n <= -1000) 
    		{System.out.print("Voce presdeu =(");
    		game_over = true:}
    		if (n == 1000) 
    		{System.out.print("Voce ganhou =D");
    		game_over = true:}
    		*/
    	}
    	System.out.print("Deseja jogar Novamente?\nDigite 'sim' ou 'nao'");
		String  novamente = keyboard.nextLine();
    	if (novamente == "sim")	return true;
    	else
    	{
    		System.out.print("Volte Sempre!!");
    		return false;
    	}    	
    }	
}
