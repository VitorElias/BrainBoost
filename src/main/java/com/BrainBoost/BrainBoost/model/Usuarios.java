package com.BrainBoost.BrainBoost.model;

import java.io.Serializable;
import java.util.Objects;

public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1l;

    private long id;
    private String nome;
    private String email;
    private String senha;
    private int pontuacao;
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
