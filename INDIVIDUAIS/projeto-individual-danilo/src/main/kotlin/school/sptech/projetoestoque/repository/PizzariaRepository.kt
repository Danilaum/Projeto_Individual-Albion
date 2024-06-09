package school.sptech.projetoestoque.repository

import org.springframework.data.jpa.repository.JpaRepository
import school.sptech.projetoestoque.dominio.Pizzaria

interface PizzariaRepository : JpaRepository<Pizzaria, Int> {
}