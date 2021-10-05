package br.edu.ifpb.domain;

import java.io.Serializable;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.edu.ifpb.infra.converter.ConverterCPF;

@Entity
public class Gerente implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    
    private String nome;
    private String email;

    @Convert(converter = ConverterCPF.class)
    private CPF cpf = new CPF("");
    
    @OneToOne
    private Banda banda;

    public Gerente (int id, String nome, String email, CPF cpf, Banda banda) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.banda = banda;
    }

    public Gerente() {
    }


    public int getId() {
        return id;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((banda == null) ? 0 : banda.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + id;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Gerente other = (Gerente) obj;
        if (banda == null) {
            if (other.banda != null)
                return false;
        } else if (!banda.equals(other.banda))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (id != other.id)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }
}
