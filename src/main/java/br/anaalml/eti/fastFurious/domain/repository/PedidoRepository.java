/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.anaalml.eti.fastFurious.domain.repository;

import br.anaalml.eti.fastFurious.domain.model.Pedido;
import br.anaalml.eti.fastFurious.domain.service.PedidoService;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sesi3dia
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    List<Pedido> findByCpf(String nome);
    List<Pedido> findByNomeClienteContaining(String nome);
//    List<Pedido> findByListaItens(String listaItens);
    List<Pedido> findByStatus(String status);
    
}
