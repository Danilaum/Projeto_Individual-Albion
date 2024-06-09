package school.sptech.projetoestoque.controller

import jakarta.validation.Valid
import org.modelmapper.ModelMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import school.sptech.projetoestoque.dominio.Pizzaria
import school.sptech.projetoestoque.dto.PizzariaResponse
import school.sptech.projetoestoque.repository.PizzariaRepository

@RestController
@RequestMapping("/pizzarias")
class PizzariaController(
    val pizzariaRepository: PizzariaRepository,
    val mapper: ModelMapper = ModelMapper()
) {

    @PostMapping
    fun criar(@RequestBody @Valid novoFabricante: Pizzaria) :
            ResponseEntity<Pizzaria> {

        val pizzariaSalvo = pizzariaRepository.save(novoFabricante)
        return ResponseEntity.status(201).body(pizzariaSalvo)
    }

    @GetMapping
    fun listar(): ResponseEntity<List<PizzariaResponse>> {
        val pizzaria = pizzariaRepository.findAll()

        if(pizzaria.isEmpty()) {
            return ResponseEntity.status(204).build()
        }
        val dtos = pizzaria.map {
            mapper.map(it, PizzariaResponse::class.java)
        }

        return ResponseEntity.status(200).body(dtos)
    }
}