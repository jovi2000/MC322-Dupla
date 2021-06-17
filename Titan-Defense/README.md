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

## Componente `<GameView>`

> O GameView tem toda interface gráfica programada nele e recebe todas as ações que o jogador realiza. Após receber as ações realizadas pelo jogador, esse componente envia ações e informações para controller, que com isso pode realizar as modificações necessárias no mapa e no jogo.

![GameView](https://user-images.githubusercontent.com/62356359/122320739-205bd580-cef9-11eb-9ec6-f18d36437156.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | `<João Barreira e Arimã Batista>`
Interfaces | `<IDadosView>`

`<MapaController>`

> O MapaController tem a função de controlar o jogo e as mudanças que ocorrem dentro do mapa. Esse componente recebe as informações do GameView sobre o que o jogador fez e realiza, ou ordena que outro componente realize, as mudanças necessárias no mapa. É importante ressaltar que esse componente possui como atributo a matriz que representa o mapa do jogo.

![MapaController](https://user-images.githubusercontent.com/62356359/122319841-93fce300-cef7-11eb-8cb5-2435100177b3.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | `<João Barreira e Arimã Batista>`
Interfaces | `<IDadosView, IDadosModel e IController>`

`<Model>`

> O Model possui todas as informações, armazenadas em atributos, das Entidades (Torre, Titã e Cidade) e sempre que algum componente precisa de alguma informação do Model, ele é solicitado.

![Model](https://user-images.githubusercontent.com/62356359/122322108-4edab000-cefb-11eb-9410-6c4b09147c6b.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | `<João Barreira e Arimã Batista>`
Interfaces | `<IDadosModel, ITita, ITorre, IAtaque>`

`<Gameplay>`

> O Gameplay possui todos os métodos que representam ações de Torre e de Tita e é dividido em duas classes: TitaGameplay e TorreGameplay. Toda vez que o MapaController deseja realizar alguma alteração em um Model, ele chama o componente Gameplay para efetuar essa mudança e depois devolver o Model atualizado.

![Gameplay](https://user-images.githubusercontent.com/62356359/122322736-551d5c00-cefc-11eb-8ada-e77ab77ef953.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | `<João Barreira e Arimã Batista>`
Interfaces | `< ITita, ITorre, IAtaque>`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface IDataSet extends ITableProducer, IDataSetProperties {
}
~~~

## Detalhamento das Interfaces

### Interface `<nome da interface>`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

## Exemplo:

### Interface `ITableProducer`

Interface provida por qualquer fonte de dados que os forneça na forma de uma tabela.

~~~java
public interface ITableProducer {
  String[] requestAttributes();
  String[][] requestInstances();
}
~~~

Método | Objetivo
-------| --------
`requestAttributes` | Retorna um vetor com o nome de todos os atributos (colunas) da tabela.
`requestInstances` | Retorna uma matriz em que cada linha representa uma instância e cada coluna o valor do respectivo atributo (a ordem dos atributos é a mesma daquela fornecida por `requestAttributes`.

### Interface `IDataSetProperties`

Define o recurso (usualmente o caminho para um arquivo em disco) que é a fonte de dados.

~~~java
public interface IDataSetProperties {
  public String getDataSource();
  public void setDataSource(String dataSource);
}
~~~

Método | Objetivo
-------| --------
`getDataSource` | Retorna o caminho da fonte de dados.
`setDataSource` | Define o caminho da fonte de dados, informado através do parâmetro `dataSource`.

# Plano de Exceções

## Diagrama da hierarquia de exceções

![HierarquiaExceções (1)](https://user-images.githubusercontent.com/62356359/121978251-308b7d80-cd5e-11eb-8459-4e05b7fa63fa.png)

## Descrição das classes de exceção

Classe | Descrição
----- | -----
CompraInvalida | Engloba todas as exceções de compras não aceitas
SaldoNegativo | Indica que o saldo final da compra foi negativo
PosicaoInvalida | Indica que a posição que o player selecionou é inválida
