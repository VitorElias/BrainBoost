package com.BrainBoost.BrainBoost.data.dto;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioCreateDTO implements Serializable {

    private static final long serialVersionUID = 1l;

    private long id;
    private String nome;
    private String email;
    private String senha;

    public UsuarioCreateDTO() {
    }

    public UsuarioCreateDTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;

    }

    public UsuarioCreateDTO(long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UsuarioCreateDTO that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    @Override
    public String toString() {
        return "UsuarioCreateDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
