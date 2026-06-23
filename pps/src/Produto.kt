class   Produto private constructor(
    val id: Int,
    val nome: String,
    val categoria: Categoria,
    val tamanho: String,
    val preco: Double,
    val quantidade: Int
) {
    fun comQuantidade(novaQuantidade: Int): Produto {
        return Builder.from(this)
            .quantidade(novaQuantidade)
            .build()
    }

    override fun toString(): String {
        return "ID: $id | $nome | $categoria | Tam: $tamanho | R$ %.2f | Qtd: $quantidade"
            .format(preco)
    }

    class Builder {
        private var id: Int = 0
        private var nome: String = ""
        private var categoria: Categoria = Categoria.CAMISETA
        private var tamanho: String = "M"
        private var preco: Double = 0.0
        private var quantidade: Int = 0

        fun id(id: Int) = apply { this.id = id }
        fun nome(nome: String) = apply { this.nome = nome }
        fun categoria(categoria: Categoria) = apply { this.categoria = categoria }
        fun tamanho(tamanho: String) = apply { this.tamanho = tamanho }
        fun preco(preco: Double) = apply { this.preco = preco }
        fun quantidade(quantidade: Int) = apply { this.quantidade = quantidade }

        fun build(): Produto {
            require(id > 0) { "O id deve ser maior que zero." }
            require(nome.isNotBlank()) { "O nome do produto e obrigatorio." }
            require(preco >= 0.0) { "O preco nao pode ser negativo." }
            require(quantidade >= 0) { "A quantidade nao pode ser negativa." }

            return Produto(id, nome, categoria, tamanho, preco, quantidade)
        }

        companion object {
            fun from(produto: Produto): Builder {
                return Builder()
                    .id(produto.id)
                    .nome(produto.nome)
                    .categoria(produto.categoria)
                    .tamanho(produto.tamanho)
                    .preco(produto.preco)
                    .quantidade(produto.quantidade)
            }
        }
    }
}
