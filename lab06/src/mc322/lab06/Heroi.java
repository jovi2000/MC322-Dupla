package mc322.lab06;
import java.util.Random;

public class Heroi extends Componentes {
    /* Atributos */
    private int flecha;
    private boolean equipada; // Indica se a flecha está equipada ou não
    private int x,y;
    private boolean ouro_capturado;
    Random random = new Random();
    

    public Heroi(int linha, int coluna, char simbolo, Caverna caverna) {
        super(linha, coluna, simbolo, caverna);
    	this.flecha = 1;
    	this.equipada = false;
    	ouro_capturado = false;
    	x=1;
    	y=1;
    }
    
    int controleHeroi(String comando)
    {
    	int pontos = 0;
    	switch(comando)
    	{
    		case "k"://equipa flecha
    			if (flecha != 0)
    			{
    				equipada = true;
    				pontos -= 100;
    			}
    			else System.out.print("Acabaram as flechas!!! :(");
    		case "c":// captura ouro
    			//caverna.matriz_caverna[x][y].lista_sala
    			boolean captura = false;
    			for (int i = 0; i < caverna.matriz_caverna[x][y].lista_sala.size(); i++)
    			{
    				if(caverna.matriz_caverna[x][y].lista_sala.get(i).simbolo == 'O') 
    				{
    					captura = true;
    					caverna.matriz_caverna[x][y].lista_sala.remove('O');
    					pontos = 1000;
    					ouro_capturado = true;
    				}
    			}
    			if (captura == false) System.out.print("Kade o ouro?!! :(");
    		case "w":// p/ cima
    			if (y == 1) System.out.print("comando invalido");
    			else
    			{
    				caverna.matriz_caverna[x][y].lista_sala.remove('P');
        			pontos = -15;
    				y--;
    				for (int i = 0; i < caverna.matriz_caverna[x][y].lista_sala.size(); i++)
    				{
    					if(caverna.matriz_caverna[x][y].lista_sala.get(i).simbolo == 'B') 
    					{
    						pontos -= 1000;
    					}
    					if(caverna.matriz_caverna[x][y].lista_sala.get(i).simbolo == 'W')
    					{
    						if(equipada == true)
    						{
    							int vive = random.nextInt(1);
    							if (vive != 1) pontos -= 1000;
    							else pontos += 500;
    						}
    						else pontos -= 1000;
    					}
    				}
    			}
    		case "d":// p/ baixo
    			if (y == 4) System.out.print("comando invalido");
    			else
    			{
    				caverna.matriz_caverna[x][y].lista_sala.remove('P');
        			pontos = -15;
    				y++;
    				for (int i = 0; i < caverna.matriz_caverna[x][y].lista_sala.size(); i++)
    				{
    					if(caverna.matriz_caverna[x][y].lista_sala.get(i).simbolo == 'B') 
    					{
    						pontos -= 1000;
    					}
    					if(caverna.matriz_caverna[x][y].lista_sala.get(i).simbolo == 'W')
    					{
    						if(equipada == true)
    						{
    							int vive = random.nextInt(1);
    							if (vive != 1) pontos -= 1000;
    							else pontos += 500;
    						}
    						else pontos -= 1000;
    					}
    				}
    			}
    		case "a":// p/ esquerda
    			if (x == 1) System.out.print("comando invalido");
    			else
    			{
    				caverna.matriz_caverna[x][y].lista_sala.remove('P');
        			pontos = -15;
    				x--;
    				for (int i = 0; i < caverna.matriz_caverna[x][y].lista_sala.size(); i++)
    				{
    					if(caverna.matriz_caverna[x][y].lista_sala.get(i).simbolo == 'B') 
    					{
    						pontos -= 1000;
    					}
    					if(caverna.matriz_caverna[x][y].lista_sala.get(i).simbolo == 'W')
    					{
    						if(equipada == true)
    						{
    							int vive = random.nextInt(1);
    							if (vive != 1) pontos -= 1000;
    							else pontos += 500;
    						}
    						else pontos -= 1000;
    					}
    				}
    			}
    		case "s":// p/ direita 
    			if (x == 4) System.out.print("comando invalido");
    			else
    			{
    				caverna.matriz_caverna[x][y].lista_sala.remove('P');
        			pontos = -15;
    				x++;
    				for (int i = 0; i < caverna.matriz_caverna[x][y].lista_sala.size(); i++)
    				{
    					if(caverna.matriz_caverna[x][y].lista_sala.get(i).simbolo == 'B') 
    					{
    						pontos -= 1000;
    					}
    					if(caverna.matriz_caverna[x][y].lista_sala.get(i).simbolo == 'W')
    					{
    						if(equipada == true)
    						{
    							int vive = random.nextInt(1);
    							if (vive != 1) pontos -= 1000;
    							else pontos += 500;
    						}
    						else pontos -= 1000;
    					}
    				}
    			}
    		case "q":// sai caverna 
    			if (ouro_capturado == true && x ==1 && y==1) pontos += 789;
    			
    		
    	}
    	if (equipada == true)
    	{
    		if (flecha != 0) flecha--;
    		else equipada = false;
    	}
    	return pontos;
    }
}
