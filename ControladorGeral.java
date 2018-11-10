package rpgcommvccomswing;
;

public class ControladorGeral {
    
    private TelaInicio telaInicio;
    private TelaMenuInicial telaMenuInicial;
    private TelaSavedGame telaSavedGame;
    private ControladorPrincipal controladorPrincipal;
    
    public ControladorGeral(){
        this.telaInicio = new TelaInicio(this);
    }
    
    public void continuar(){
        
    }
    
    public void inicio(){
        try{
            telaInicio.mostraTelaInicio();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    void play(String nome){
        this.controladorPrincipal = new ControladorPrincipal(nome, 1);
        this.controladorPrincipal.escolheEncontro();
    }
    
}
