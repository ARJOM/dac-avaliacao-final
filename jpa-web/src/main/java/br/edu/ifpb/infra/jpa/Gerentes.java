package br.edu.ifpb.infra.jpa;

import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.domain.Gerente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class Gerentes {

    @PersistenceContext
    private EntityManager manager;

    public Gerente salvar(Gerente gerente) {
        manager.persist(gerente);
        return gerente;
    }

    public void updateGerente(Gerente gerente) {
        manager.merge(gerente);
    }

    public void deleteGerente(Gerente gerente) {
        manager.remove(manager.merge(gerente));
    }

    public List<Gerente> todos() {
        return manager.createQuery("SELECT g FROM Gerente g", Gerente.class).getResultList();
    }
}
