/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.anaalml.eti.fastFurious.controller;

import br.anaalml.eti.fastFurious.domain.model.Produto;
import br.anaalml.eti.fastFurious.domain.repository.ProdutoRepository;
import br.anaalml.eti.fastFurious.domain.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesi3dia
 */
@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    // get  
    @GetMapping("/produto")
    
    @Operation(summary = "Lista todos os produtos", description = "Retorna todos os produtos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "404", description = "Not found - O produto não foi encontrado")
    })
    
    

    public List<Produto> listar() {
        return produtoRepository.findAll();

    }

    @GetMapping("/produto/{produtoID}")
    
    @Operation(summary = "Lista todos os produtos pelo ID", description = "Retorna todos os produtos com um determinado ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "404", description = "Not found - O produto não foi encontrado")
    })

    public ResponseEntity<Produto> buscar(@PathVariable Long produtoID) {
        Optional<Produto> produto = produtoRepository.findById(produtoID);

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @GetMapping("/produto/cat/{categoria}")
    
    @Operation(summary = "Lista todos os produtos pela categoria", description = "Retorna todos os produtos com uma determinada categoria")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "404", description = "Not found - O produto não foi encontrado")
    })

    public ResponseEntity<Produto> buscarCat(@PathVariable Long categoria) {
        Optional<Produto> produto = produtoRepository.findById(categoria);

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // post
    @PostMapping("/produto")
    @Operation(summary = "Publica um determinado produto", description = "Publica um produto na base de dados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully posted"),
        @ApiResponse(responseCode = "422", description = "The format is correct, but bthe data failed the business rule")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionar(@Valid @RequestBody Produto produto) {
        return produtoService.criar(produto);
    }

    // put
    @PutMapping("/produto/{produtoID}")
    @Operation(summary = "Altera um determinado produto", description = "Atualiza no banco de dados a alteração determinada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "404", description = "Not found - O pedido não foi encontrado")
    })
    public ResponseEntity<Produto> atualizar(@Valid @PathVariable Long produtoID,
            @RequestBody Produto produto) {
        if (!produtoRepository.existsById(produtoID)) {
            return ResponseEntity.notFound().build();
        }
        produto.setId(produtoID);
        produto = produtoService.criar(produto);
        return ResponseEntity.ok(produto);
    }

    // delete
    @DeleteMapping("/produto/{produtoID}")
    public ResponseEntity<Produto> excluir(@PathVariable Long produtoID) {

        if (!produtoRepository.existsById(produtoID)) {
            return ResponseEntity.notFound().build();

        }

        produtoService.excluir(produtoID);
        return ResponseEntity.noContent().build();
    }

}
