/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.anaalml.eti.fastFurious.controller;

import br.anaalml.eti.fastFurious.DTO.AtualizaStatusDTO;
import br.anaalml.eti.fastFurious.domain.model.Pedido;
import br.anaalml.eti.fastFurious.domain.repository.PedidoRepository;
import br.anaalml.eti.fastFurious.domain.service.PedidoService;
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
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido adicionar(@Valid @RequestBody Pedido pedido) {
        return pedidoService.criar(pedido);

    }

    //----------
    // get
    //----------
    @GetMapping("/pedido")
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    //----- by id
    @GetMapping("/pedido/{pedidoID}")
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
    public ResponseEntity <List <Pedido>> buscarStatus(@PathVariable String status) {

        List<Pedido> pedido = pedidoRepository.findByStatus(status);

        if (status.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedido);

    }

    //----------
    // put
    //----------
    @PutMapping("/pedido/{pedidoID}")
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
