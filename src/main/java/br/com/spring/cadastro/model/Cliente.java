package br.com.spring.cadastro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cliente {
    @Id
    @GeneratedValue
    int id;
    private String nome;
    private int idade;

    public Cliente(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
