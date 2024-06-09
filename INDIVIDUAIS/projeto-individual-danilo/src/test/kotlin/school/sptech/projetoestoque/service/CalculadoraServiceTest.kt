
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import school.sptech.projetoestoque.dominio.Cliente
import school.sptech.projetoestoque.dominio.Pizza
import school.sptech.projetoestoque.service.CalculadoraService

class CalculadoraServiceTest {

    private val calculadoraService = CalculadoraService()

    @Test
    fun `calcularPrecoVenda deve retornar o preco de compra quando o preco for valido`() {
        val precoCompra = 10.0
        val resultado = calculadoraService.calcularPrecoVenda(precoCompra)
        assertEquals(precoCompra, resultado)
    }

    @Test
    fun `calcularPrecoVendaFinal deve retornar o preco de compra da pizza`() {
        // Criação de mocks simples para Pizza e Cliente
        val pizza = Pizza(preco = 15.0)
        val cliente = Cliente()

        val resultado = calculadoraService.calcularPrecoVendaFinal(pizza, cliente)
        assertEquals(15.0, resultado)
    }
}