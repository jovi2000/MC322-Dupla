# Lab06 - O Mundo de Wumpus
## Arquivos Java do Jogo
* Instruções:
* [Link para os arquivos Java do lab06](https://github.com/jovi2000/MC322-Dupla/tree/main/lab06/src/mc322/lab06)
## Destaques de Arquitetura
### Heroi Senciente
* Neste trecho do código podemos ver que além do próprio herói saber quantas flechas ele passou ele também sabe quais movimentos ele não pode executar além de saber identificar que não há tesouros na sala.
'''
...
switch(comando)
    	{
    		case "k": //equipa a flecha
    			if (flecha != 0)
    			{
    				equipada = true;
    				System.out.print("\nFlecha EQUIPADA ;)");
    			}
    			else System.out.print("\nAcabaram as flechas!!! :(");
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
    			if (!captura) System.out.print("\nCade o ouro?!! :( ");
    			break;
    		case "w": // para cima
    			pontos = move(-1,0);
    			break;
...
private int move(int x, int y)
    {
    	int pontos = 0;
    	if (linha == 0 && x == -1) System.out.print("\nComando inválido");
    	else if (linha == 3 && x == 1) System.out.print("\nComando inválido");
    	else if (coluna == 0 && y == -1) System.out.print("\nComando inválido");
    	else if (coluna == 3 && y == 1) System.out.print("\nComando inválido");
		else
'''
