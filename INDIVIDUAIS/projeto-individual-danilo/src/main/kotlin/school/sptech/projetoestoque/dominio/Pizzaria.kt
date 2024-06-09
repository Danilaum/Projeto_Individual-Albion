package school.sptech.projetoestoque.dominio

import jakarta.persistence.*
import jakarta.validation.constraints.Size

@Entity
data class Pizzaria (
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    @field:Size(min = 3)
    var nome: String?,

    @field:OneToMany(mappedBy = "pizzaria")
    var pizza: List<Pizza>? = null
)

