package school.sptech.projetoestoque.service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.springframework.web.server.ResponseStatusException
import school.sptech.projetoestoque.dominio.Pizza
import school.sptech.projetoestoque.repository.PizzariaRepository
import school.sptech.projetoestoque.repository.PizzaRepository
import java.util.*

class PizzaServiceTest {

    lateinit var pizzaRepository: PizzaRepository
    lateinit var pizzariaRepository: PizzariaRepository
    lateinit var service: PizzaService

    @BeforeEach
    fun iniciar() {
        pizzaRepository = mock(PizzaRepository::class.java)
        pizzariaRepository = mock(PizzariaRepository::class.java)
        service = PizzaService(pizzaRepository, pizzariaRepository)
    }
    @DisplayName(
    "Se a tabela estiver vazia, deve lançar uma exceção")
    @Test
    fun getListaVazia() {
        `when`(pizzaRepository.findAll()).thenReturn(listOf())

        val excecao = assertThrows(ResponseStatusException::class.java) {
            service.getLista()
        }

        assertEquals(204, excecao.statusCode.value())
    }
}
