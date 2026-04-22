/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.anaalml.eti.fastFurious.domain.service;

import br.anaalml.eti.fastFurious.domain.model.Produto;
import br.anaalml.eti.fastFurious.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesi3dia
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criar(Produto produto) {

        return produtoRepository.save(produto);
    }
    
    
    public void excluir(Long produtoId) {
        produtoRepository.deleteById(produtoId);
    }
}
