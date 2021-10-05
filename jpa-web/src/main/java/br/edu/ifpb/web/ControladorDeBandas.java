package br.edu.ifpb.web;

import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.infra.jpa.Bandas;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@SessionScoped
@Named
public class ControladorDeBandas implements Serializable{
    @Inject
    private Bandas bandas;
    private Banda banda = new Banda();
    private List<Banda> resultBandas = new ArrayList<>();
    private String localDeOrigem = "";

    public String buscarPorLocalDeOrigem(){
        this.resultBandas = bandas.buscaPorLocalDeOrigem(localDeOrigem);
        return null;
    }

    public List<Banda> getResultBandas() {
        return resultBandas;
    }

    public void setResultBandas(List<Banda> resultBandas) {
        this.resultBandas = resultBandas;
    }

    public Bandas getBandas() {
        return bandas;
    }

    public void setBandas(Bandas bandas) {
        this.bandas = bandas;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
    
    public String adicionar () {
        if ( this.banda.getId() > 0 ) {
            this.bandas.updateBanda(banda);
        } else {
            this.bandas.add(this.banda);
        }
        this.banda = new Banda();
        return "/banda/list?faces-redirect=true";
    }
        
    public String update(Banda banda) {
        this.banda = banda;
        return "/banda/edit?faces-redirect=true";
    }
    
    public String remover (Banda banda) {
        this.bandas.deleteBanda(banda);
        return "/banda/edit?faces-redirect=true";
    }
    
    public List<Banda> listar() {
        return this.bandas.todos();
    }
    
    public String search(){        
        this.resultBandas = this.bandas.buscaPorLocalDeOrigem(this.banda.getLocalDeOrigem());
        this.banda = new Banda();
        return "/banda/search?faces-redirect=true";
    }


    public String getLocalDeOrigem() {
        return localDeOrigem;
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        this.localDeOrigem = localDeOrigem;
    }
        
    
}