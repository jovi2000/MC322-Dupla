package mc322.lab06;

import java.util.Scanner;

public class Controle {
    /* Atributo */
    Heroi heroi;
    String player;
    boolean game_over;
    Scanner keyboard;
    int score; /* 1000 sai da caverna com ouro, -1000 herói morto; -15 para cada movimento na caverna;-100 usar flecha;
    +500 matar o Wumpus */

	/* Métodos */
    Controle(Heroi heroi)
    {
    	this.heroi = heroi;
    	game_over = false;
    	keyboard = new Scanner(System.in);
    	score = 0;
    }

    boolean jogo()
    {
    	/* Adquirindo o nome do jogador */
    	System.out.print("Nome do novo Jogador");
		player = keyboard.nextLine();

    	while (!game_over)
    	{
    		heroi.caverna.exibirCaverna();
    		System.out.print("\n\nPlayer: " + player + "\n\nScore: " + score + "\n");
    		String  comando = keyboard.nextLine();
    		/*int n = heroi.controleHeroi(comando); //Não sei como chama o heroi****************
    		score += n;
    		if (n == 0) System.out.print("COMANDO INVALIDO");
    		if (n <= -1000) 
    		{
			caverna.exibirCaverna();
			System.out.print("\n\nPlayer: " + player + "\n\nScore: " + score + "\n");
			System.out.print("Voce perdeu =(");
    			game_over = true:
		}
    		if (n == 1000) 
    		{
			caverna.exibirCaverna();
			System.out.print("\n\nPlayer: " + player + "\n\nScore: " + score + "\n");
			System.out.print("Voce ganhou =D");
    			game_over = true:
		}
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
