/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.anaalml.eti.fastFurious.controller;

import br.anaalml.eti.fastFurious.DTO.AtualizaStatusDTO;
import br.anaalml.eti.fastFurious.StatusPedido;
import br.anaalml.eti.fastFurious.domain.model.Pedido;
import br.anaalml.eti.fastFurious.domain.repository.PedidoRepository;
import br.anaalml.eti.fastFurious.domain.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoService pedidoService;

    //----------
    // post
    //----------
    @PostMapping("/pedido")
    
    @Operation(summary = "Publica um determinado pedido", description = "Publica um pedido na base de dados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully posted"),
        @ApiResponse(responseCode = "422", description = "The format is correct, but bthe data failed the business rule")
    })
    
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido adicionar(@Valid @RequestBody Pedido pedido) {
        return pedidoService.criar(pedido);

    }

    //----------
    // get
    //----------
    @GetMapping("/pedido")
    
    @Operation(summary = "Lista todos os pedidos", description = "Retorna todos os pedidos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "404", description = "Not found - O pedido não foi encontrado")
    })
    
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    //----- by id
    @GetMapping("/pedido/{pedidoID}")
    
    @Operation(summary = "Lista os pedidos by ID", description = "Retorna o produto pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "404", description = "Not found - O pedido não foi encontrado")
    })
    
    public ResponseEntity<Pedido> buscar(@PathVariable Long pedidoID) {
        Optional<Pedido> pedido = pedidoRepository.findById(pedidoID);

        if (pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //-----------
    // get status
    //-----------
    @GetMapping("/pedido/status/{status}")
    
    @Operation(summary = "Lista os produtos pelo status", description = "Retorna todos os pedidos com um determinado status")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "404", description = "Not found - O pedido não foi encontrado")
    })
    public ResponseEntity<List<Pedido>> buscarStatus(@PathVariable String status) {

        StatusPedido statusEnum = StatusPedido.valueOf(status.toUpperCase());

        List<Pedido> pedido = pedidoRepository.findByStatus(statusEnum);

        if (status.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedido);

    }

    //----------
    // put
    //----------
    @PutMapping("/pedido/{pedidoID}")
    
    @Operation(summary = "Altera um determinado pedido", description = "Atualiza no banco de dados a alteração determinada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "404", description = "Not found - O pedido não foi encontrado")
    })
    public ResponseEntity<Pedido> atualizar(@Valid @PathVariable Long pedidoID,
            @RequestBody Pedido pedido) {
        if (!pedidoRepository.existsById(pedidoID)) {
            return ResponseEntity.notFound().build();
        }
        pedido.setId(pedidoID);
        pedido = pedidoService.criar(pedido);
        return ResponseEntity.ok(pedido);
    }

    //-----------
    // put status
    //-----------
    @PutMapping("/pedido/atualizaStatus/{pedidoID}")
    
    @Operation(summary = "Altera um determinado pedido baseado no ID", description = "Atualiza no banco de dados a alteração determinada pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "404", description = "Not found - O pedido não foi encontrado")
    })
    
    public ResponseEntity<Pedido> atualizarStatus(@Valid @PathVariable Long pedidoID,
            @RequestBody AtualizaStatusDTO atualizaStatusDTO) {

        Optional<Pedido> optPedido = pedidoService.atualizarStatus(pedidoID, atualizaStatusDTO.status());

        if (optPedido.isEmpty()) {
            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(optPedido.get());
    }

    //----------
    // delete
    //----------
    @DeleteMapping("/pedido/{pedidoID}")
    public ResponseEntity<Pedido> excluir(@PathVariable Long pedidoID) {

        if (!pedidoRepository.existsById(pedidoID)) {
            return ResponseEntity.notFound().build();

        }

        pedidoService.excluir(pedidoID);
        return ResponseEntity.noContent().build();
    }

    
    
    
}
