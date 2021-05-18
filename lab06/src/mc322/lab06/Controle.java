package mc322.lab06;

import java.util.Scanner;

public class Controle {
    /* Atributo */
    Componentes heroi;
    String player;
    boolean game_over;
    Scanner keyboard;
    int score; /* 1000 sai da caverna com ouro, -1000 herói morto; -15 para cada movimento na caverna;-100 usar flecha;
    +500 matar o Wumpus */

	/* Métodos */
    Controle(Componentes heroi)
    {
    	this.heroi = heroi;
    	game_over = false;
    	keyboard = new Scanner(System.in);
    	score = 0;
    }

    boolean jogo()
    {
    	/* Adquirindo o nome do jogador */
    	System.out.print("Nome do novo Jogador: ");
		player = keyboard.nextLine();

    	while (!game_over)
    	{
    		heroi.caverna.exibirCaverna();
    		System.out.print("\nPlayer: " + player + "\nScore: " + score + "\n");
			System.out.print("Digite sua ação: ");
    		String  comando = keyboard.nextLine();
    		int n = heroi.controleHeroi(comando); 
    		score += n;
    		/*if (n != 789)score += n;
    		else System.out.print("Comando invalido"); */
    		if (n <= -1000) 
    		{
    			heroi.caverna.exibirCaverna();
				System.out.print("\nPlayer: " + player + "\nScore: " + score + "\n");
				System.out.print("Voce perdeu =(");
    			game_over = true;
    		}
    		else if (n == 1000) 
    		{
    			heroi.caverna.exibirCaverna();
    			System.out.print("\nPlayer: " + player + "\nScore: " + score + "\n");
    			System.out.print("Voce ganhou =D");
    			game_over = true;
    		}
    		
    	}
    	System.out.println("\n\nDeseja jogar Novamente?\nDigite 'sim' ou 'nao'");
		String  novamente = keyboard.nextLine();
		String sim = "sim";
    	if (novamente.equals(sim))	
    	{
    		return true;
    	}
    	else
    	{
    		System.out.println("\nVolte Sempre!!");
    		return false;
    	}    	
    }	
}
