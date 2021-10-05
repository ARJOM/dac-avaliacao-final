package br.edu.ifpb.web;

import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.infra.jpa.Bandas;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@SessionScoped
public class ControladorDeBandas {

    @Inject
    private Bandas bandas;

    private String localDeOrigem = "";
    private List<Banda> bandaList;

    public List<Banda> todasAsBandas(){
        return this.bandas.todos();
    }

    public String buscarPorLocalDeOrigem(){
        this.bandaList = bandas.buscaPorLocalDeOrigem(localDeOrigem);
        return null;
    }

    public List<Banda> resultadoDeBusca(){
        return this.bandaList;
    }

    public String getLocalDeOrigem() {
        return localDeOrigem;
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        this.localDeOrigem = localDeOrigem;
    }
}
