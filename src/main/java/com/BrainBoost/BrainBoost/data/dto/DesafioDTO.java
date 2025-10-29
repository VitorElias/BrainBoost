package com.BrainBoost.BrainBoost.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class DesafioDTO implements Serializable {

    private static final long serialVersionUID = 1l;

    private Long id;
    private String titulo;
    private String descricao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateExpiracao;
    private int pontuacao;


    public DesafioDTO() {
    }

    public DesafioDTO(Long id, String titulo, String descricao, LocalDate dataCriacao, LocalDate dateExpiracao, int pontuacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dateExpiracao = dateExpiracao;
        this.pontuacao = pontuacao;
    }

    public DesafioDTO(String titulo, String descricao, LocalDate dataCriacao, LocalDate dateExpiracao, int pontuacao) {
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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDateExpiracao() {
        return dateExpiracao;
    }

    public void setDateExpiracao(LocalDate dateExpiracao) {
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
        if (!(o instanceof DesafioDTO that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
