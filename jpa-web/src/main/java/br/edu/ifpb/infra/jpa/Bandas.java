package br.edu.ifpb.infra.jpa;

import br.edu.ifpb.domain.Banda;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class Bandas {

    @PersistenceContext
    private EntityManager manager;

    public Banda salvar(Banda banda){
        manager.persist(banda);
        return banda;
    }

    public List<Banda> todos(){
        return manager.createQuery("SELECT b FROM Banda b", Banda.class).getResultList();
    }

    public List<Banda> buscaPorLocalDeOrigem(String localDeOrigem){
        Query query = manager.createQuery("SELECT b FROM Banda b WHERE b.localDeOrigem=:localDeOrigem", Banda.class);
        query.setParameter("localDeOrigem", localDeOrigem);
        return query.getResultList();
    }

}
