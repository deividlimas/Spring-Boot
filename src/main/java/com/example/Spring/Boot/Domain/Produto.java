package com.example.Spring.Boot.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    private String sku;
    private String nome;
    private String descricao;
    private double valor;
    private Integer quantidade;

}
