package br.ufsc.ine5605.telas;

import javax.swing.JFrame;

public abstract class TelaEncontro  extends JFrame{
    
    public TelaEncontro(String titulo){
        super(titulo);
    }

    public void mostraTela(){
        super.setVisible(true);
    }
    
    public void ocultaTela(){
        super.setVisible(false);
    }
    
}
