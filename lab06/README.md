# Lab06 - O Mundo de Wumpus
## Arquivos Java do Jogo
* Instruções:
* [Link para os arquivos Java do lab06](https://github.com/jovi2000/MC322-Dupla/tree/main/lab06/src/mc322/lab06)
## Destaques de Arquitetura
### Distribuição de Tarefas e Encapsulamento
~~~java
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
> Nesse trecho são mostrados métodos da classe Caverna. Esses métodos são chamados por Componentes para avisar a Caverna que o Componente deseja verificar, retirar ou adicionar um Componente da lista ligada da classe Sala. Os mesmos métodos chamam outros métodos da classe Sala para solicitar que a ação pedida pelo Componente seja realizada, ou seja o Componente solicita uma ação para a Caverna e a Caverna avisa para a Sala a ação que deve ser realizda. A Sala por sua vez irá verificar a ação e realiza-la caso seja válida.
