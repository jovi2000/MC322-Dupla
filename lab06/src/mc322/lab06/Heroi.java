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
    	if (linha == 0 && x == -1) System.out.print("Comando invalido");//n=789;
    	else if (linha == 3 && x == 1) System.out.print("Comando invalido");//n=789;
    	else if (coluna == 0 && y == -1) System.out.print("Comando invalido");//n=789;
    	else if (coluna == 3 && y == 1) System.out.print("Comando invalido");//n=789;
		else
		{
			/* É necessário remover o heroi da sala que ele está */
			for (int i = 0; i < caverna.matriz_caverna[linha][coluna].lista_sala.size(); i++)
			{
				if(caverna.matriz_caverna[linha][coluna].lista_sala.get(i).simbolo == 'P') 
				{
					caverna.matriz_caverna[linha][coluna].lista_sala.remove(i);
					break;
				}
			}
			pontos = -15;
			linha += x;
			coluna += y;
			/* É necessário verificar qual são os componentes da sala que o heroi está chegando */
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
						/* Caso o número sorteado seja 1 o heroi vive e caso seja 0 o heroi morre */
						if (vive != 1) pontos -= 1000;
						else 
						{
							pontos += 500;
							/* Remove o monstro da sala, já que ele foi morto */
							caverna.matriz_caverna[linha][coluna].lista_sala.remove(i);
						}
					}
					else pontos -= 1000;
				}
			}
			if (pontos >= -50) {
				caverna.matriz_caverna[linha][coluna].lista_sala.add(this);
			}
			caverna.matriz_caverna[linha][coluna].visivel = true;
		}
    	return pontos;
    }
    
    public int controleHeroi(String comando)
    {
    	int pontos = 0;
    	switch(comando)
    	{
    		case "k": //equipa a flecha
    			if (flecha != 0)
    			{
    				equipada = true;
    				pontos -= 100;
    				System.out.print("Flecha EQUIPADA ;)");
    			}
    			else System.out.print("Acabaram as flechas!!! :(");//n=789;
    			break;
    		case "c":// captura o ouro
    			boolean captura = false;
    			for (int i = 0; i < caverna.matriz_caverna[linha][coluna].lista_sala.size(); i++)
    			{
    				if(caverna.matriz_caverna[linha][coluna].lista_sala.get(i).simbolo == 'O') 
    				{
    					captura = true;
    					caverna.matriz_caverna[linha][coluna].lista_sala.remove(i);
    					ouro_capturado = true;
    				}
    			}
    			if (!captura) System.out.print("Cade o ouro?!! :( ");//n=789;
    			break;
    		case "w": // para cima
    			pontos = move(-1,0);
    			break;
    		case "s": // para baixo
    			pontos = move(1,0);
    			break;
    		case "a": // para esquerda
    			pontos =move(0,-1);
    			break;
    		case "d": // para direita
    			pontos = move(0,1);
    			break;
    		case "q": // sai da caverna
    			if (ouro_capturado && linha == 0 && coluna == 0) pontos += 1000;
    			else System.out.print("A saida não é aqui");
    			break;
    		default:
    			System.out.print("Comando invalido"); //n=789;
    		
    	}
    	if (equipada)
    	{
    		if (flecha != 0) flecha--;
    		else equipada = false;
    	}
    	return pontos;
    }
}
