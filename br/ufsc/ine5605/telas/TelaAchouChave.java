package br.ufsc.ine5605.telas;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaAchouChave extends JFrame{
    
    private JLabel lb1;
    private JLabel lb2;
    private JLabel lb3;
    private JButton bt;
    
    
    public TelaAchouChave(){
        super("PARABÉNS!!!");
        setVisible(true);
        setSize(500,300);

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.ipadx = 20;
        
        lb1 = new JLabel();
        lb1.setText("Voce encontrou a chave para batalhar com o boss final!!");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lb1, c);
        
        lb2 = new JLabel();
        lb2.setText("A próxima vez que encontrar uma fogueira poderá escolher enfrenta-lo");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        container.add(lb2, c);
        
        lb3 = new JLabel();
        lb3.setText("CUIDADO!! Lembre-se que ele eh nivel 10!");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        container.add(lb3, c);
        
        bt = new JButton();
        bt.setText("OK");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        container.add(bt, c);
        
        TelaAchouChave.GerenciadorDeBotoes btManager = new TelaAchouChave.GerenciadorDeBotoes();
        bt.addActionListener(btManager);
    }
    
    public void mostraTela() {
        setVisible(true);
    }

    public void ocultaTela() {
        setVisible(false);
    }
    
    private class GerenciadorDeBotoes implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            ocultaTela();
        }
        
    }
    
}
