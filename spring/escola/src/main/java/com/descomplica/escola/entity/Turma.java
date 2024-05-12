package com.descomplica.escola.entity;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="turma")
public class Turma {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name="id_turma")
    private Integer idTurma;

    @Temporal(TemporalType.TIME)
    @Column(name="horario_turma")
    private Time horarioTurma;

    @Column(name="duracao_turma")
    private int duracaoTurma;

    @Temporal(TemporalType.DATE)
    @Column(name="data_inicio_turma")
    private Date dataInicioTurma;

    @Temporal(TemporalType.DATE)
    @Column(name="data_fim_turma")
    private Date dataFimTurma;

    @ManyToOne
    @JoinColumn(name="idInstrutor")
    private Instrutor instrutor;

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public Time getHorarioTurma() {
        return horarioTurma;
    }

    public void setHorarioTurma(Time horarioTurma) {
        this.horarioTurma = horarioTurma;
    }

    public int getDuracaoTurma() {
        return duracaoTurma;
    }

    public void setDuracaoTurma(int duracaoTurma) {
        this.duracaoTurma = duracaoTurma;
    }

    public Date getDataInicioTurma() {
        return dataInicioTurma;
    }

    public void setDataInicioTurma(Date dataInicioTurma) {
        this.dataInicioTurma = dataInicioTurma;
    }

    public Date getDataFimTurma() {
        return dataFimTurma;
    }

    public void setDataFimTurma(Date dataFimTurma) {
        this.dataFimTurma = dataFimTurma;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }
    
}
