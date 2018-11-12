package br.ufsc.ine5605.controladores;
;

import br.ufsc.ine5605.telas.TelaMenuInicial;
import br.ufsc.ine5605.telas.TelaInicio;
import br.ufsc.ine5605.telas.TelaSavedGame;

public class ControladorGeral {
    
    private TelaInicio telaInicio;
    private TelaMenuInicial telaMenuInicial;
    private TelaSavedGame telaSavedGame;
    private ControladorPrincipal controladorPrincipal;
    
    public ControladorGeral(){
        this.telaMenuInicial = new TelaMenuInicial(this);
        this.menuInicial();
    }
    
    public void continuar(){
        
    }
    
    public void menuInicial(){
        this.telaMenuInicial.mostraTelaMenuInicial();
    }
    
    public void inicio(){
        try{
            this.telaInicio = new TelaInicio(this);
            telaInicio.mostraTelaInicio();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void play(String nome){
        this.controladorPrincipal = new ControladorPrincipal(nome, 1);
        this.controladorPrincipal.escolheEncontro();
    }
    
}
