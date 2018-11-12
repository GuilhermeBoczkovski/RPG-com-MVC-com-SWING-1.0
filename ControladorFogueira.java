package rpgcommvccomswing;
import java.util.ArrayList;
import rpgcommvccomswing.Consumivel;
import rpgcommvccomswing.ConteudoTelaFogueira;
import rpgcommvccomswing.Feitico;
import rpgcommvccomswing.TipoElemento;
import rpgcommvccomswing.TipoEvento;

public class ControladorFogueira {
    private TelaFogueira telaFogueira;
    private ArrayList<Consumivel> itens;
    private ControladorPrincipal ctrlEncontro;
    private ArrayList<TipoEvento> eventos;
    private ArrayList<Feitico> feiticos;
    
    public ControladorFogueira(ControladorPrincipal ctrlEncontro){
        this.ctrlEncontro = ctrlEncontro;
        telaFogueira = new TelaFogueira(this);
        this.itens = ctrlEncontro.getJogador().getConsumiveisBolsa();
        this.eventos = ctrlEncontro.getJogador().getDiario().verEventos();
        feiticos = ctrlEncontro.getJogador().getFeiticos();
    }
    
    
    public void executaOpcao(String opcao){
        try{
            switch(opcao){
                case "0": telaFogueira.mostraFimFogueira();
                        break;
                case "1": verDiario();
                        break;
                case "2": verItens();
                        break;
                case "3": telaFogueira.mostraMenuDescartarItem(compactarItem());
                        break;
                case "4": telaFogueira.mostraMenuVerFeiticos();
                        break;
                case "5": telaFogueira.mostraMenuCriarFeitico();
                        break;
                case "6": telaFogueira.mostraMenuEsquecerFeiticos(compactarFeitico());
                        break;
                case "7": if(ctrlEncontro.getJogador().getPossuiChave()){irParaBoss();}
                        else{}
                        break;
                default:
            }
        } catch(Exception e){
            telaFogueira.mostraException(e.getMessage());
            telaFogueira.mostraMenuFogueira();
        }
    }
    
    public void iniciaEncontro(){
        ctrlEncontro.getJogador().setVidaAtual(ctrlEncontro.getJogador().getVidaTotal());
        telaFogueira.mostraInicioFogueira();
        telaFogueira.mostraMenuFogueira();
    }
    
    public void verDiario(){
        telaFogueira.mostraDiario(compactarEvento());
        telaFogueira.mostraMenuFogueira();
    }
    
    public void verItens(){
        telaFogueira.mostraItens(compactarItem());
        telaFogueira.mostraMenuFogueira();
    }
    
    public void criarFeitico(String nome, String tipo){
        if(this.ctrlEncontro.getJogador().getGrimorios()>=1){
            Feitico feitico;
            switch(tipo){
                case "1": feitico = new Feitico(ctrlEncontro.getJogador().getNivelInt(), nome, TipoElemento.FOGO);
                        ctrlEncontro.getJogador().addFeitico(feitico);
                        break;
                case "2": feitico = new Feitico(ctrlEncontro.getJogador().getNivelInt(), nome, TipoElemento.AGUA);
                        ctrlEncontro.getJogador().addFeitico(feitico);
                        break;
                case "3": feitico = new Feitico(ctrlEncontro.getJogador().getNivelInt(), nome, TipoElemento.GRAMA);
                        ctrlEncontro.getJogador().addFeitico(feitico);
                        break;
                case "4": feitico = new Feitico(ctrlEncontro.getJogador().getNivelInt(), nome, TipoElemento.PEDRA);
                        ctrlEncontro.getJogador().addFeitico(feitico);
                        break;
            }
                this.ctrlEncontro.getJogador().setGrimorios(this.ctrlEncontro.getJogador().getGrimorios()-1);
                telaFogueira.mostraCriarFeitico();
        }else{
            this.telaFogueira.mostraErroCriarFeitico();
        }
    }
    
    public void verFeiticos(String tipo){
        try{
            switch(tipo){
                case "1": telaFogueira.mostraFeiticos(compactarFeiticoPorTipo(TipoElemento.FOGO));
                        telaFogueira.mostraMenuFogueira();
                        break;
                case "2": telaFogueira.mostraFeiticos(compactarFeiticoPorTipo(TipoElemento.AGUA));
                        telaFogueira.mostraMenuFogueira();
                        break;
                case "3": telaFogueira.mostraFeiticos(compactarFeiticoPorTipo(TipoElemento.GRAMA));
                        telaFogueira.mostraMenuFogueira();
                        break;
                case "4": telaFogueira.mostraFeiticos(compactarFeiticoPorTipo(TipoElemento.PEDRA));
                        telaFogueira.mostraMenuFogueira();
                        break;
                default: 
            }
        } catch(Exception e){
            telaFogueira.mostraException(e.getMessage());
            telaFogueira.mostraMenuVerFeiticos();
        }
    }
    
    public void esquecerFeitico(String escolha){
        int escolhaInt = Integer.parseInt(escolha);
        ctrlEncontro.getJogador().delFeitico(escolhaInt);
    }
    
    public void descartarItem(int escolha){
        ctrlEncontro.getJogador().dellConsumivelBolsa(escolha);
    }
    
    public void finalizaFogueira(){
        ctrlEncontro.getJogador().getDiario().addEvento(TipoEvento.FOGUEIRA);
        ctrlEncontro.escolheEncontro();
    }
    
    public void irParaBoss(){
        ctrlEncontro.irParaBoss();
    }
    
    public ConteudoTelaFogueira compactaJogador(){
        ConteudoTelaFogueira conteudo = new ConteudoTelaFogueira();
        conteudo.jogador = ctrlEncontro.getJogador();
        return conteudo;
    }
    
    public ArrayList<ConteudoTelaFogueira> compactarFeiticoPorTipo(TipoElemento tipo){
        ArrayList<ConteudoTelaFogueira> feiticosCompactados = new ArrayList();
        for(Feitico feitico: feiticos){
            if(feitico.getTipoElemento() == tipo){
                ConteudoTelaFogueira novoConteudo = new ConteudoTelaFogueira();
                novoConteudo.feitico = feitico;
                feiticosCompactados.add(novoConteudo);
            }
        }
        return feiticosCompactados;
    }
    
    public ArrayList<ConteudoTelaFogueira> compactarFeitico(){
        ArrayList<ConteudoTelaFogueira> feiticosCompactados = new ArrayList();
        for(Feitico feitico: feiticos){
            ConteudoTelaFogueira novoConteudo = new ConteudoTelaFogueira();
            novoConteudo.feitico = feitico;
            feiticosCompactados.add(novoConteudo);
        }
        return feiticosCompactados;
    }
    
    public ArrayList<ConteudoTelaFogueira> compactarItem(){
        ArrayList<ConteudoTelaFogueira> itensCompactados = new ArrayList();
        for(Consumivel item: itens){
            ConteudoTelaFogueira novoConteudo = new ConteudoTelaFogueira();
            novoConteudo.item = item;
            itensCompactados.add(novoConteudo);
        }
        return itensCompactados;
    }
    
    public ArrayList<ConteudoTelaFogueira> compactarEvento(){
        ArrayList<ConteudoTelaFogueira> eventosCompactados = new ArrayList();
        for(TipoEvento evento: eventos){
            ConteudoTelaFogueira novoConteudo = new ConteudoTelaFogueira();
            novoConteudo.evento = evento;
            eventosCompactados.add(novoConteudo);
        }
        return eventosCompactados;
    }
}























