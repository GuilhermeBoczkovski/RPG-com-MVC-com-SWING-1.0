package rpgcommvccomswing;
import java.util.ArrayList;
import java.util.Scanner;

public class TelaFogueira extends TelaEncontro{
    private ControladorFogueira ctrlFogueira;
    private Scanner input = new Scanner(System.in);
    
    public TelaFogueira(ControladorFogueira ctrlFogueira){
        super("");
        this.ctrlFogueira = ctrlFogueira;
    }
    
    public void mostraMenuFogueira(){
        System.out.println("=======================");
        System.out.println("O que quer fazer?");
        System.out.println("0 - sair");
        System.out.println("1 - ver Diario");
        System.out.println("2 - ver itens");
        System.out.println("3 - descartar itens");
        System.out.println("4 - ver feiticos");
        System.out.println("5 - criar feitico");
        System.out.println("6 - esquecer feitico");
        if(ctrlFogueira.compactaJogador().jogador.getPossuiChave()){
            System.out.println("7 - ir para a sala do boss");
        }
        String opcao = input.nextLine();
        ctrlFogueira.executaOpcao(opcao);
    }
    
    public void mostraInicioFogueira(){
        System.out.println("Voce encontrou uma fogueira...");
        System.out.println("voce se sente regenerado...");
        System.out.println("Jogador: " + ctrlFogueira.compactaJogador().jogador.getNome() + " || Nivel: " + ctrlFogueira.compactaJogador().jogador.getNivelInt());
        System.out.println("dano da arma: " + ctrlFogueira.compactaJogador().jogador.getArma().getDano());
        System.out.println("vida: " + ctrlFogueira.compactaJogador().jogador.getVidaTotal());
        int grimorios = ctrlFogueira.compactaJogador().jogador.getGrimorios();
        switch (grimorios) {
            case 0:
                System.out.println("Voce nao possui grimorios no momento.");
                break;
            case 1:
                System.out.println("Voce possui 1 grimorio.");
                break;
            default:
                System.out.println("Voce possui " + grimorios + " grimorios.");
                break;
        }
    }
    
    public void mostraDiario(ArrayList<ConteudoTelaFogueira> eventos){
        if(eventos.isEmpty()){
            System.out.println("=======================");
            System.out.println("");
            System.out.println("Seu diario esta em branco...");
            System.out.println("");
        } else {
            System.out.println("=========================");
            int contador = 0;
            for(ConteudoTelaFogueira conteudo: eventos){
                System.out.println("Evento " + contador + ": " + conteudo.evento);
                contador++;
            }
            System.out.println("");
        }
    }
    
    public void mostraItens(ArrayList<ConteudoTelaFogueira> itens){
        if(itens.isEmpty()){
            System.out.println("========================");
            System.out.println("");
            System.out.println("Sua bolsa esta vazia...");
            System.out.println("");
        } else {
            System.out.println("=========================");
            int contador = 0;
            for(ConteudoTelaFogueira conteudo: itens){
                System.out.println(contador + "- " + conteudo.item.getNome());
                contador++;
            }
        }
    }
    
    public void mostraMenuVerFeiticos(){
        System.out.println("Escolha o tipo de feitico para ver:");
        System.out.println("1 - FOGO");
        System.out.println("2 - AGUA");
        System.out.println("3 - GRAMA");
        System.out.println("4 - PEDRA");
        String escolha = input.nextLine();
        ctrlFogueira.verFeiticos(escolha);
    }
    
    public void mostraFeiticos(ArrayList<ConteudoTelaFogueira> feiticos){
        if(feiticos.isEmpty()){
            System.out.println("=========================");
            System.out.println("");
            System.out.println("Voce nao possui feiticos desse tipo...");
            System.out.println("");
        } else {
            System.out.println("=========================");
            int contador = 0;
            for(ConteudoTelaFogueira conteudo: feiticos){
                System.out.println(contador + "- " + conteudo.feitico.getNome() + ", tipo:  " + conteudo.feitico.getTipoElemento() + ", dano: " + conteudo.feitico.getDano());
                contador++;
            }
        }
    }
    
    public void mostraMenuEsquecerFeiticos(ArrayList<ConteudoTelaFogueira> feiticos){
        if(feiticos.size()<=1){
            System.out.println("=========================");
            System.out.println("");
            System.out.println("Voce nao pode esquecer seu unico feitico...");
            System.out.println("");
            mostraMenuFogueira();
        } else {
            System.out.println("=========================");      
            int contador = 0;
            for(ConteudoTelaFogueira conteudo: feiticos){
                System.out.println("indice " + contador + ": " + conteudo.feitico.getNome() + ", tipo:  " + conteudo.feitico.getTipoElemento() + ", Dano:  " + conteudo.feitico.getDano());
                contador++;
            }
            System.out.println("");
            int retorno = contador++;
            String retornoString = Integer.toString(retorno);
            System.out.println("Escolha o indice do feitico para esquecer, digite " + retorno + " para retornar ao menu");
            String escolhaString = input.nextLine();
            
            int contadorEscolha = 0;
            boolean numeroCorreto = false;
            for(ConteudoTelaFogueira conteudo: feiticos){
                String verificacao = Integer.toString(contadorEscolha);
                if(verificacao.equals(escolhaString)){
                    numeroCorreto = true;
                    break;
                }
                contadorEscolha++;
            }
            if(numeroCorreto){
                ctrlFogueira.esquecerFeitico(escolhaString);
                System.out.println("Feitiço esquecido!");
                System.out.println("");
                mostraMenuFogueira();
            } else {
                System.out.println("Entrada invalida, tente denovo");
                System.out.println("");
                mostraMenuEsquecerFeiticos(feiticos);
            }
        }
    }
    
    public void mostraMenuDescartarItem(ArrayList<ConteudoTelaFogueira> itens){
        if(itens.isEmpty()){
            System.out.println("=========================");
            System.out.println("");
            System.out.println("Sua bolsa esta vazia...");
            System.out.println("");
            mostraMenuFogueira();
                    
        } else {
            System.out.println("=========================");      
            int contador = 0;
            for(ConteudoTelaFogueira conteudo: itens){
                System.out.println("indice " + contador + ": " + conteudo.item.getNome());
                contador++;
            }
            System.out.println("=========================");
            int retorno = contador++;
            System.out.println("Escolha o indice do item para descartar, selecione " + retorno + " para retornar ao menu");
            int escolha = input.nextInt();
            input.nextLine();
            if(escolha == retorno){
                mostraMenuFogueira();
            } else if(escolha > retorno){
                System.out.println("O indice escolhido nao existe, tente denovo!");
                mostraMenuDescartarItem(itens);
            }else {
                ctrlFogueira.descartarItem(escolha);
                System.out.println("item descartado...");
                mostraMenuFogueira();
            }
        }
        
    }
    
    public void mostraFimFogueira(){
        System.out.println("=========================");
        System.out.println("Deseja mesmo sair?");
        System.out.println("1 - SIM");
        System.out.println("2 - NAO");
        System.out.println("");
        String escolha = input.nextLine();
       
        switch(escolha){
            case "1" : System.out.println("Voce pega suas coisas e continua seu caminho...");
                     System.out.println("=========================");
                     ctrlFogueira.finalizaFogueira();
                     break;
            case "2" : mostraMenuFogueira();
                     break;
            default: System.out.println("Numero invalido, tente denovo");
                     mostraFimFogueira();
        }
        
    }
    
    public void mostraMenuCriarFeitico(){
        if(ctrlFogueira.compactaJogador().jogador.getGrimorios() > 0){
            System.out.print("Entre o nome do novo feitico: ");
            String nome = input.nextLine();
            System.out.println("Escolha o tipo do feitico");
            System.out.println("1 - FOGO");
            System.out.println("2 - AGUA");
            System.out.println("3 - GRAMA");
            System.out.println("4 - PEDRA");
            String tipo = input.nextLine();
            if(tipo.equals("1") || tipo.equals("2") || tipo.equals("3") || tipo.equals("4")){
                ctrlFogueira.criarFeitico(nome, tipo);
            } else {
                System.out.println("Numero invalido, tente denovo...");
                mostraMenuCriarFeitico();
            }
        } else {
            mostraErroCriarFeitico();
        }
    }
    
    public void mostraErroCriarFeitico(){
        System.out.println("=========================");
        System.out.println("");
        System.out.println("Voce nao possui um grimorio para criar um novo feitico");
        System.out.println("");
        mostraMenuFogueira();
    }
    
    public void mostraCriarFeitico(){
        System.out.println("===========================");
        System.out.println("");
        System.out.println("Feitico criado com sucesso!");
        System.out.println("                           ");
        mostraMenuFogueira();
    }

    void mostraException(String message) {
        System.out.println(message);
    }
}
