package br.ufsc.ine5605.controladores;
import java.util.ArrayList;
import br.ufsc.ine5605.entidades.Consumivel;
import br.ufsc.ine5605.telas.ConteudoTelaFogueira;
import br.ufsc.ine5605.entidades.Feitico;
import br.ufsc.ine5605.entidades.TipoElemento;
import br.ufsc.ine5605.entidades.TipoEvento;
import br.ufsc.ine5605.telas.TelaCriarFeitico;
import br.ufsc.ine5605.telas.TelaDeletarCoisasFogueira;
import br.ufsc.ine5605.telas.TelaListagemBasicaFogueira;
import br.ufsc.ine5605.telas.TelaFogueiraSwing;
import br.ufsc.ine5605.telas.TelaMenuFeiticosFogueira;
import br.ufsc.ine5605.telas.TelaTabelaItens;

public class ControladorFogueira {
    private TelaFogueiraSwing telaFogueiraS;
    private ArrayList<Consumivel> itens;
    private ArrayList<TipoEvento> eventos;
    private ArrayList<Feitico> feiticos;
    private static ControladorFogueira instance;
    private String nomeFeiticoNovo;
    
    private ControladorFogueira(){
        this.itens = ControladorPrincipal.getInstance().getJogador().getConsumiveisBolsa();
        this.eventos = ControladorPrincipal.getInstance().getJogador().getDiario().verEventos();
        this.feiticos = ControladorPrincipal.getInstance().getJogador().getFeiticos();
    }
    
    
    public void executaOpcao(String opcao){
        try{
            switch(opcao){
                case "0": telaFogueiraS.ocultaTela();
                          this.finalizaFogueira();
                        break;
                case "1": verDiario();
                        break;
                case "2": verItens();
                        break;
                case "3": mostraMenuDescartarItem(compactarItem());
                        break;
                case "4": mostraMenuVerFeiticos();
                        break;
                case "5": mostraMenuCriarFeitico();
                        break;
                case "6": this.mostraMenuEsquecerFeiticos(compactarFeitico());
                        break;
                case "7": if(ControladorPrincipal.getInstance().getJogador().getPossuiChave()){irParaBoss();}
                        break;
                default:
            }
        } catch(Exception e){
            System.out.println("ERROO");
            telaFogueiraS.mostraTela();
        }
    }
    
    public static ControladorFogueira getInstance(){
        if(instance == null){
            instance = new ControladorFogueira();
        }
        return instance;
    }
    
    public void iniciaEncontro(){
        ControladorPrincipal.getInstance().getJogador().setVidaAtual(ControladorPrincipal.getInstance().getJogador().getVidaTotal());
        telaFogueiraS = new TelaFogueiraSwing(compactaJogador());
        telaFogueiraS.mostraTela();
    }
    
    public void verDiario(){
        TelaListagemBasicaFogueira diario = new TelaListagemBasicaFogueira(compactarEvento());
        diario.mostraTela();
    }
    
    public void verItens(){
        TelaListagemBasicaFogueira itens = new TelaListagemBasicaFogueira(compactarItem(), true);
        itens.mostraTela();
    }
    
    public void mostraMenuCriarFeitico() {
         if(ControladorPrincipal.getInstance().getJogador().getGrimorios()>=1){
            TelaCriarFeitico telaCriarFeitico = new TelaCriarFeitico();
            telaCriarFeitico.mostraTela();
        } else {
             TelaCriarFeitico telaErro = new TelaCriarFeitico(false);
            telaErro.mostraTela();
        }
    }
    
    public void pegaNomeFeiticoNovo(String nome){
        this.nomeFeiticoNovo = nome;
        TelaCriarFeitico telaTipo = new TelaCriarFeitico("TIPO DO FEITICO NOVO");
        telaTipo.mostraTela();
    }
    
    public void criarFeitico( String tipo){
        if(ControladorPrincipal.getInstance().getJogador().getGrimorios()>=1){
            Feitico feitico;
            switch(tipo){
                case "1": feitico = new Feitico(ControladorPrincipal.getInstance().getJogador().getNivelInt(), nomeFeiticoNovo, TipoElemento.FOGO);
                        ControladorPrincipal.getInstance().getJogador().addFeitico(feitico);
                        break;
                case "2": feitico = new Feitico(ControladorPrincipal.getInstance().getJogador().getNivelInt(), nomeFeiticoNovo, TipoElemento.AGUA);
                        ControladorPrincipal.getInstance().getJogador().addFeitico(feitico);
                        break;
                case "3": feitico = new Feitico(ControladorPrincipal.getInstance().getJogador().getNivelInt(), nomeFeiticoNovo, TipoElemento.GRAMA);
                        ControladorPrincipal.getInstance().getJogador().addFeitico(feitico);
                        break;
                case "4": feitico = new Feitico(ControladorPrincipal.getInstance().getJogador().getNivelInt(), nomeFeiticoNovo, TipoElemento.PEDRA);
                        ControladorPrincipal.getInstance().getJogador().addFeitico(feitico);
                        break;
            }
                ControladorPrincipal.getInstance().getJogador().setGrimorios(ControladorPrincipal.getInstance().getJogador().getGrimorios()-1);
                TelaCriarFeitico telaAcerto = new TelaCriarFeitico(true);
                telaAcerto.mostraTela();
        }else{
            TelaCriarFeitico telaErro = new TelaCriarFeitico(false);
            telaErro.mostraTela();
        }
    }
    
    private void mostraMenuVerFeiticos() {
        TelaMenuFeiticosFogueira menuFeiticos = new TelaMenuFeiticosFogueira();
        menuFeiticos.mostraTela();
    }
    
    public void verFeiticos(String tipo){
        try{
            switch(tipo){
                case "1": TelaMenuFeiticosFogueira telaFogo = new TelaMenuFeiticosFogueira(TipoElemento.FOGO, compactarFeiticoPorTipo(TipoElemento.FOGO));
                        telaFogo.mostraTela();
                        break;
                case "2": TelaMenuFeiticosFogueira telaAgua = new TelaMenuFeiticosFogueira(TipoElemento.AGUA, compactarFeiticoPorTipo(TipoElemento.AGUA));
                        telaAgua.mostraTela();
                        break;
                case "3": TelaMenuFeiticosFogueira telaGrama = new TelaMenuFeiticosFogueira(TipoElemento.GRAMA, compactarFeiticoPorTipo(TipoElemento.GRAMA));
                        telaGrama.mostraTela();
                        break;
                case "4": TelaMenuFeiticosFogueira telaPedra = new TelaMenuFeiticosFogueira(TipoElemento.PEDRA, compactarFeiticoPorTipo(TipoElemento.PEDRA));
                        telaPedra.mostraTela();
                        break;
                default: 
            }
        } catch(Exception e){
            telaFogueiraS.mostraTela();
            System.out.println("ERROOOO");
        }
    }
    
    private void mostraMenuEsquecerFeiticos(ArrayList<ConteudoTelaFogueira> compactarFeitico) {

        TelaDeletarCoisasFogueira tabelaFeiticos = new TelaDeletarCoisasFogueira(compactarFeitico, "ESQUECER FEITIÇO");
        tabelaFeiticos.mostraTela();
    }
    
    public void esquecerFeitico(int escolha){
        ControladorPrincipal.getInstance().getJogador().delFeitico(escolha);
        TelaDeletarCoisasFogueira telaAviso = new TelaDeletarCoisasFogueira(true);
        telaAviso.mostraTela();

    }
    
    private void mostraMenuDescartarItem(ArrayList<ConteudoTelaFogueira> compactarItem) {
        TelaDeletarCoisasFogueira tabelaItem = new TelaDeletarCoisasFogueira(compactarItem);
        tabelaItem.mostraTela();
    }
    
    public void descartarItem(int escolha){
        ControladorPrincipal.getInstance().getJogador().dellConsumivelBolsa(escolha);
        TelaDeletarCoisasFogueira telaAviso = new TelaDeletarCoisasFogueira(false);
        telaAviso.mostraTela();

    }
    
    public void finalizaFogueira(){
        ControladorPrincipal.getInstance().getJogador().getDiario().addEvento(TipoEvento.FOGUEIRA);
        ControladorPrincipal.getInstance().escolheEncontro();
    }
    
    public void irParaBoss(){
        ControladorPrincipal.getInstance().irParaBoss();
    }
    
    public ConteudoTelaFogueira compactaJogador(){
        ConteudoTelaFogueira conteudo = new ConteudoTelaFogueira();
        conteudo.jogador = ControladorPrincipal.getInstance().getJogador();
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























