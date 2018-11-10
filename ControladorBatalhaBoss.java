package rpgcommvccomswing;

import java.util.ArrayList;

class ControladorBatalhaBoss {

    private ControladorPrincipal controladorPrincipal;
    private Monstro monstro;
    private TelaBatalhaBoss telaBatalha;

    public ControladorBatalhaBoss(ControladorPrincipal controladorPrincipal){
        this.telaBatalha = new TelaBatalhaBoss(this);
        this.controladorPrincipal = controladorPrincipal;
        TipoElemento tipoElemento = TipoElemento.PEDRA;
        this.monstro = new Monstro(10, tipoElemento);
    }
    
    public void atacar(ConteudoTelaBatalha conteudoTela){

        ConteudoTelaBatalha conteudoTelaAtaqueJogador = new ConteudoTelaBatalha();
        Feitico feitico = this.controladorPrincipal.getJogador().getFeitico(conteudoTelaAtaqueJogador.indiceFeitico);

        conteudoTelaAtaqueJogador.feitico = feitico;
        int danoDoJogador = feitico.getDano();
        danoDoJogador += this.controladorPrincipal.getJogador().getArma().getDano();
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
        conteudoTelaAtaqueJogador.atacante = this.controladorPrincipal.getJogador();
        conteudoTelaAtaqueJogador.atacado = this.monstro;
        this.monstro.setVidaAtual(this.monstro.getVidaAtual()-danoDoJogador);
        if(this.monstro.getVidaAtual()<=0){
            this.finalizaBatalha(conteudoTelaAtaqueJogador);
        }else{
            ConteudoTelaBatalha conteudoTelaAtaqueMonstro = new ConteudoTelaBatalha();
            int danoDoMonstro = this.monstro.getForca();
            conteudoTelaAtaqueMonstro.danoAtaque = danoDoMonstro;
            conteudoTelaAtaqueMonstro.atacado = this.controladorPrincipal.getJogador();
            conteudoTelaAtaqueMonstro.atacante = this.monstro;
            this.controladorPrincipal.getJogador().setVidaAtual(this.controladorPrincipal.getJogador().getVidaAtual()-danoDoMonstro);
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

    public void verItens(){
        Arma arma = this.controladorPrincipal.getJogador().getArma();
        ArrayList<Consumivel> consumiveis = this.controladorPrincipal.getJogador().getConsumiveisBolsa();
        ArrayList<ConteudoTelaBatalha> conteudoTelaS = new ArrayList();
        for(int i = 0; i < consumiveis.size(); i++){
            conteudoTelaS.add(compactar(consumiveis.get(i)));
        }
        ConteudoTelaBatalha conteudoTela = compactar(arma);
        this.telaBatalha.mostraItens(conteudoTelaS, conteudoTela);
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
                    throw new NumeroInvalidoException();
            }
            ArrayList<Feitico> feiticos = this.controladorPrincipal.getJogador().verFeiticos(tipoElemento);
            ArrayList<ConteudoTelaBatalha> conteudoTelaS = this.compactar(feiticos);
            telaBatalha.mostraFeiticos(conteudoTelaS);
        }catch(NumeroInvalidoException e){
            this.telaBatalha.mostraExcecao(e.getMessage());
            telaBatalha.mostraMenuBatalha();
        }
    }

    public void executaOpcao(String opcao){
        try{
            switch(opcao){
                case "1" :
                    this.telaBatalha.mostraMenuAtaque(compactar(this.controladorPrincipal.getJogador().getFeiticos()));
                    break;
                case "2" :
                    this.analisarMonstro();
                    break;
                case "3" :
                    this.telaBatalha.mostraMenuFeitico();
                    break;
                case "4" :
                    this.verItens();
                    break;
                case "5" :
                    this.telaBatalha.mostraMenuItens(compactar(this.controladorPrincipal.getJogador().getConsumiveisBolsa(),1));
                    break;
                case "6" :
                    this.verMeusAtributos();
                    break;
                default:
                    throw new NumeroInvalidoException();
            }
        }catch(NumeroInvalidoException e){
            this.telaBatalha.mostraExcecao(e.getMessage());
            this.telaBatalha.mostraMenuBatalha();
        }
    }
    
    public void iniciaEncontro() {
        this.telaBatalha.mostraInicioBatalha();
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
            if(indice < this.controladorPrincipal.getJogador().getConsumiveisBolsa().size()){
                this.controladorPrincipal.getJogador().usarItem(indice);
                this.telaBatalha.mostraMenuBatalha();
            }else{
                throw new NumeroInvalidoException();
            }
        }catch(NumeroInvalidoException e){
            this.telaBatalha.mostraExcecao(e.getMessage());
            this.telaBatalha.mostraMenuBatalha();
        }
    }
    
    public void verMeusAtributos(){
        Jogador jogador = this.controladorPrincipal.getJogador();
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.jogador = jogador;
        this.telaBatalha.mostraMeusAtributos(jogador);
    }

    public void gameOver() {
        this.controladorPrincipal.gameOver();
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
        for(Feitico feitico : this.controladorPrincipal.getJogador().getFeiticos()){
            String contString = Integer.toString(cont);
            if(indiceFeiticoString.equals(contString)){
                indiceValido = true;
                break;
            }
            cont++;
        }
        if(indiceValido){
            int indiceFeiticoInt = Integer.parseInt(indiceFeiticoString);
            if(indiceFeiticoInt >= 0 && indiceFeiticoInt < this.controladorPrincipal.getJogador().getFeiticos().size()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
}
