fun main() {
    val camiseta = Produto.Builder()
        .id(1)
        .nome("Camiseta Basica")
        .categoria(Categoria.CAMISETA)
        .tamanho("M")
        .preco(59.90)
        .quantidade(20)
        .build()

    val calca = Produto.Builder()
        .id(2)
        .nome("Calca Jeans")
        .categoria(Categoria.CALCA)
        .tamanho("42")
        .preco(149.90)
        .quantidade(8)
        .build()

    val tenis = Produto.Builder()
        .id(3)
        .nome("Tenis Casual")
        .categoria(Categoria.TENIS)
        .tamanho("40")
        .preco(219.90)
        .quantidade(5)
        .build()

    EstoqueRepository.cadastrar(camiseta)
    EstoqueRepository.cadastrar(calca)
    EstoqueRepository.cadastrar(tenis)

    println("=== Produtos cadastrados ===")
    EstoqueRepository.listar().forEach(::println)

    println("\n=== Atualizacao de estoque ===")
    EstoqueRepository.atualizarQuantidade(2, 12)
    println(EstoqueRepository.buscarPorId(2))

    println("\n=== Preco com desconto ===")
    val descontoCamiseta = CalculadoraPreco(DescontoPorCategoria(Categoria.CAMISETA, 0.10))
    EstoqueRepository.listar().forEach { produto ->
        val precoFinal = descontoCamiseta.calcular(produto)
        println("${produto.nome}: R$ %.2f".format(precoFinal))
    }

    println("\n=== Estado do estoque ===")
    val controleEstado = ControleEstadoEstoque()
    EstoqueRepository.atualizarQuantidade(3, 0)
    EstoqueRepository.listar().forEach { produto ->
        println(controleEstado.mostrarSituacao(produto))
    }

    println("\n=== Remocao ===")
    EstoqueRepository.remover(3)
    EstoqueRepository.listar().forEach(::println)
}
