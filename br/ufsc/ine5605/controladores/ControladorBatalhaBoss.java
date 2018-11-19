package br.ufsc.ine5605.controladores;

import br.ufsc.ine5605.telas.TelaBatalhaBoss;
import java.util.ArrayList;
import br.ufsc.ine5605.entidades.Arma;
import br.ufsc.ine5605.entidades.Consumivel;
import br.ufsc.ine5605.telas.ConteudoTelaBatalha;
import br.ufsc.ine5605.entidades.Feitico;
import br.ufsc.ine5605.entidades.Monstro;
import br.ufsc.ine5605.entidades.Ser;
import br.ufsc.ine5605.entidades.TipoElemento;
import br.ufsc.ine5605.entidades.Jogador;
import br.ufsc.ine5605.telas.TelaInicioBatalhaBoss;

public class ControladorBatalhaBoss {
    
    private Monstro monstro;
    private TelaBatalhaBoss telaBatalha;
    private static ControladorBatalhaBoss instancia;

    private ControladorBatalhaBoss(){
        this.telaBatalha = new TelaBatalhaBoss();
        this.monstro = new Monstro(10, TipoElemento.PEDRA);
    }
    
    public static ControladorBatalhaBoss getInstance(){
        if(instancia == null){
            instancia = new ControladorBatalhaBoss();
        }
        return instancia;
    }
    
    public void atacar(ConteudoTelaBatalha conteudoTela){
        ConteudoTelaBatalha conteudoTelaAtaqueJogador = new ConteudoTelaBatalha();
        Feitico feitico = ControladorPrincipal.getInstance().getJogador().getFeitico(conteudoTela.indiceFeitico);

        conteudoTelaAtaqueJogador.feitico = feitico;
        int danoDoJogador = feitico.getDano();
        danoDoJogador += ControladorPrincipal.getInstance().getJogador().getArma().getDano();
        TipoElemento elementoFeitico = feitico.getTipoElemento();
        TipoElemento elementoMonstro = this.monstro.getTipoElemento();
        if(!(elementoMonstro.equals(elementoFeitico))){
            if(elementoMonstro.equals(TipoElemento.PEDRA)){
                
            }else if((elementoMonstro.equals(TipoElemento.FOGO) && elementoFeitico.equals(TipoElemento.AGUA)) || (elementoMonstro.equals(TipoElemento.AGUA) && elementoFeitico.equals(TipoElemento.GRAMA)) || (elementoMonstro.equals(TipoElemento.GRAMA) && elementoFeitico.equals(TipoElemento.FOGO))){
                danoDoJogador = (int)(danoDoJogador*1.15);
            }else{
                danoDoJogador = (int)(danoDoJogador*0.85);
            }
        }
        conteudoTelaAtaqueJogador.danoAtaque = danoDoJogador;
        conteudoTelaAtaqueJogador.atacante = ControladorPrincipal.getInstance().getJogador();
        conteudoTelaAtaqueJogador.atacado = this.monstro;
        this.monstro.setVidaAtual(this.monstro.getVidaAtual()-danoDoJogador);
        if(this.monstro.getVidaAtual()<=0){
            this.finalizaBatalha(conteudoTelaAtaqueJogador);
        }else{
            ConteudoTelaBatalha conteudoTelaAtaqueMonstro = new ConteudoTelaBatalha();
            int danoDoMonstro = this.monstro.getForca();
            conteudoTelaAtaqueMonstro.danoAtaque = danoDoMonstro;
            conteudoTelaAtaqueMonstro.atacado = ControladorPrincipal.getInstance().getJogador();
            conteudoTelaAtaqueMonstro.atacante = this.monstro;
            ControladorPrincipal.getInstance().getJogador().setVidaAtual(ControladorPrincipal.getInstance().getJogador().getVidaAtual()-danoDoMonstro);
            this.atualizaDadosTela();
            this.telaBatalha.mostraAtaque(conteudoTelaAtaqueJogador, conteudoTelaAtaqueMonstro);
        }
    }
    
    public void finalizaBatalha(ConteudoTelaBatalha conteudoTelaAtaqueJogador) {
        this.telaBatalha.mostraFimBatalha(conteudoTelaAtaqueJogador);
    }

    public void analisarMonstro() {
        ConteudoTelaBatalha conteudoTela = compactar(this.monstro);
        this.telaBatalha.mostraAnalise(conteudoTela);
    }

    public void verFeiticos(ConteudoTelaBatalha conteudoTela){
        try{
            TipoElemento tipoElemento;
            switch(conteudoTela.tipoString){
                case "1" :
                    tipoElemento = TipoElemento.FOGO;
                    break;
                case "2" :
                    tipoElemento = TipoElemento.AGUA;
                    break;
                case "3" :
                    tipoElemento = TipoElemento.GRAMA;
                    break;
                case "4" :
                    tipoElemento = TipoElemento.PEDRA;
                    break;
                default :
                    tipoElemento = TipoElemento.PEDRA;
            }
            ArrayList<Feitico> feiticos = ControladorPrincipal.getInstance().getJogador().verFeiticos(tipoElemento);
            ArrayList<ConteudoTelaBatalha> conteudoTelaS = this.compactar(feiticos);
            telaBatalha.mostraFeiticos(conteudoTelaS);
        }catch(Exception e){
            telaBatalha.mostraTela();
        }
    }

    public void executaOpcao(String opcao){
        try{
            switch(opcao){
                case "1" :
                    this.telaBatalha.mostraMenuAtaque(compactar(ControladorPrincipal.getInstance().getJogador().getFeiticos()));
                    break;
                case "2" :
                    this.analisarMonstro();
                    break;
                case "3" :
                    this.telaBatalha.mostraMenuFeitico();
                    break;
                case "4" :
                    break;
                case "5" :
                    this.telaBatalha.mostraMenuItens(compactar(ControladorPrincipal.getInstance().getJogador().getConsumiveisBolsa(),1));
                    break;
                case "6" :
                    this.verMeusAtributos();
                    break;
                default:
            }
        }catch(Exception e){
            this.telaBatalha.mostraTela();
        }
    }
    
    public void iniciaEncontro() {
        TelaInicioBatalhaBoss tela = new TelaInicioBatalhaBoss();
        this.atualizaDadosTela();
        tela.mostraTela();
    }
    
    public void irParaTelaBatalha(){
        this.telaBatalha.mostraTela();
    }

    public ConteudoTelaBatalha compactar(Ser atacado, Ser atacante, int danoAtaque) {
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.atacado = atacado;
        conteudoTela.atacante = atacante;
        return conteudoTela;
    }

    public ConteudoTelaBatalha compactar(Consumivel consumivel) {
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.consumivel = consumivel;
        return conteudoTela;
    }
    
    public ConteudoTelaBatalha compactar(Arma arma) {
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.arma = arma;
        return conteudoTela;
    }
    
    public ConteudoTelaBatalha compactar(Monstro monstro) {
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.monstro = monstro;
        return conteudoTela;
    }
    
    public void usarItem(int indice){
        try{
            if(indice < ControladorPrincipal.getInstance().getJogador().getConsumiveisBolsa().size()){
                ControladorPrincipal.getInstance().getJogador().usarItem(indice);
                this.atualizaDadosTela();
                this.telaBatalha.mostraTela();
            }else{
            }
        }catch(Exception e){
            this.telaBatalha.mostraTela();
        }
    }
    
    public void verMeusAtributos(){
        Jogador jogador = ControladorPrincipal.getInstance().getJogador();
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.jogador = jogador;
        this.telaBatalha.mostraMeusAtributos(jogador);
    }

    public void gameOver() {
        ControladorPrincipal.getInstance().gameOver();
    }
    
    private ArrayList<ConteudoTelaBatalha> compactar(ArrayList<Feitico> feiticos) {
        ArrayList<ConteudoTelaBatalha> conteudoTelaS = new ArrayList();
        for(Feitico feitico : feiticos){
            ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
            conteudoTela.feitico = feitico;
            conteudoTelaS.add(conteudoTela);
        }
        return conteudoTelaS;
    }
    
    private ArrayList<ConteudoTelaBatalha> compactar(ArrayList<Consumivel> consumiveis, int i) {
        ArrayList<ConteudoTelaBatalha> conteudoTelaS = new ArrayList();
        for(Consumivel consumivel : consumiveis){
            ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
            conteudoTela.consumivel = consumivel;
            conteudoTelaS.add(conteudoTela);
        }
        return conteudoTelaS;
    }
    
    public boolean indiceFeiticoValido(String indiceFeiticoString) {
        boolean indiceValido = false;
        Integer cont = 0;
        for(Feitico feitico : ControladorPrincipal.getInstance().getJogador().getFeiticos()){
            String contString = Integer.toString(cont);
            if(indiceFeiticoString.equals(contString)){
                indiceValido = true;
                break;
            }
            cont++;
        }
        if(indiceValido){
            int indiceFeiticoInt = Integer.parseInt(indiceFeiticoString);
            if(indiceFeiticoInt >= 0 && indiceFeiticoInt < ControladorPrincipal.getInstance().getJogador().getFeiticos().size()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    public void atualizaDadosTela(){
        if(ControladorPrincipal.getInstance().getJogador() != null){
            ConteudoTelaBatalha dadosTelaCompactados = new ConteudoTelaBatalha();
            dadosTelaCompactados.jogador = ControladorPrincipal.getInstance().getJogador();
            dadosTelaCompactados.monstro = this.monstro;
            this.telaBatalha.atualizaDados(dadosTelaCompactados);
        }
    }
    
}
