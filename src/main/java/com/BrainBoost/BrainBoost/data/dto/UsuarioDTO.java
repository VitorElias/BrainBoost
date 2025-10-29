package com.BrainBoost.BrainBoost.data.dto;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1l;

    private long id;
    private String nome;
    private String email;
    private int pontuacao;
    private int nível;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String nome, String email, int pontuacao, int nível) {
        this.nome = nome;
        this.email = email;
        this.pontuacao = pontuacao;
        this.nível = nível;
    }

    public UsuarioDTO(long id, String nome, String email, int pontuacao, int nível) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.pontuacao = pontuacao;
        this.nível = nível;
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
        if (!(o instanceof UsuarioDTO that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", pontuacao=" + pontuacao +
                ", nível=" + nível +
                '}';
    }
}
