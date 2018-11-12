package br.ufsc.ine5605.telas;

import java.util.ArrayList;
import java.util.Scanner;
import br.ufsc.ine5605.controladores.ControladorBatalhaBoss;
import br.ufsc.ine5605.entidades.Jogador;

public class TelaBatalhaBoss {

    private ControladorBatalhaBoss controladorBatalhaBoss;
    private Scanner teclado;
    
    public TelaBatalhaBoss(ControladorBatalhaBoss controladorBatalhaBoss){
        this.teclado = new Scanner(System.in);
        this.controladorBatalhaBoss = controladorBatalhaBoss;
    }
    
    public void mostraMenuBatalha(){
        System.out.println("=============================");
        System.out.println("Qual a sua próxima ação?");
        System.out.println("1- Atacar Demogorgon (escolher feitiço)");
        System.out.println("2- Analizar Demogorgon");
        System.out.println("3- Ver Feitiços");
        System.out.println("4- Ver Itens");
        System.out.println("5- Usar Item");
        System.out.println("6- Meus Atributos");
        String opcaoString = teclado.nextLine();
        this.controladorBatalhaBoss.executaOpcao(opcaoString);
    }
    
    public void mostraAtaque(ConteudoTelaBatalha conteudoTelaAtaqueJogador, ConteudoTelaBatalha conteudoTelaAtaqueMonstro){
        System.out.println(conteudoTelaAtaqueJogador.atacante.getNome() + " ataca O Demogorgon com " + conteudoTelaAtaqueJogador.feitico.getNome());
        System.out.println("Dano causado: " + conteudoTelaAtaqueJogador.danoAtaque);
        System.out.println("A vida do Demogorgon é: " + conteudoTelaAtaqueJogador.atacado.getVidaAtual() + "/" + conteudoTelaAtaqueJogador.atacado.getVidaTotal());
        System.out.println("O Demogorgon ataca " + conteudoTelaAtaqueMonstro.atacado.getNome());
        System.out.println("Dano causado: " + conteudoTelaAtaqueMonstro.danoAtaque);
        System.out.println("A vida do " + conteudoTelaAtaqueMonstro.atacado.getNome() + " é: " + conteudoTelaAtaqueMonstro.atacado.getVidaAtual() + "/" + conteudoTelaAtaqueMonstro.atacado.getVidaTotal());
        if(conteudoTelaAtaqueMonstro.atacado.getVidaAtual()>0){
            this.mostraMenuBatalha();
        }else{
            this.controladorBatalhaBoss.gameOver();
        }  
    }
    
    public void mostraFimBatalha(ConteudoTelaBatalha conteudoTela){
        System.out.println("O herói defere um último feitiço matando de uma vez por todas o Demogorgon!");
        System.out.println("Dano causado: " + conteudoTela.danoAtaque);
        System.out.println("O poderoso Demogorgon, mostro que aterrorizou por décadas todo o reino, finalmente cai ao chão!");
        System.out.println("Por anos, historias serao contadas sobre os eventos que aqui aconteceram!!");
        System.out.println("");
        System.out.println("FIM...");
    }

    public void mostraAnalise(ConteudoTelaBatalha monstro){
        System.out.println("--ANÁLISE DO DEMOGORGON--");
        System.out.println("VIDA: " + monstro.monstro.getVidaAtual() + "/" +
                monstro.monstro.getVidaTotal());
        System.out.println("ELEMENTO: " + monstro.monstro.getTipoElemento());
        System.out.println("FORÇA: " + monstro.monstro.getForca());
        System.out.println("ESQUIVA: " + monstro.monstro.getEsquiva());
        this.mostraMenuBatalha();
    }

    public void mostraItens(ArrayList<ConteudoTelaBatalha> conteudoTelaS, ConteudoTelaBatalha conteudoTela){
        System.out.println("=============================");
        if(conteudoTelaS.size()>0){
            System.out.println("Os Consumíveis são:");
            for(int i = 0; i < conteudoTelaS.size(); i++){
                System.out.println("Índice:        " + i);
                System.out.println("Nome:          " + conteudoTelaS.get(i).consumivel.getNome());
            }
        }else{
            System.out.println("Você não possui consumiveis");
        }
        System.out.println("Sua arma é: ");
        System.out.println("Nome: " + conteudoTela.arma.getNome());
        System.out.println("Dano: +" + conteudoTela.arma.getDano());
        this.mostraMenuBatalha();
    }

    public void mostraFeiticos(ArrayList<ConteudoTelaBatalha> conteudoTelaS){
        System.out.println("=============================");
        if(conteudoTelaS.isEmpty()){
            System.out.println("Voce nao possui feiticos desse tipo");
            this.mostraMenuBatalha();
        }else{
            System.out.println("Os Feitiços são:");
            for(int i = 0; i < conteudoTelaS.size(); i++){
                //System.out.println("Índice:   " + conteudoTelaS.get(i).feitico.getIndice());!!!!
                System.out.println("Nome:   " + conteudoTelaS.get(i).feitico.getNome()
                                    + "Dano:   " + conteudoTelaS.get(i).feitico.getDano()
                                    + "Elemento:   " + conteudoTelaS.get(i).feitico.getTipoElemento());
            }
            this.mostraMenuBatalha();
        }
    }

    public void mostraMenuFeitico(){
        System.out.println("=============================");
        System.out.println("Escolha o tipo de feitico para ver:");
        System.out.println("1 - FOGO");
        System.out.println("2 - AGUA");
        System.out.println("3 - GRAMA");
        System.out.println("4 - PEDRA");
        String opcao = teclado.nextLine();
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.tipoString = opcao;
        this.controladorBatalhaBoss.verFeiticos(conteudoTela);
    }

    public void mostraMenuAtaque(ArrayList<ConteudoTelaBatalha> conteudoTelaS){
        System.out.println("=============================");
        System.out.println("Seus feiticos sao:");
        int i = 0;
        for(ConteudoTelaBatalha conteudoTela: conteudoTelaS){
            System.out.println("indice " + i + ": " + conteudoTela.feitico.getNome() + ", tipo:  " + conteudoTela.feitico.getTipoElemento() + ", dano:  +" + conteudoTela.feitico.getDano());
            i++;
        }
        System.out.println("");
        System.out.println("Qual feitiço gostaria de usar?");
        System.out.println("(digite o indice do feitiço)");
        String indiceFeiticoString = teclado.nextLine();
        if(this.controladorBatalhaBoss.indiceFeiticoValido(indiceFeiticoString)){
            int indiceFeiticoInt = Integer.parseInt(indiceFeiticoString);
            ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
            conteudoTela.indiceFeitico = indiceFeiticoInt;
            this.controladorBatalhaBoss.atacar(conteudoTela);
        }else{
            System.out.println("Numero invalido, tente novamente...");
            this.mostraMenuAtaque(conteudoTelaS);
        }
    }
    
    public void mostraMenuItens(ArrayList<ConteudoTelaBatalha> conteudoTelaS){
        System.out.println("=============================");
        if(conteudoTelaS.isEmpty()){
            System.out.println("Você não possui itens");
            this.mostraMenuBatalha();
        } else {
            System.out.println("Seus itens são: ");
            int contador = 0;
            for(ConteudoTelaBatalha conteudoTela: conteudoTelaS){
                System.out.println(contador + "- " + conteudoTela.consumivel.getNome());
                contador++;
            }
            System.out.println("Qual item gostaria de usar?");
            System.out.println("(digite o indice do item)");
            String indiceItemString = teclado.nextLine();
            int indiceItemInt = Integer.parseInt(indiceItemString);
            ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
            conteudoTela.indiceItem = indiceItemInt;
            this.controladorBatalhaBoss.usarItem(indiceItemInt);
        }
    }
    
    public void mostraMeusAtributos(Jogador jogador){
        System.out.println("--ATRIBUTOS DO JOGADOR--");
        System.out.println("NIVEL: " + jogador.getNivelInt());
        System.out.println("VIDA: " + jogador.getVidaAtual() + "/" + jogador.getVidaTotal());
        System.out.println("ESQUIVA: " + jogador.getEsquiva() + "%");
        this.mostraMenuBatalha();
    }

    public void mostraInicioBatalha() {
        System.out.println("");
        System.out.println("Você entra numa sala enorme de odor fetido...");
        System.out.println("Ja sabe o que lhe espera, mas entra mais afundo na sala quando...");
        System.out.println("Um DEMOGORGON do tamanho de cinco homens aparece na sua frente!!");
        System.out.println("Imediatamente você pega seu cajado e se prepara para a batalha!");
        this.mostraMenuBatalha();
    }

    public void mostraOpcaoInvalida() {
        System.out.println("");
        System.out.println("Opcao invalida, tente novamente");
        System.out.println("");
        this.mostraMenuBatalha();
    }

    public void mostraExcecao(String message) {
        System.out.println(message);
    }
}
