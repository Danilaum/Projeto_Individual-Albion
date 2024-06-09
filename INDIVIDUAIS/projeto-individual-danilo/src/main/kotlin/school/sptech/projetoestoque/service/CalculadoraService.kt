package school.sptech.projetoestoque.service

import org.springframework.stereotype.Service
import school.sptech.projetoestoque.dominio.Cliente
import school.sptech.projetoestoque.dominio.Pizza

@Service
class CalculadoraService {

    fun calcularPrecoVenda(precoCompra: Double): Double {
        if (precoCompra < 0.0) {
            throw IllegalArgumentException(
                "Preço de venda deve ser >= 0. Usado: $precoCompra"
            )
        }
        return precoCompra
    }

    fun calcularPrecoVendaFinal(pizza: Pizza, cliente: Cliente): Double {
        return calcularPrecoVenda(pizza.preco!!)
    }
}