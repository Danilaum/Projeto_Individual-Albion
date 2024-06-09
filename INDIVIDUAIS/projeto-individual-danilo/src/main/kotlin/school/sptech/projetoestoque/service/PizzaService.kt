package school.sptech.projetoestoque.service

import org.modelmapper.ModelMapper
import org.modelmapper.TypeToken
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import school.sptech.projetoestoque.dominio.Pizza
import school.sptech.projetoestoque.dto.ProdutoResponse
import school.sptech.projetoestoque.repository.PizzaRepository
import school.sptech.projetoestoque.repository.PizzariaRepository

@Service
class PizzaService(
    val pizzaRepository: PizzaRepository,
    val pizzariaRepository: PizzariaRepository,
    val mapper: ModelMapper = ModelMapper()
) {

    fun validarLista(lista:List<*>) {
        if (lista.isEmpty()) {
            throw ResponseStatusException(HttpStatusCode.valueOf(204))
        }
    }

    fun validarIdProduto(id:Int) {
        if (!pizzaRepository.existsById(id)) {
            throw ResponseStatusException(HttpStatusCode.valueOf(404))
        }
    }

    fun salvar(produto:Pizza): ProdutoResponse {
        if (!pizzariaRepository.existsById(produto.pizzaria!!.id)) {
            throw ResponseStatusException(
                HttpStatusCode.valueOf(404))
        }

        val salvo = pizzaRepository.save(produto)

        val dto = mapper.map(salvo, ProdutoResponse::class.java)

        return dto
    }

    fun get(id:Int):ProdutoResponse {
        validarIdProduto(id)

        val pizza = pizzaRepository.findById(id).get()

        val dto = mapper.map(
            pizza,
            ProdutoResponse::class.java
        )
        return dto
    }

    fun getLista():List<ProdutoResponse> {
        val lista = pizzaRepository.findAll()
        validarLista(lista)

        val listaDtos: List<ProdutoResponse> = mapper.map(
            lista,
            object : TypeToken<List<ProdutoResponse>>() {}.type
        )

        return listaDtos
    }

    fun getListaPorPizzaria(idFabricante:Int):List<Pizza> {
        val lista = pizzaRepository.findByPizzariaId(idFabricante)
        validarLista(lista)

        return lista
    }

    fun getListaPorQuantidade(qtdMin: Int,
                              qtdMax: Int):List<Pizza> {
        val lista = pizzaRepository.findByQtdEstoqueBetween(qtdMin, qtdMax)
        validarLista(lista)
        return lista
    }


}