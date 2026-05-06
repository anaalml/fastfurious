/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package br.anaalml.eti.fastFurious.DTO;

import br.anaalml.eti.fastFurious.StatusPedido;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author sesi3dia
 */
public record AtualizaStatusDTO(
        @NotNull (message = "Status é obrigatório!")
        StatusPedido status) {
    
    

}
