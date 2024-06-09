package school.sptech.projetoestoque.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import school.sptech.projetoestoque.dominio.Pizza

interface PizzaRepository : JpaRepository<Pizza, Int> {
    @Query("SELECT new Pizza(p.id, p.nome, p.pizzaria) FROM Pizza p")
    fun findSimples(): List<Pizza>

    fun findByPizzariaId(id: Int) : List<Pizza>

    @Query("SELECT p FROM Pizza p WHERE p.pizzaria.id = :id")
    fun buscaPorPizzariaId(id: Int) : List<Pizza>


    fun findByQtdEstoqueBetween(qtdMin: Int, qtdMax: Int): List<Pizza>

    @Query("SELECT p FROM Pizza p WHERE p.qtdEstoque >= :qtdMin AND p.qtdEstoque <= :qtdMax")
    fun buscaEntreDuasQuantidades(qtdMin: Int, qtdMax: Int)

}