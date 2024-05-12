package com.descomplica.escola.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="instrutor")
public class Instrutor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name="id_instrutor")
    private Integer idInstrutor;

    @Column(name="nome_instrutor")
    private String nomeInstrutor;

    @Column(name="rg_instrutor")
    private int rgInstrutor;

    @Column(name="titulacao_instrutor")
    private int titulacaoInstrutor;

    @Temporal(TemporalType.DATE)
    @Column(name="nascimento_instrutor")
    private Date nascimentoInstrutor;

    @OneToMany(mappedBy="idTurma")
    private Set<Turma> turmas;

    public Integer getIdInstrutor() {
        return idInstrutor;
    }

    public void setIdInstrutor(Integer idInstrutor) {
        this.idInstrutor = idInstrutor;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }

    public int getRgInstrutor() {
        return rgInstrutor;
    }

    public void setRgInstrutor(int rgInstrutor) {
        this.rgInstrutor = rgInstrutor;
    }

    public int getTitulacaoInstrutor() {
        return titulacaoInstrutor;
    }

    public void setTitulacaoInstrutor(int titulacaoInstrutor) {
        this.titulacaoInstrutor = titulacaoInstrutor;
    }

    public Date getNascimentoInstrutor() {
        return nascimentoInstrutor;
    }

    public void setNascimentoInstrutor(Date nascimentoInstrutor) {
        this.nascimentoInstrutor = nascimentoInstrutor;
    }

    public Set<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(Set<Turma> turmas) {
        this.turmas = turmas;
    }
}
