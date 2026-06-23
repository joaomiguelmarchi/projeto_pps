# Design Patterns - Controle de Estoque de Loja de Roupa

## Visao geral do projeto

O projeto desenvolvido e um sistema simples de controle de estoque para uma loja de roupa. A aplicacao cadastra produtos, lista os itens cadastrados, busca produtos por identificador, atualiza a quantidade em estoque, calcula preco com desconto e remove produtos.

O dominio escolhido possui produtos com informacoes como id, nome, categoria, tamanho, preco e quantidade. As categorias utilizadas no exemplo sao camiseta, calca, jaqueta e tenis. A classe `Main` executa um fluxo basico demonstrando o funcionamento do sistema sem necessidade de entrada de dados pelo usuario.

## Padroes utilizados

### Singleton

O padrao Singleton foi aplicado no `EstoqueRepository`. Ele centraliza o armazenamento dos produtos em memoria e garante que exista apenas uma instancia responsavel pelas operacoes de cadastro, listagem, busca, atualizacao e remocao.

A utilizacao desse padrao e adequada porque o estoque deve ser acessado de forma unica pela aplicacao. Assim, todas as partes do sistema consultam e alteram a mesma lista de produtos.

### Builder

O padrao Builder foi aplicado na criacao da classe `Produto`. Em vez de criar produtos por um construtor com muitos parametros soltos, o codigo utiliza `Produto.Builder()` para montar o objeto passo a passo.

Esse padrao melhora a legibilidade e facilita a validacao dos dados obrigatorios, como id maior que zero, nome preenchido, preco nao negativo e quantidade nao negativa.

### Strategy

O padrao Strategy foi aplicado nas politicas de desconto. A interface `PoliticaDesconto` define o comportamento de calculo, enquanto classes como `SemDesconto` e `DescontoPorCategoria` implementam regras diferentes.

Com isso, a classe `CalculadoraPreco` nao precisa conhecer os detalhes de cada desconto. Ela apenas recebe uma estrategia e executa o calculo. Essa escolha facilita a criacao de novas regras de desconto no futuro.

### State

O padrao State foi aplicado no controle da situacao do estoque. A interface `EstadoEstoque` representa o estado atual do produto, e as classes `ProdutoDisponivel`, `ProdutoComBaixoEstoque` e `ProdutoEsgotado` definem comportamentos diferentes.

O `ControleEstadoEstoque` altera o estado de acordo com a quantidade disponivel. Se a quantidade for zero, o produto fica esgotado. Se for menor ou igual a cinco, fica com baixo estoque. Caso contrario, fica disponivel.

## Conclusao

O sistema e simples, mas demonstra a aplicacao pratica dos padroes de projeto dentro de um dominio real. O Singleton organiza o acesso ao estoque, o Builder facilita a criacao de produtos, o Strategy separa as regras de desconto e o State controla a situacao dos produtos conforme a quantidade em estoque.
