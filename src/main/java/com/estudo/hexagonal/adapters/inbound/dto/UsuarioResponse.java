package com.estudo.hexagonal.adapters.inbound.dto;

public class UsuarioResponse {

    private String nome;
    private Integer idade;

    public UsuarioResponse() {
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
