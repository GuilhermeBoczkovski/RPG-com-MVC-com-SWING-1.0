package br.ufsc.ine5605.telas;

import java.util.Scanner;
import br.ufsc.ine5605.controladores.ControladorPrincipal;

public class TelaFim {

    private Scanner teclado;
    private ControladorPrincipal controladorPrincipal;
    
    public TelaFim(ControladorPrincipal controladorPrincipal){
        //this.teclado = new Scanner(System.in);
        this.controladorPrincipal = controladorPrincipal;
    }
    
    public void mostraTelaFim(){
        System.out.println("O seu herói não foi páreo para os poderosos monstros"
                + " que habitam a masmorra!");
        //System.out.println("Deseja tentar novamente ?");
        //System.out.println("1- TENTAR NOVAMENTE");
        //System.out.println("2- SAIR DO JOGO");
        //int opcao = this.teclado.nextInt();
    }
    
}
