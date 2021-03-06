# Lab06 - O Mundo de Wumpus
## Arquivos Java do Jogo
* Como acionar o jogo: Para ver o funcionamento do jogo é necessário baixar um dos arquivos CSV ([Link para os arquivos CSV](https://github.com/jovi2000/MC322-Dupla/tree/main/lab06/data)) e colocar o caminho desse arquivo no argumento do programa. Após isso, o jogo iniciará (veja as instruções de como jogar no tópico "Sobre o jogo")
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
### Heroi Senciente (Critério 3)
~~~java
(...)
    		case "k": //equipa a flecha(...)
    				equipada = true;
    				System.out.print("\nFlecha EQUIPADA ;)");}
    			else System.out.print("\nAcabaram as flechas!!! :(");(...)
    		case "c": // captura o ouro(...)
    				if (caverna.verificarSala(linha, coluna, 'O') != -1)(...)
    					ouro_capturado = true;
						System.out.print("\nOuro adquirido!! ");(...)
private int move(int x, int y)(...)
    	if (linha == 0 && x == -1) System.out.print("\nComando inválido");...
~~~
> Neste trecho do código podemos ver que o próprio herói sabe: identificar se ele ainda tem flechas, se há ou não tesouros na sala e quais movimentos ele não pode executar. Esses aspectos provam que a casse Heroi tem uma independência que a torna senciente.
## Sobre o jogo
* O jogo consiste em explorar as cegas a caverna com movimentos paralelo aos eixos evitando os Buracos e tomando cuidado com o monstro que na caverna habita, tudo isso para achar o ouro e conseguir sair da caverna vivo e rico, para isso o jogador conta com com um poderoso nariz que sente a brisa vinda do buraco que ficará amostra na interface do jogo (representada com a letra “b”) ou sentirá o fedor (representada pela a letra “f”) da criatura nas salas adjacentes ao local onde a criatura está caso o joga queira se aventurar mais e enfrentar o terrível monstro ele terá com sigo uma flecha que ele ira usar na próxima sala que entrar porém acertar a criatura não é garantia de nada, entrar na sala do buraco ou tentar enfrentar o monstro sem ter equipado a flecha é morte na certa ahahahha
		![image](https://user-images.githubusercontent.com/80778627/118917410-33ce4d80-b907-11eb-822b-9468b309d36e.png)
