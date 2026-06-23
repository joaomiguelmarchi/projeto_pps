object EstoqueRepository {
    private val produtos = mutableMapOf<Int, Produto>()

    fun cadastrar(produto: Produto) {
        produtos[produto.id] = produto
    }

    fun listar(): List<Produto> {
        return produtos.values.sortedBy { it.id }
    }

    fun buscarPorId(id: Int): Produto? {
        return produtos[id]
    }

    fun atualizarQuantidade(id: Int, quantidade: Int): Boolean {
        val produto = produtos[id] ?: return false
        produtos[id] = produto.comQuantidade(quantidade)
        return true
    }

    fun remover(id: Int): Boolean {
        return produtos.remove(id) != null
    }
}
