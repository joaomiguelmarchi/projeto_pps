class ControleEstadoEstoque {
    private var estado: EstadoEstoque = ProdutoEsgotado()

    fun atualizar(produto: Produto) {
        estado = when {
            produto.quantidade == 0 -> ProdutoEsgotado()
            produto.quantidade <= 5 -> ProdutoComBaixoEstoque()
            else -> ProdutoDisponivel()
        }
    }

    fun mostrarSituacao(produto: Produto): String {
        atualizar(produto)
        val venda = if (estado.podeVender()) "pode vender" else "nao pode vender"
        return "${produto.nome}: ${estado.descricao()} - $venda"
    }
}
