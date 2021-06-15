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

![Arquitetura melhorada](https://user-images.githubusercontent.com/62356359/121977754-18ffc500-cd5d-11eb-8395-30bab8494918.png)

> <Faça uma breve descrição do diagrama.>

## Diagrama Geral de Componentes

### Exemplo 1

Este é o diagrama compondo componentes para análise:

![Diagrama Analise](diagrama-componentes-analise.png)

### Exemplo 2

Este é um diagrama inicial do projeto de jogos:

![Diagrama Jogos](diagrama-componentes-jogos.png)

### Exemplo 3

Este é outro diagrama de um projeto de vendas:

![Diagrama Vendas](diagrama-componentes-vendas.png)

Para cada componente será apresentado um documento conforme o modelo a seguir:

## Componente `<Nome do Componente>`

> <Resumo do papel do componente e serviços que ele oferece.>

![Componente](diagrama-componente.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | `<nome dos membros que criaram o componente>`
Interfaces | `<listagem das interfaces do componente>`

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
