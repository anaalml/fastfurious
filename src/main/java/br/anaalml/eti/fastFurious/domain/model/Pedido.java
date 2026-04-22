/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.anaalml.eti.fastFurious.domain.model;

import br.anaalml.eti.fastFurious.StatusPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
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
    private LocalDateTime dtEntregue;

    public Pedido() {
    }

    public Pedido(Long id, String cpf, String nomeCliente, StatusPedido status, LocalDateTime dtAberto, LocalDateTime dtPronto, LocalDateTime dtEntregue) {
        this.id = id;
        this.cpf = cpf;
        this.nomeCliente = nomeCliente;
        this.status = status;
        this.dtAberto = dtAberto;
        this.dtPronto = dtPronto;
        this.dtEntregue = dtEntregue;
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
        return dtEntregue;
    }

    public void setDtEntregue(LocalDateTime dtEntregue) {
        this.dtEntregue = dtEntregue;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.cpf);
        hash = 79 * hash + Objects.hashCode(this.nomeCliente);
        hash = 79 * hash + Objects.hashCode(this.status);
        hash = 79 * hash + Objects.hashCode(this.dtAberto);
        hash = 79 * hash + Objects.hashCode(this.dtPronto);
        hash = 79 * hash + Objects.hashCode(this.dtEntregue);
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
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.nomeCliente, other.nomeCliente)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.dtAberto, other.dtAberto)) {
            return false;
        }
        if (!Objects.equals(this.dtPronto, other.dtPronto)) {
            return false;
        }
        return Objects.equals(this.dtEntregue, other.dtEntregue);
    }
    
    
    
    
    
}
