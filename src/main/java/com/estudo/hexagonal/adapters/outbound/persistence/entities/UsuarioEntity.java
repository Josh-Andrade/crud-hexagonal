package com.estudo.hexagonal.adapters.outbound.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class UsuarioEntity {

    @Id
    private String id;
    @Column(length = 100, nullable = false)
    private String nome;
    @Column(length = 100, nullable = false)
    private Integer idade;

    @Deprecated
    public UsuarioEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
