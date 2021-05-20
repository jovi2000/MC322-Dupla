# Lab06 - O Mundo de Wumpus
## Arquivos Java do Jogo
* Instruções:
* [Link para os arquivos Java do lab06](https://github.com/jovi2000/MC322-Dupla/tree/main/lab06/src/mc322/lab06)
## Destaques de Arquitetura
### Distribuição de Tarefas e Encapsulamento (Critérios 2 e 4)
~~~java
public class Componentes {
    ...
    public boolean solicitarInclusao() {
        return caverna.solicitaAdicao(linha, coluna, this);
    }
}
~~~
~~~java
public class Caverna {
    ...
    public boolean solicitaAdicao(int linha, int coluna, Componentes componente) {
        return matriz_caverna[linha][coluna].adicionaComponente(componente);
    }
}
~~~
~~~java
/* Método da classe Sala (esse comentário não faz parte do código original) */
public boolean adicionaComponente(Componentes componente) {
    /* Se a sala está disponível para receber o componente, ele é adicionado */
    if (disponibilidadeSala(componente)) {
	lista_sala.add(componente);
	...
	return true;
    }
    else { return false; }
}
~~~
> Nesse primeiro trecho é mostrado um método da classe Componentes. Esse método chama um outro método da classe Caverna (trecho 2) com a função de avisar à Caverna que o Componente deseja ser adicionado em uma certa Sala. A Caverna, então, chama um outro método da classe Sala (trecho 3) para solicitar que a adição requerida pelo Componente seja realizada, ou seja, o Componente solicita uma ação para a Caverna que avisa para a Sala a ação que deve ser realizada. A Sala por sua vez irá verificar se a adição é valida e, se for, irá adicionar o Componente. Com isso, esses trechos mostram a divisão de tarefas e o encapsulamento que o código possui, uma vez que cada classe exerce sua própria função.
### Heroi Senciente
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
> Neste trecho do código podemos ver que o próprio herói sabe: identifica se ele ainda tem flechas, quais movimentos ele não pode executar e identificar se há ou não tesouros na sala.
