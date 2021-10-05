package br.edu.ifpb.domain;

import br.edu.ifpb.infra.converter.ConverterCPF;
import br.edu.ifpb.infra.converter.LocalDateConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Integrante implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    
    private String nome;

    @Temporal(TemporalType.DATE)
    @Convert(converter = LocalDateConverter.class)
    private LocalDate dataDeNascimento;

    @Convert(converter = ConverterCPF.class)
    private CPF cpf = new CPF("");

    public Integrante(int id, String nome, LocalDate dataDeNascimento, CPF cpf) {
        this.id = id;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
    }

    public Integrante() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Integrante that = (Integrante) o;
        return id == that.id && Objects.equals(nome, that.nome) && Objects.equals(dataDeNascimento, that.dataDeNascimento) && Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataDeNascimento, cpf);
    }

    @Override
    public String toString() {
        return "Integrante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                ", cpf=" + cpf +
                '}';
    }
}
