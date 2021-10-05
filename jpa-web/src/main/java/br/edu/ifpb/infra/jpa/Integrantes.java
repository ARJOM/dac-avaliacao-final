package br.edu.ifpb.infra.jpa;

import br.edu.ifpb.domain.Integrante;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class Integrantes {

    @PersistenceContext
    private EntityManager manager;

    public Integrante salvar(Integrante integrante) {
        manager.persist(integrante);
        return integrante;
    }

    public void updateIntegrante(Integrante integrante) {
        manager.merge(integrante);
    }

    public List<Integrante> todos() {
        return manager.createQuery("SELECT i FROM Integrante i", Integrante.class).getResultList();
    }

    public void deleteIntegrante (Integrante integrante) {
        manager.remove(manager.merge(integrante));
    }


    
    public Integrante buscarPorCPF(String cpf) {
        Query query = manager.createQuery("SELECT i FROM Integrante i WHERE i.cpf=:cpf", Integrante.class);
        query.setParameter("cpf", cpf);
        return (Integrante) query.getSingleResult();
    }

    public List<Integrante> integrantesPorIntervaloEspecifico() {
        return manager.createQuery(
                "SELECT i FROM Integrante i WHERE i.dataDeNascimento>='20000101' AND i.dataDeNascimento<='20160420'",
                Integrante.class).getResultList();
    }
}
