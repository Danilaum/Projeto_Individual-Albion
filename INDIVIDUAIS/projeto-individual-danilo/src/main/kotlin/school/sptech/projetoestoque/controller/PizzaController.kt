package school.sptech.projetoestoque.controller

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import school.sptech.projetoestoque.dominio.Pizza
import school.sptech.projetoestoque.dto.ProdutoResponse
import school.sptech.projetoestoque.service.PizzaService

@RestController
@RequestMapping("/produtos")
class PizzaController(
    // criando como parâmetros do construtor, não é necessário o uso do @Autowired
    val pizzaService: PizzaService
) {

    @GetMapping("/{id}")
    fun get(@PathVariable id:Int) : ResponseEntity<ProdutoResponse> {
        val dto = pizzaService.get(id)
        return ResponseEntity.status(200).body(dto)
    }

    @PostMapping
    fun criar(@RequestBody @Valid novoProduto: Pizza) :
            ResponseEntity<ProdutoResponse> {
        val salvo = pizzaService.salvar(novoProduto)
        return ResponseEntity.status(201).body(salvo)
    }

    @PutMapping("/{id}")
    fun atualizar(
        @PathVariable id: Int,
        @RequestBody @Valid pizza: Pizza
    ) : ResponseEntity<ProdutoResponse> {
        pizza.id = id
        val salvo = pizzaService.salvar(pizza)
        return ResponseEntity.status(200).body(salvo)
    }

    @GetMapping
    fun listar() : ResponseEntity<List<ProdutoResponse>> {
        val produtos = pizzaService.getLista()
        return ResponseEntity.status(200).body(produtos)
    }


    @GetMapping("/filtro-pizzaria/{pizzariaId}")
    fun buscarPorIdFabricante(@PathVariable pizzariaId: Int):
            ResponseEntity<List<Pizza>> {

        val produtos = pizzaService.getListaPorPizzaria(pizzariaId)
        return ResponseEntity.status(200).body(produtos)
    }

    @GetMapping("/filtro-qtd")
    fun buscarPorIdFabricante(
        @RequestParam qtdMin: Int,
        @RequestParam qtdMax: Int):
            ResponseEntity<List<Pizza>> {

        val produtos = pizzaService.getListaPorQuantidade(qtdMin, qtdMax)
        return ResponseEntity.status(200).body(produtos)
    }
}