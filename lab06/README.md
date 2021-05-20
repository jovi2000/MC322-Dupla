# Lab06 - O Mundo de Wumpus
## Arquivos Java do Jogo
* Instruções:
* [Link para os arquivos Java do lab06](https://github.com/jovi2000/MC322-Dupla/tree/main/lab06/src/mc322/lab06)
## Destaques de Arquitetura
### Distribuição de Tarefas e Encapsulamento (Critérios 2 e 4)
~~~java
/* Métodos da classe Caverna */
public int verificarSala(int linha, int coluna, char simbolo) {
    return matriz_caverna[linha][coluna].verificaComponentes(simbolo);
}
public boolean solicitaAdicao(int linha, int coluna, Componentes componente) {
    return matriz_caverna[linha][coluna].adicionaComponente(componente);
}
public void solicitarRemocao(int linha, int coluna, char simbolo) {
    matriz_caverna[linha][coluna].removeComponente(simbolo);
}
~~~
> Nesse trecho são mostrados métodos da classe Caverna. Esses métodos são chamados por Componentes para avisar a Caverna que o Componente deseja verificar, retirar ou adicionar um outro Componente da lista ligada da classe Sala. Os mesmos métodos chamam outros métodos da classe Sala para solicitar que a ação pedida pelo Componente seja realizada, ou seja o Componente solicita uma ação para a Caverna e a Caverna avisa para a Sala a ação que deve ser realizda. A Sala por sua vez irá verificar a ação e realiza-la caso seja válida. Esse trecho, então, mostra a divisão de tarefas e o encapsulamento que o código possui, uma vez que cada classe exerce sua própria função.
### Heroi Senciente
* Neste trecho do código podemos ver que além do próprio herói saber quantas flechas ele passou ele também sabe quais movimentos ele não pode executar além de saber identificar que não há tesouros na sala.
~~~java
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
~~~
