package br.ufsc.ine5605.telas;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import br.ufsc.ine5605.controladores.ControladorGeral;

public class TelaMenuInicial extends JFrame{
    
    private final ControladorGeral controladorGeral;
    
    private JButton btNewGame;
    private JButton btContinue;
    
    public TelaMenuInicial(ControladorGeral controladorGeral){
        super("Role Playing Game");
        
        this.controladorGeral = controladorGeral;
        
        setSize(1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        btNewGame = new JButton();
        btNewGame.setText("NEW GAME");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        container.add(btNewGame, c);
        
        btContinue = new JButton();
        btContinue.setText("CONTINUE");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        container.add(btContinue, c);
        
        TelaMenuInicial.GerenciadorDeBotoes btManager = new TelaMenuInicial.GerenciadorDeBotoes();
        btNewGame.addActionListener(btManager);
        btContinue.addActionListener(btManager);
    }
    
    public void mostraTelaMenuInicial(){
        setVisible(true);
    }
    
    public void ocultaTelaMenuInicial(){
        setVisible(false);
    }
    
    private class GerenciadorDeBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btNewGame){
                ocultaTelaMenuInicial();
                controladorGeral.inicio();
            }else if(e.getSource() == btContinue){
                ocultaTelaMenuInicial();
                
            }
        }
        
    }
    
    //new game ou continue
    //new game -> 
    //continue ->
    
}
