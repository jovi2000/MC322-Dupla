# Titan Defense

# Descrição Resumida do Projeto/Jogo

## Jogo e objetivo o jogador
> Titan Defense é um jogo estilo Tower Defense que funciona dentro de um espaço celular. O objetivo do jogador é defender a cidade, que fica no final do mapa, de criaturas hostis chamadas de "titãs".

## Mapa 
![Mapa](https://user-images.githubusercontent.com/62356359/122069573-ada10c00-cdcb-11eb-9dd0-f72c8c36f20e.png)

## Torres e Titãs
>* Torres: são construídas pelo jogador, atacam os titãs para impedi-los de chegarem na cidade e tem dois tipos (torre de flechas e torre canhão) com diferentes características, além disso elas podem ser evoluídas pelo jogador para que causem mais dano.
>* Titãs: são inimigos com objetivo de chegar na cidade para causar dano, andam em linha reta e possuem diferentes tipos. Cada tipo de titã possui sua própria característica que influencia no dano ou na movimentação.

## Cidade
> A cidade fica no final do Mapa e a missão do jogador é proteger ela. Sempre que um titã consegue passar por todas as defesas e chegar vivo na cidade, ela perde uma certa quantidade de vida. Se a vida da cidade acabar, o jogador perde o jogo.

## Fases e sistema de dinheiro
> * Fases: o jogo possui 5 fases e cada fase possui um certo número e tipo de titãs. Antes do começo de cada fase o jogador tem a "fase de preparação" que consiste em um certo tempo para o jogador montar e evoluir suas defesas, nesse periodo não serão gerados titãs. Depois de todos os titãs da fase serem derrotados uma nova fase irá se iniciar.
> * Dinheiro: o jogo também possui um sistema de dinheiro para controlar a compra e a evolução de torres. Sempre que jogador passar de fase ou derrotar um titã ele será recompensado com uma certa quantidade de dinheiro. Esse dinheiro recebido poderá ser usado em toda "fase de preparação" com o intuito de melhorar as defesas.

# Equipe
* `<João Vitor Viégas Barreira>` - `<175116>`
* `<Arimã da Silva Alves Batista>` - `<194347>`

# Vídeos do Projeto

## Vídeo da Prévia
> <https://drive.google.com/file/d/1E2VLxWiYAv0nPFHnypNZxOuoz48CBGjd/view>

# Slides do Projeto

## Slides da Prévia

> <https://drive.google.com/file/d/1OOp8SSEmv9yHHQGiwm8wtko_4qYf-cZQ/view>

# Documentação dos Componentes

# Diagramas

## Diagrama Geral do Projeto

![Arquitetura melhorada (1)](https://user-images.githubusercontent.com/62356359/122250441-0b9f2380-cea0-11eb-92b0-8577cf436099.png)

> * GameView: componente que possui a main, a interface gráfica e que recebe o que é feito pelo jogador. Sempre que o jogador realiza uma nova ação o GameView avisa ao controller.
> * MapaController: componente que possui a maior parte das funções do jogo e que realiza ou manda outro componente realizar as ações. O controller possui um ponteiro para o Gameplay e possui como atributo a matriz que representa o mapa do jogo, ou seja, possui o ponteiro de todos os Models que estão no mapa
> * Gameplay: componente que possui duas classes e cada uma delas tem as ações (métodos) de cada Entidade (torre e titã). Sempre que o controller deseja realizar uma mudança em um Model ele avisa ao Gameplay, que realiza a mudança e devolve o valor atualizado.
> * Model: componente que possui o modelo de cada Entidade. Os Models não possuem métodos mas guardam todas as informações do Model (em atributos) e sempre que eles precisam ser atualizados, o Gameplay realiza isso.

## Diagrama Geral de Componentes

![Componentes - Arquitetura](https://user-images.githubusercontent.com/62356359/122320629-e7bbfc00-cef8-11eb-9731-fe7b140197c4.png)

## Componente `GameView`

> O GameView tem toda interface gráfica programada nele e recebe todas as ações que o jogador realiza. Após receber as ações realizadas pelo jogador, esse componente envia ações e informações para controller, que com isso pode realizar as modificações necessárias no mapa e no jogo.

![GameView](https://user-images.githubusercontent.com/62356359/122320739-205bd580-cef9-11eb-9ec6-f18d36437156.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `view.GameView`
Autores | `João Barreira e Arimã Batista`
Interfaces | `IDadosView`

## `MapaController`

> O MapaController tem a função de controlar o jogo e as mudanças que ocorrem dentro do mapa. Esse componente recebe as informações do GameView sobre o que o jogador fez e realiza, ou ordena que outro componente realize, as mudanças necessárias no mapa. É importante ressaltar que esse componente possui como atributo a matriz que representa o mapa do jogo.

![MapaController](https://user-images.githubusercontent.com/62356359/122319841-93fce300-cef7-11eb-8cb5-2435100177b3.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `controller.MapaController`
Autores | `João Barreira e Arimã Batista`
Interfaces | `IDadosView, IDadosModel e IController`

## `Model`

> O Model possui todas as informações, armazenadas em atributos, das Entidades (Torre, Titã e Cidade) e sempre que algum componente precisa de alguma informação do Model, ele é solicitado.

![Model](https://user-images.githubusercontent.com/62356359/122322108-4edab000-cefb-11eb-9410-6c4b09147c6b.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `model.Entidade (O componente chama Model mas a super classe que possui todos os models chama Entidade)`
Autores | `João Barreira e Arimã Batista`
Interfaces | `IDadosModel, ITita, ITorre, IAtaque`

## `Gameplay`

> O Gameplay possui todos os métodos que representam ações de Torre e de Tita e é dividido em duas classes: TitaGameplay e TorreGameplay. Toda vez que o MapaController deseja realizar alguma alteração em um Model, ele chama o componente Gameplay para efetuar essa mudança e depois devolver o Model atualizado.

![Gameplay](https://user-images.githubusercontent.com/62356359/122322736-551d5c00-cefc-11eb-8ada-e77ab77ef953.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `package gameplay (Esse componente é composto por duas classes que ficam no pacote gameplay)`
Interfaces | `ITita, ITorre, IAtaque`

## Detalhamento das Interfaces

### Interface `IDadosView`

Interface provida pelo componente GameView para fornecer dados desse componente para métodos do MapaController que os usam

~~~java
public interface IDadosModel {
    public void movimentarTita(TitaModel tita);
    public void retirarTitaDoMapa(TitaModel tita);
    public void atacarAlvos(TorreModel torre, LinkedList<Entidade> alvos);
}
~~~

Método | Objetivo
-------| --------
`ContruirTorre` | `Cria uma nova torre no mapa dependendo do tipo dela. Tanto a posição da torre no mapa (linha e coluna) quanto o tipo fazem parte do parametro e são fornecidos pelo GameView`
`evoluirTorre` | `Evolui o nível de uma torre ja presente no mapa. A posição da torre no mapa faz parte do parametro e é fornecida pelo GameView`

### `IDadosModel`

Interface provida pelo componente Model para fornecer dados desse componente para métodos do MapaController que os usam

~~~java
public interface IDadosModel {
    public void movimentarTita(TitaModel tita);
    public void retirarTitaDoMapa(TitaModel tita);
    public void atacarAlvos(TorreModel torre, LinkedList<Entidade> alvos);
}
~~~

Método | Objetivo
-------| --------
`movimentarTita` | `Muda a posição do titã dentro da matriz que representa o mapa. O parametro é um TitaModel que faz parte do componente Model`
`retirarTitaDoMapa` | `Apaga o titã que esta dentro da matriz que representa o mapa. O parametro é um TitaModel que faz parte do componente Model`
`atacarAlvos` | `Chama a função do componente Gameplay que ordena a torre, que está no parametro, atacar os alvos presentes na lista ligada(parametro)`

### `ITita`

Interface provida pelo componente Model para fornecer dados do TitaModel para métodos do Gameplay que os usam

~~~java
public interface ITita {
    public boolean verificarMovimento(TitaModel tita, Entidade[][] mapa);
    public void movimentar(TitaModel tita);
    public boolean verificarMorte(TitaModel tita);
}
~~~

Método | Objetivo
-------| --------
`verificarMovimento` | `Verfica se o movimento que o titã irá realizar é valido. O parametro é um TitaModel que faz parte do componente Model e o outro um mapa, fornecido pelo controller`
`movimentar` | `Muda o atributo coluna do Titã, após o movimento ser realizado. O parametro é um TitaModel que faz parte do componente Model.`
`verificarMorte` | `Verifica o atributo vida do Titã para ver se ele está morto`

### `ITorre`

Interface provida pelo componente Model para fornecer dados do TorreModel para métodos do Gameplay que os usam

~~~java
public interface ITorre {
    public void evoluir(TorreModel torre);
    public LinkedList<Entidade> procurarAlvos(TorreModel torre, Entidade[][] mapa);
    public LinkedList<Entidade> procurarAlvosFlecha(TorreModel torre, Entidade[][] mapa);
    public LinkedList<Entidade> procurarAlvosCanhao(TorreModel torre, Entidade[][] mapa);
}
~~~

Método | Objetivo
-------| --------
`evoluir` | `Melhora os atributos da TorreModel passsada como parametro`
`procurarAlvos` | `Verifica pelo mapa (parametro) qual os alvos que a torre (parametro) pode atacar e retorna esse(s) alvo(s) em uma de lista ligada`
`procurarAlvosFlecha` | `Verifica pelo mapa (parametro) qual o alvo que a TorreDeFlechas (parametro) pode atacar e retorna esse alvo em uma de lista ligada`
`procurarAlvosCanhao` | `Verifica pelo mapa (parametro) quais os alvos que a TorreCanhao (parametro) pode atacar e retorna esses alvos em uma de lista ligada`

### `IAtaque`

Interface provida pelo componente Model para fornecer dados das Entidades para métodos com função de ataque do Gameplay que os usam

~~~java
public interface IAtaque {
    public void atacar(Entidade atacante, Entidade vitima);
}
~~~

Método | Objetivo
-------| --------
`atacar` | `A vida da vitima (parametro) é subtraida pelo dano do atacante (parametro)`

# Plano de Exceções

## Diagrama da hierarquia de exceções

![HierarquiaExceções (1)](https://user-images.githubusercontent.com/62356359/121978251-308b7d80-cd5e-11eb-8459-4e05b7fa63fa.png)

## Descrição das classes de exceção

Classe | Descrição
----- | -----
CompraInvalida | Engloba todas as exceções de compras não aceitas
SaldoNegativo | Indica que o saldo final da compra foi negativo
PosicaoInvalida | Indica que a posição que o player selecionou é inválida
