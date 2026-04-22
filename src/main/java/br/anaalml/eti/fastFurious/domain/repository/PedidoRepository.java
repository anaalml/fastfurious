/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.anaalml.eti.fastFurious.domain.repository;

import br.anaalml.eti.fastFurious.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sesi3dia
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}
