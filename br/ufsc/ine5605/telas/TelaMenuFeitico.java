package br.ufsc.ine5605.telas;

import br.ufsc.ine5605.controladores.ControladorBatalha;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class TelaMenuFeitico extends JFrame{
    
    private JButton btFogo;
    private JButton btAgua;
    private JButton btGrama;
    private JButton btPedra;
    private JLabel lb1;
    
    public TelaMenuFeitico() {
        super("FEITICOS");
        
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        lb1 = new JLabel();
        lb1.setText("Escolha o elemento dos feitiços que deseja ver");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lb1, c);
        
        btFogo = new JButton();
        btFogo.setText("FOGO");
        btFogo.setActionCommand("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        container.add(btFogo, c);
        
        btAgua = new JButton();
        btAgua.setText("AGUA");
        btFogo.setActionCommand("2");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        container.add(btAgua, c);
        
        btGrama = new JButton();
        btGrama.setText("GRAMA");
        btFogo.setActionCommand("3");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        container.add(btGrama, c);
        
        btPedra = new JButton();
        btPedra.setText("PEDRA");
        btFogo.setActionCommand("4");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 4;
        container.add(btPedra, c);
        
        TelaMenuFeitico.GerenciadorDeBotoes btManager = new TelaMenuFeitico.GerenciadorDeBotoes();
        btFogo.addActionListener(btManager);
        btAgua.addActionListener(btManager);
        btGrama.addActionListener(btManager);
        btPedra.addActionListener(btManager);
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
            ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
            conteudoTela.tipoString = e.getActionCommand();
            ControladorBatalha.getInstance().verFeiticos(conteudoTela);
        }
    }

}