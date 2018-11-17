package br.ufsc.ine5605.telas;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaAnaliseMonstro extends JFrame{
    
    private JLabel lbNome;
    private JLabel lbVida;
    private JLabel lbElemento;
    private JLabel lbForca;
    private JLabel lbEsquiva;
    private JButton btVoltar;
    
    public TelaAnaliseMonstro(ConteudoTelaBatalha conteudoTela){
        super("ANALISE MONSTRO");
        
        setSize(200,200);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        lbNome = new JLabel();
        lbNome.setText("NOME: " + conteudoTela.monstro.getNome());
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lbNome, c);
        
        lbVida = new JLabel();
        lbVida.setText("VIDA: " + 
                Integer.toString(conteudoTela.monstro.getVidaAtual()) + "/" + 
                Integer.toString(conteudoTela.monstro.getVidaTotal()));
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        container.add(lbVida, c);
        
        lbElemento = new JLabel();
        lbElemento.setText("ELEMENTO: " + conteudoTela.monstro.getTipoElemento());
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        container.add(lbElemento, c);
        
        lbForca = new JLabel();
        lbForca.setText("FORCA: " + Integer.toString(conteudoTela.monstro.getForca()));
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        container.add(lbForca, c);
        
        lbEsquiva = new JLabel();
        lbEsquiva.setText("ESQUIVA: " + (conteudoTela.monstro.getEsquiva()) + "%");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 4;
        container.add(lbEsquiva, c);
        
        btVoltar = new JButton("VOLTAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        container.add(btVoltar, c);
        
        TelaAnaliseMonstro.GerenciadorDeBotoes btManager = new TelaAnaliseMonstro.GerenciadorDeBotoes();
        btVoltar.addActionListener(btManager);
    }

    public void mostraTela(){
        setVisible(true);
    }
    
    public void ocultaTela(){
        setVisible(false);
    }
    
    private class GerenciadorDeBotoes implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            ocultaTela();
        }
        
    }
    
}