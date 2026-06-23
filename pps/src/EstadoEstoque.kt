interface EstadoEstoque {
    fun descricao(): String
    fun podeVender(): Boolean
}

class ProdutoDisponivel : EstadoEstoque {
    override fun descricao(): String {
        return "Disponivel"
    }

    override fun podeVender(): Boolean {
        return true
    }
}

class ProdutoComBaixoEstoque : EstadoEstoque {
    override fun descricao(): String {
        return "Baixo estoque"
    }

    override fun podeVender(): Boolean {
        return true
    }
}

class ProdutoEsgotado : EstadoEstoque {
    override fun descricao(): String {
        return "Esgotado"
    }

    override fun podeVender(): Boolean {
        return false
    }
}
