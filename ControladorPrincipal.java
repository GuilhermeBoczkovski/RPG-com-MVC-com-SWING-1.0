package rpgcommvccomswing;
import java.util.Random;
import rpgcommvccomswing.ControladorBau;

public class ControladorPrincipal {
    
    private Jogador jogador;
    private ControladorBatalha ctrlBatalha;
    private ControladorFogueira ctrlFogueira;
    private ControladorBau ctrlBau;
    private ControladorBatalhaBoss ctrlBatBoss;
    private TelaFim telaFim;
    private int teste;
    private MapeadorJogador mapJog;
    
    public ControladorPrincipal(String nome, int i){
        criaJogador(nome, 10);
        mapJog = new MapeadorJogador();
        mapJog.put(this.jogador);
        ctrlBatalha = new ControladorBatalha(this); 
        ctrlFogueira = new ControladorFogueira(this);
        ctrlBau = new ControladorBau(this);
        ctrlBatBoss = new ControladorBatalhaBoss(this);
        telaFim = new TelaFim(this);
        this.teste = 0;
    }

    public ControladorPrincipal(String nome){
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
                    ctrlBau.iniciaEncontro();
                    break;
            case 1: 
                    this.teste++;
                    ctrlFogueira.iniciaEncontro();
                    break;
            case 2: 
                    this.teste++;
                    ctrlBatalha.iniciaEncontro();
                    break;
            case 3: 
                    this.teste++;
                    ctrlFogueira.iniciaEncontro();
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
