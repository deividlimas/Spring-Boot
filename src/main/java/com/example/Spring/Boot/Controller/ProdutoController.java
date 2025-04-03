package com.example.Spring.Boot.Controller;

import com.example.Spring.Boot.Domain.Produto;
import com.example.Spring.Boot.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> ListarTodos() {
        List<Produto> produto = produtoService.listarTodos();
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) { //-- Anotação request body para que o spring entenda que vai receber um corpo da requisição;
        Produto novoProduto = produtoService.salvar(produto);
        return  new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    @GetMapping("/{sku}")
    public ResponseEntity<Produto> buscarPorID(@PathVariable String sku) { //-- Quando na anotação eu tenho um /{} preciso indicar que o caminho passado é esse;
        Optional<Produto> produtoOptional = produtoService.buscaPorId(sku);
        if (produtoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoOptional.get());
    }

    @DeleteMapping("/{sku}")
    public ResponseEntity<Void> deletar(@PathVariable String sku) {
        produtoService.delete(sku);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Produto> alterar(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.salvar(produto);
        return ResponseEntity.ok(novoProduto);
    }
}
