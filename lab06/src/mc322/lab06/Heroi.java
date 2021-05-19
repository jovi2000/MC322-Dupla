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
    	if (linha == 0 && x == -1) System.out.print("\nComando inválido");
    	else if (linha == 3 && x == 1) System.out.print("\nComando inválido");
    	else if (coluna == 0 && y == -1) System.out.print("\nComando inválido");
    	else if (coluna == 3 && y == 1) System.out.print("\nComando inválido");
		else
		{
			/* É necessário remover o heroi da sala que ele está */
			caverna.solicitarRemocao(linha, coluna, 'P');
			pontos = -15;
			linha += x;
			coluna += y;
			/* Caso tenha um Wumpus na sala, é necessário saber seu index para poder remover os fedores caso o Wumpus
			 seja derrotado */
			int index_wumpus = caverna.verificarSala(linha, coluna, 'W');
			/* É necessário verificar quais são os componentes da sala que o heroi está chegando */
			if (index_wumpus != -1) {
				if (equipada)
				{
					int vive = random.nextInt(2);
					/* Caso o número sorteado seja 1 o heroi vive e caso seja 0 o heroi morre */
					if (vive != 1) pontos -= 1000;
					else
					{
						pontos += 500;
						/* Remove o monstro da sala, já que ele foi morto */
						caverna.matriz_caverna[linha][coluna].lista_sala.get(index_wumpus).removerFedores();
						caverna.solicitarRemocao(linha, coluna, 'W');
						System.out.print("\nMonstro derrotado!!!");
					}
				}
				else pontos -= 1000;
			}
			/* Caso tenha um buraco na sala, o player morreu */
			else if (caverna.verificarSala(linha, coluna, 'B') != -1) {
				pontos -= 1000;
			}
			/* Adiciona o heroi na sala que ele entrou após o movimento */
			caverna.solicitaAdicao(linha, coluna, this);
		}
		/* A sala onde o heroi entrou fica visível */
		caverna.matriz_caverna[linha][coluna].visivel = true;
    	return pontos;
    }
    
    public int controleHeroi(String comando)
    {
    	int pontos = 0;
    	/* Verificando se a flecha foi utilizada */
		if (equipada) {
			/* A flecha só é usada uma rodada após ser equipada */
			if (!comando.equals("k")) {
				if (flecha != 0) {
					flecha--;
					pontos -= 100;
					System.out.print("\nFlecha usada!");
				} else equipada = false;
			}
		}
		/* Verificando qual comando será realizado */
    	switch(comando)
    	{
    		case "k": //equipa a flecha
    			if (flecha != 0)
    			{
    				equipada = true;
    				System.out.print("\nFlecha EQUIPADA ;)");
    			}
    			else System.out.print("\nAcabaram as flechas!!! :(");//n=789;
    			break;
    		case "c": // captura o ouro
    			boolean captura = false;
    				if (caverna.verificarSala(linha, coluna, 'O') != -1)
    				{
    					captura = true;
    					caverna.solicitarRemocao(linha, coluna, 'O');
    					ouro_capturado = true;
						System.out.print("\nOuro adquirido!! ");
    				}
    			if (!captura) System.out.print("\nCade o ouro?!! :( ");//n=789;
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
    			else System.out.print("\nA saida não é aqui");
    			break;
    		default:
    			System.out.print("\nComando invalido"); //n=789;
    		
    	}
    	return pontos;
    }
}
