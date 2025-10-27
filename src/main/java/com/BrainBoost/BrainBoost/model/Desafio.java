package com.BrainBoost.BrainBoost.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Desafio implements Serializable {

    private static final long serialVersionUID = 1l;


    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dateExpiracao;
    private int pontuacao;


    public Desafio() {
    }

    public Desafio(String titulo, String descricao, LocalDateTime dataCriacao, LocalDateTime dateExpiracao, int pontuacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dateExpiracao = dateExpiracao;
        this.pontuacao = pontuacao;
    }

    public Desafio(Long id, String titulo, String descricao, LocalDateTime dataCriacao, LocalDateTime dateExpiracao, int pontuacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dateExpiracao = dateExpiracao;
        this.pontuacao = pontuacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDateExpiracao() {
        return dateExpiracao;
    }

    public void setDateExpiracao(LocalDateTime dateExpiracao) {
        this.dateExpiracao = dateExpiracao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Desafio desafio)) return false;
        return Objects.equals(id, desafio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Desafio{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dateExpiracao=" + dateExpiracao +
                ", pontuacao=" + pontuacao +
                '}';
    }
}
