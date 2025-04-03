package com.example.Spring.Boot.Repository;

import com.example.Spring.Boot.Domain.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, String> {
}
