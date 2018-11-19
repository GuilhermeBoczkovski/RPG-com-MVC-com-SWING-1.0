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
    private static ControladorGeral instancia;
    
    private ControladorGeral(){
        this.telaMenuInicial = new TelaMenuInicial();
        this.menuInicial();
    }
    
    public static ControladorGeral getInstance(){
        if(instancia == null){
            instancia = new ControladorGeral();
        }
        return instancia;
    }
    
    public void continuarComJogador(int indiceJogador){
        ControladorPrincipal.getInstance().continuarComJogador(indiceJogador);
    }
    
    public void excluirJogador(int indiceJogador){
        ControladorPrincipal.getInstance().excluiJogador(indiceJogador);
    }
    
    public void continuar(){
        this.telaSavedGame = new TelaSavedGame(ControladorPrincipal.getInstance().getListaJogadoresSalvos());
        this.telaSavedGame.mostraTela();
    }
    
    public void menuInicial(){
        this.telaMenuInicial.mostraTelaMenuInicial();
    }
    
    public void inicio(){
        try{
            this.telaInicio = new TelaInicio();
            telaInicio.mostraTelaInicio();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void play(String nome){
        ControladorPrincipal.getInstance(nome, true);
        ControladorPrincipal.getInstance().escolheEncontro();
    }
    
}
