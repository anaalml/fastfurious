/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.anaalml.eti.fastFurious.controller;

import br.anaalml.eti.fastFurious.domain.repository.ItemPedidoRepository;
import br.anaalml.eti.fastFurious.domain.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesi3dia
 */
@RestController
public class ItemPedidoController {
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ItemPedidoService itemPedidoService;
    
}
