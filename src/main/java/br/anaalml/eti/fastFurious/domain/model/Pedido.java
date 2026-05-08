/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.anaalml.eti.fastFurious.domain.model;

import br.anaalml.eti.fastFurious.StatusPedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author sesi3dia
 */

@Entity
public class Pedido {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size (max = 14)
    
    private String cpf;
    
    @NotBlank
    @Size (max = 60)
    
    private String nomeCliente;
    
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    
    private LocalDateTime dtAberto;
    private LocalDateTime dtPronto;
    private LocalDateTime dtFinalizada;
    private LocalDateTime dtCancelado;
    
    @OneToMany (mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List <ItemPedido> listaItens;

    public Pedido() {
    }

    public Pedido(Long id, String cpf, String nomeCliente, StatusPedido status, LocalDateTime dtAberto, LocalDateTime dtPronto, LocalDateTime dtFinalizada, LocalDateTime dtCancelado, List<ItemPedido> listaItens) {
        this.id = id;
        this.cpf = cpf;
        this.nomeCliente = nomeCliente;
        this.status = status;
        this.dtAberto = dtAberto;
        this.dtPronto = dtPronto;
        this.dtFinalizada = dtFinalizada;
        this.dtCancelado = dtCancelado;
        this.listaItens = listaItens;
    }

    

    public List<ItemPedido> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<ItemPedido> listaItens) {
        this.listaItens = listaItens;
    }

    public LocalDateTime getDtCancelado() {
        return dtCancelado;
    }

    public void setDtCancelado(LocalDateTime dtCancelado) {
        this.dtCancelado = dtCancelado;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public LocalDateTime getDtAberto() {
        return dtAberto;
    }

    public void setDtAberto(LocalDateTime dtAberto) {
        this.dtAberto = dtAberto;
    }

    public LocalDateTime getDtPronto() {
        return dtPronto;
    }

    public void setDtPronto(LocalDateTime dtPronto) {
        this.dtPronto = dtPronto;
    }

    public LocalDateTime getDtEntregue() {
        return dtFinalizada;
    }

    public void setDtEntregue(LocalDateTime dtEntregue) {
        this.dtFinalizada = dtEntregue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        return Objects.equals(this.id, other.id);
    }
}
