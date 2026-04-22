/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.anaalml.eti.fastFurious.domain.service;

import br.anaalml.eti.fastFurious.domain.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesi3dia
 */
@Service
public class ItemPedidoService {
     @Autowired
    private ItemPedidoRepository ItemPedidoRepository;
    
}
