package br.edu.ifpb.web;

import br.edu.ifpb.domain.Integrante;
import br.edu.ifpb.infra.jpa.Integrantes;


import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ControladorDeIntegrantes {

    @Inject
    private Integrantes integrantes;

    private Integrante integrante = new Integrante();
    private String resultIntegrante = "";

    public String getResultIntegrante() {
        return resultIntegrante;
    }

    public void setResultIntegrante(String resultIntegrante) {
        this.resultIntegrante = resultIntegrante;
    }


    public Integrantes getPersistencia() {
        return integrantes;
    }

    public void setIntegrante(Integrantes integrantes) {
        this.integrantes = integrantes;
    }

    public Integrante getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }


    public String add() {
        if(this.integrante.getId() > 0){
            this.integrantes.updateIntegrante(this.integrante);
        } else {
            this.integrantes.salvar(
                    this.integrante
            );
        }
        this.integrante = new Integrante();
        return "/integrante/list?faces-redirect=true";
    }



    public String update(Integrante integrante) {
        this.integrante = integrante;
        return "/integrante/edit?faces-redirect=true";

    }



    public String delete(Integrante integrante) {
        this.integrantes.deleteIntegrante(integrante);
        return "/integrante/list";
    }


    public List<Integrante> todosOsIntegrantes() {
        return this.integrantes.todos();
    }



    public List<Integrante> listNascimento() {
        return this.integrantes.integrantesPorIntervaloEspecifico();
    }

}
