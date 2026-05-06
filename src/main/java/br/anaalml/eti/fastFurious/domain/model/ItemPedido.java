/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.anaalml.eti.fastFurious.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 *
 * @author sesi3dia
 */

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotBlank
    @Size(max = 120)
    
    private String obs;
    private Double vUnit;
    
    @ManyToOne
    @JoinColumn(name="pedido_id")
    @JsonIgnore
    private Pedido pedido;

    public ItemPedido() {
    }

    public ItemPedido(long id, String obs, Double vUnit, Pedido pedido) {
        this.id = id;
        this.obs = obs;
        this.vUnit = vUnit;
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
   public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Double getvUnit() {
        return vUnit;
    }

    public void setvUnit(Double vUnit) {
        this.vUnit = vUnit;
    }
    
    

    
}
