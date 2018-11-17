package br.ufsc.ine5605.telas;

import br.ufsc.ine5605.controladores.ControladorFogueira;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class TelaDeException extends JFrame{

    private JLabel lblAviso;
    private final JButton btVoltar;

    public TelaDeException(String message) {
        super("AVISO");
        
        setSize(500,300);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        setLocationRelativeTo(null);
        
        lblAviso = new JLabel();
        lblAviso.setText(message);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lblAviso, c);
        
        
        btVoltar = new JButton("OK");
        btVoltar.setActionCommand("VOLTAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        container.add(btVoltar, c);
        
        TelaDeException.GerenciadorDeBotoes btManager = new TelaDeException.GerenciadorDeBotoes();
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
