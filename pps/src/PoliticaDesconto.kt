interface PoliticaDesconto {
    fun aplicar(produto: Produto): Double
}

class SemDesconto : PoliticaDesconto {
    override fun aplicar(produto: Produto): Double {
        return produto.preco
    }
}

class DescontoPorCategoria(
    private val categoria: Categoria,
    private val percentual: Double
) : PoliticaDesconto {
    override fun aplicar(produto: Produto): Double {
        if (produto.categoria != categoria) {
            return produto.preco
        }

        return produto.preco - (produto.preco * percentual)
    }
}

class CalculadoraPreco(private val politicaDesconto: PoliticaDesconto) {
    fun calcular(produto: Produto): Double {
        return politicaDesconto.aplicar(produto)
    }
}
