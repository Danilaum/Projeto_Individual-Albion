package school.sptech.projetoestoque.dominio

import jakarta.persistence.*

@Entity
data class Pizza (
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var nome: String? = null,
    var qtdEstoque: Int? = null,
    var preco:Double? = null,
    @field:ManyToOne
    var pizzaria: Pizzaria? = null
) {
    constructor(
        paramId: Int,
        paramNome: String
    ):
    this(id = paramId, nome = paramNome)

    constructor(
        paramId: Int,
        paramNome: String,
        paramPizzaria: Pizzaria
    ):
    this(id = paramId, nome = paramNome, pizzaria = paramPizzaria)

    constructor(
        paramId: Int,
        paramNome: String,
        paramQtdEstoque: Int,
        paramPreco: Double
    ):
    this(id = paramId, nome = paramNome,
         qtdEstoque = paramQtdEstoque, preco = paramPreco)

}





