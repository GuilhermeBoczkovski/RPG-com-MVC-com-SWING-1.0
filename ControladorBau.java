package rpgcommvccomswing;
import java.util.ArrayList;
import java.util.Random;

class ControladorBau{
    private ControladorPrincipal ctrlPrincipal;
    private TelaBau telaBau;
    private TelaBauSwing telaBauS;
    private Arma armaBau;
    private Consumivel consumivelBau;
    private boolean temGrimorio;
    private boolean temArma;
    private boolean temConsumivel;

    public ControladorBau(ControladorPrincipal aThis) {
        temGrimorio = false;
        temArma = false;
        temConsumivel = false;
        telaBau = new TelaBau(this);
        ctrlPrincipal = aThis;
    }

    public void iniciaEncontro() {      
        geraItens();
        telaBau = new TelaBau(this);
        telaBau.mostraMenu();
        /*
        telaBau.mostraAcharBau();
        telaBau.mostraMenu();*/
    }
    
    public void geraItens(){
        
        Random randArma = new Random();
        int arma = randArma.nextInt(2);
        Random randConsumivel = new Random();
        int consumivel = randConsumivel.nextInt(2);
        Random randGrimorio = new Random();
        int grimorio = randGrimorio.nextInt(2);

        switch(arma){
            case 0: break;
            case 1: Arma armaBau = new Arma(15);
                    this.armaBau = armaBau;
                    this.temArma = true;
                    break;
        }
        
        switch(consumivel){
            case 0: break;
            case 1: Consumivel consumivelBau = new Consumivel("Pocao de vida");
                    this.consumivelBau = consumivelBau;
                    this.temConsumivel = true;
                    break;
        }
        
        switch(grimorio){
            case 0: break;
            case 1: temGrimorio = true;
                    break;
        }
        
        if(!temArma && !temConsumivel && !temGrimorio){
            Consumivel consumivelBau = new Consumivel("Pocao de vida");
            this.consumivelBau = consumivelBau;
            this.temConsumivel = true;
        }
    }

    public void executaOpcao(String escolha){
        try{
            switch(escolha){
                case "0": telaBau.mostraFimBau();
                        break;
                case "1": telaBau.mostraItens(compactarItensJogador());
                          break;
                case "2": telaBau.mostraArma(compactarArmaJogador());
                          break;
                case "3": if(temArma){
                            compararArmas();
                          }else{
                            
                          };
                          break;
                case "4": if(temConsumivel){
                            verItens();
                          }else{
                            
                          };
                          break;
                default: 
            }
        }catch(Exception e){
            telaBau.mostraException(e.getMessage());
            telaBau.mostraMenu();
        }

    }
    
    public void finalizaBau(){
        this.ctrlPrincipal.getJogador().getDiario().addEvento(TipoEvento.BAU);
        ctrlPrincipal.escolheEncontro();
    }
    
    public void verItens() {
        telaBau.mostraColetaConsumivel(compactarItensJogador(), compactarConsumivelBau());
    }
    
    public void compararArmas() {
        telaBau.mostraComparacao(compactarArmas());
    }
    
    public void trocarArma(){
        this.ctrlPrincipal.getJogador().setArma(armaBau);
        this.armaBau = null;
        this.temArma = false;
        telaBau.update(compactarItensBoolean());
    }
    
    public void pegarConsumivel(){
        this.ctrlPrincipal.getJogador().addConsumivelBolsa(consumivelBau);
        this.consumivelBau = null;
        this.temConsumivel = false;
        telaBau.update(compactarItensBoolean());
    }
    
    public ConteudoTelaBau compactarItensBoolean(){
        ConteudoTelaBau conteudo = new ConteudoTelaBau();
        conteudo.temArma = this.temArma;
        conteudo.temConsumivel = this.temConsumivel;
        conteudo.temGrimorio = this.temGrimorio;
        return conteudo;
    }
    
    public ConteudoTelaBau compactarConsumivelBau(){
        ConteudoTelaBau conteudo = new ConteudoTelaBau();
        conteudo.item = consumivelBau;
        return conteudo;
    }
    
    public ArrayList<ConteudoTelaBau> compactarItensJogador(){
        ArrayList<ConteudoTelaBau> conteudos = new ArrayList();
        ArrayList<Consumivel> consumiveis = ctrlPrincipal.getJogador().getConsumiveisBolsa();
        for(Consumivel consumivel: consumiveis){
            ConteudoTelaBau conteudo = new ConteudoTelaBau();
            conteudo.item = consumivel;
            conteudos.add(conteudo);
        }
        return conteudos;
    }
    
    public ConteudoTelaBau compactarArmas(){
        ConteudoTelaBau conteudo = new ConteudoTelaBau();
        conteudo.armaJogador = ctrlPrincipal.getJogador().getArma();
        conteudo.armaBau = this.armaBau;
        return conteudo;
    }
    
    public ConteudoTelaBau compactarArmaJogador(){
        ConteudoTelaBau conteudo = new ConteudoTelaBau();
        conteudo.armaJogador = ctrlPrincipal.getJogador().getArma();
        return conteudo;
    }
}














