package com.example.Spring.Boot.Service;

import com.example.Spring.Boot.Domain.Produto;
import com.example.Spring.Boot.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired //-- Faz o controle de dependencia de forma automárica;
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return (List<Produto>) repository.findAll();
        //-- O metodo findAll retorna um iterable, então é necessário fazer um cast para retornar uma lista: (List<Produto>) antes do retorno;
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Optional<Produto> buscaPorId(String sku) {
        return repository.findById(sku);
    }

    public void delete(String sku) {
        repository.deleteById(sku);
    }
}
