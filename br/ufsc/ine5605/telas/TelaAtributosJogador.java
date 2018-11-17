package br.ufsc.ine5605.telas;

import br.ufsc.ine5605.entidades.Jogador;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class TelaAtributosJogador extends JFrame{
    
    private JLabel lb1;
    private JLabel lb2;
    private JLabel lb3;
    private JLabel lb4;
    private JButton bt;
    
    public TelaAtributosJogador(Jogador jogador) {
        super("ATRIBUTOS DO JOGADOR");
    
        setSize(350,300);

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.ipadx = 200;
        
        lb1 = new JLabel();
        lb1.setText("NOME: " + jogador.getNome());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lb1, c);
        
        lb2 = new JLabel();
        lb2.setText("NIVEL: " + jogador.getNivelInt());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        container.add(lb2, c);
        
        lb3 = new JLabel();
        lb3.setText("VIDA: " + jogador.getVidaAtual() + "/" + jogador.getVidaTotal());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        container.add(lb3, c);
        
        lb4 = new JLabel();
        lb4.setText("ESQUIVA: " + jogador.getEsquiva() + "%");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        container.add(lb4, c);
        
        bt = new JButton();
        bt.setText("OK");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        container.add(bt, c);
        
        TelaAtributosJogador.GerenciadorDeBotoes btManager = new TelaAtributosJogador.GerenciadorDeBotoes();
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
