package br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Banda implements Serializable{

    @Id
    @GeneratedValue
    private int id;
    
    private String localDeOrigem;
    private String nomeFantasia;
    
    @OneToMany
    @JoinColumn(name = "banda_id")
    private List<Integrante> integrantes = new ArrayList<>();
    
    @OneToOne
    private Gerente gerente;

    public Banda(Integer id, String localDeOrigem, String nomeFantasia,List<Integrante> integrantes, Gerente gerente ) {
        this.setId(id);
        this.setLocalDeOrigem(localDeOrigem);
        this.setNomeFantasia(nomeFantasia);
        this.setIntegrantes(new ArrayList<>());
        this.setGerente(gerente);
    }

    public Banda () {

    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getLocalDeOrigem() {
        return localDeOrigem;
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        this.localDeOrigem = localDeOrigem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gerente == null) ? 0 : gerente.hashCode());
        result = prime * result + id;
        result = prime * result + ((integrantes == null) ? 0 : integrantes.hashCode());
        result = prime * result + ((localDeOrigem == null) ? 0 : localDeOrigem.hashCode());
        result = prime * result + ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
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
        Banda other = (Banda) obj;
        if (gerente == null) {
            if (other.gerente != null)
                return false;
        } else if (!gerente.equals(other.gerente))
            return false;
        if (id != other.id)
            return false;
        if (integrantes == null) {
            if (other.integrantes != null)
                return false;
        } else if (!integrantes.equals(other.integrantes))
            return false;
        if (localDeOrigem == null) {
            if (other.localDeOrigem != null)
                return false;
        } else if (!localDeOrigem.equals(other.localDeOrigem))
            return false;
        if (nomeFantasia == null) {
            if (other.nomeFantasia != null)
                return false;
        } else if (!nomeFantasia.equals(other.nomeFantasia))
            return false;
        return true;
    }

    
}