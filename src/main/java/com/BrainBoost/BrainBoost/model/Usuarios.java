package com.BrainBoost.BrainBoost.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Usuario")
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @Column(name = "senha",nullable = false)
    private String senha;

    @Column(name = "pontuacao")
    private int pontuacao;

    @Column(name = "nivel")
    private int nível;

    public Usuarios() {}

    public Usuarios(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.pontuacao = 0;
        this.nível = 0;
    }

    public Usuarios(Long id,String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.pontuacao = 0;
        this.nível = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getNível() {
        return nível;
    }

    public void setNível(int nível) {
        this.nível = nível;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuarios usuarios)) return false;
        return id == usuarios.id && Objects.equals(email, usuarios.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
