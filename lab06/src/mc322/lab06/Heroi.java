package mc322.lab06;
import java.util.Random;

public class Heroi extends Componentes {
    /* Atributos */
    private int flecha;
    private boolean equipada; // Indica se a flecha está equipada ou não
    private boolean ouro_capturado;
    Random random;
    

    public Heroi(int linha, int coluna, char simbolo, Caverna caverna) {
        super(linha, coluna, simbolo, caverna);
    	this.flecha = 1;
    	this.equipada = false;
    	ouro_capturado = false;
    	random = new Random();
    }
    
    private int move(int x, int y)
    {
    	int pontos = 0;
    	if (linha == 0 && x ==-1) System.out.print("comando invalido");
    	else if (linha == 3 && x ==1) System.out.print("comando invalido");
    	else if (coluna == 0 && y ==-1) System.out.print("comando invalido");
    	else if (coluna == 3 && y ==1) System.out.print("comando invalido");
		else
		{
			for (int i = 0; i < caverna.matriz_caverna[linha][coluna].lista_sala.size(); i++)
			{
				if(caverna.matriz_caverna[linha][coluna].lista_sala.get(i).simbolo == 'P') 
				{
					caverna.matriz_caverna[linha][coluna].lista_sala.remove(i);
				}
			}
			pontos = -15;
			linha += x;
			coluna += y;
			for (int i = 0; i < caverna.matriz_caverna[linha][coluna].lista_sala.size(); i++)
			{
				if(caverna.matriz_caverna[linha][coluna].lista_sala.get(i).simbolo == 'B') 
				{
					pontos -= 1000;
				}
				if(caverna.matriz_caverna[linha][coluna].lista_sala.get(i).simbolo == 'W')
				{
					if(equipada)
					{
						int vive = random.nextInt(2);
						if (vive != 1) pontos -= 1000;
						else 
						{
							pontos += 500;
							caverna.matriz_caverna[linha][coluna].lista_sala.remove(i);
						}
					}
					else pontos -= 1000;
				}
			}
			///if (pontos >= -50) caverna.matriz_caverna[linha][coluna].lista_sala.add(Heroi);//n sei como adivi
			caverna.matriz_caverna[linha][coluna].visivel = true;
		}
    	return pontos;
    }
    
    public int controleHeroi(String comando)
    {
    	int pontos = 0;
    	switch(comando)
    	{
    		case "k"://equipa flecha
    			if (flecha != 0)
    			{
    				equipada = true;
    				pontos -= 100;
    				System.out.print("Flecha EQUIPADA ;)");
    			}
    			else System.out.print("Acabaram as flechas!!! :(");
    			break;
    		case "c":// captura ouro
    			boolean captura = false;
    			for (int i = 0; i < caverna.matriz_caverna[linha][coluna].lista_sala.size(); i++)
    			{
    				if(caverna.matriz_caverna[linha][coluna].lista_sala.get(i).simbolo == 'O') 
    				{
    					captura = true;
    					caverna.matriz_caverna[linha][coluna].lista_sala.remove(i);
    					pontos = 1000;
    					ouro_capturado = true;
    				}
    			}
    			if (!captura) System.out.print("Cade o ouro?!! :( ");
    			break;
    		case "w":// p/ cima
    			pontos = move(-1,0);
    			break;
    		case "s":// p/ baixo
    			pontos = move(1,0);
    			break;
    		case "a":// p/ esquerda
    			pontos =move(0,-1);
    			break;
    		case "d":// p/ direita 
    			pontos = move(0,1);
    			break;
    		case "q":// sai caverna 
    			if (ouro_capturado && linha ==0 && coluna ==0) pontos += 789;
    			
    		
    	}
    	if (equipada)
    	{
    		if (flecha != 0) flecha--;
    		else equipada = false;
    	}
    	return pontos;
    }
}
