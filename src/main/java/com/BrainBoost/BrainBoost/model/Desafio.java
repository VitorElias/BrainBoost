package com.BrainBoost.BrainBoost.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Desafios")
public class Desafio implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "dataCriacao")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private LocalDate dataCriacao;

    @Column(name = "DataExpiracao")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private LocalDate dateExpiracao;

    @Column(name = "pontuacao")
    private int pontuacao;


    public Desafio() {
    }

    public Desafio(String titulo, String descricao, LocalDate dataCriacao, LocalDate dateExpiracao, int pontuacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dateExpiracao = dateExpiracao;
        this.pontuacao = pontuacao;
    }

    public Desafio(Long id, String titulo, String descricao, LocalDate dataCriacao, LocalDate dateExpiracao, int pontuacao) {
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
