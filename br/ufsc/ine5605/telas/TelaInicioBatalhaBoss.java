package br.ufsc.ine5605.telas;

import br.ufsc.ine5605.controladores.ControladorBatalhaBoss;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaInicioBatalhaBoss extends JFrame{
    
    private JLabel lb1;
    private JLabel lb2;
    private JLabel lb3;
    private JLabel lb4;
    private JButton bt;
    private boolean continuar;
    
    public TelaInicioBatalhaBoss(){
        super("NEW GAME");
        
        setSize(1024,384);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        lb1 = new JLabel();
        lb1.setText("Você entra numa sala enorme de odor fetido...");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lb1, c);
        
        lb1 = new JLabel();
        lb1.setText("Ja sabe o que lhe espera, entao entra mais afundo na sala quando...");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        container.add(lb1, c);
        
        lb1 = new JLabel();
        lb1.setText("Um DEMOGORGON do tamanho de cinco homens aparece na sua frente!!");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        container.add(lb1, c);
        
        
        lb1 = new JLabel();
        lb1.setText("Imediatamente você pega seu cajado e se prepara para a batalha!!");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        container.add(lb1, c);
        
        bt = new JButton();
        bt.setText("ESTOU PREPARADO");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 4;
        container.add(bt, c);
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        bt.addActionListener(btManager);
        
        
    }
    
    public void mostraTela(){
        setVisible(true);
    }
    
    public void ocultaTela(){
        setVisible(false);
    }
    
    public boolean getContinuar(){
        return this.continuar;
    }
    
    private class GerenciadorDeBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ocultaTela();
            ControladorBatalhaBoss.getInstance().irParaTelaBatalha();
        }
        
    }
}
