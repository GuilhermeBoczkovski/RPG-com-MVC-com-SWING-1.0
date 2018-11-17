package br.ufsc.ine5605.controladores;
import br.ufsc.ine5605.telas.TelaFim;
import java.util.Random;
import br.ufsc.ine5605.controladores.ControladorBau;
import br.ufsc.ine5605.entidades.Jogador;
import br.ufsc.ine5605.mapeadores.MapeadorJogador;

public class ControladorPrincipal {
    
    private Jogador jogador;
    private ControladorBatalhaBoss ctrlBatBoss;
    private TelaFim telaFim;
    private int teste;
    private MapeadorJogador mapJog;
    private static ControladorPrincipal instancia;
    
    public static void getInstance(String nome, boolean novoJogo) {
        if(instancia == null && novoJogo){
            instancia = new ControladorPrincipal(nome, 1);
        }else if(instancia == null){
            instancia = new ControladorPrincipal(nome);
        }
    }
    
    public static ControladorPrincipal getInstance(){
        return instancia;
    }
    
    private ControladorPrincipal(String nome, int i){
        criaJogador(nome, 10);
        mapJog = new MapeadorJogador();
        mapJog.put(this.jogador); 
        ctrlBatBoss = new ControladorBatalhaBoss(this);
        telaFim = new TelaFim(this);
        this.teste = 0;
    }

    private ControladorPrincipal(String nome){
        mapJog = new MapeadorJogador();
        jogador = mapJog.get(nome);
    }
    
    Jogador getJogador() {
        return this.jogador;
    }

    public void escolheEncontro(){
        /*VERSAO TESTE*/
        switch(this.teste){
            case 0:
                    this.teste++;
                    ControladorBau.getInstance().iniciaEncontro();
                    break;
            case 1: 
                    this.teste++;
                    ControladorFogueira.getInstance().iniciaEncontro();
                    break;
            case 2: 
                    this.teste++;
                    ControladorBatalha.getInstance().iniciaEncontro();
                    break;
            case 3: 
                    this.teste++;
                    ControladorFogueira.getInstance().iniciaEncontro();
                    break;
        }
        /*
        VERSÃO RANDOMICA
        Random rand = new Random();
        int escolha = rand.nextInt(3);
        switch(escolha){
            case 0:
                    ctrlBatalha.iniciaEncontro();
                    break;
            case 1: 
                    ctrlFogueira.iniciaEncontro();
                    break;
            case 2: 
                    ctrlBau.iniciaEncontro();
                    break;
        }
        */
    }

    public void irParaBoss() {
        ctrlBatBoss.iniciaEncontro();
    }
    
    public void gameOver(){
        telaFim.mostraTelaFim();
    }
    
    public void criaJogador(String nome){
        Jogador jogador = new Jogador(nome);
        this.jogador = jogador;
    }
    
    public void criaJogador(String nome, int nivel){
        Jogador jogador = new Jogador(nivel, nome);
        this.jogador = jogador;
    }
}
