package br.ufsc.ine5605.telas;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import br.ufsc.ine5605.controladores.ControladorGeral;

public class TelaSavedGame extends JFrame{
    
    private final ControladorGeral controladorGeral;
    
    private JLabel lb;
    private JButton btDelete;
    private JButton btContinue;
    
    public TelaSavedGame(ControladorGeral controladorGeral){
        super("Role Playing Game");
        
        this.controladorGeral = controladorGeral;
        
        setSize(1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        lb = new JLabel();
        lb.setText("Selecione o herói que deseja excluir ou jogar");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lb, c);
        
        //JTable de 3 colunas (nome/nivel/)
        
        btContinue = new JButton();
        btContinue.setText("ESTOU PREPARADO");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        container.add(btContinue, c);
        
        btDelete = new JButton();
        btDelete.setText("ESTOU PREPARADO");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 3;
        container.add(btDelete, c);
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        btContinue.addActionListener(btManager);
        btDelete.addActionListener(btManager);
    }
    
    public void mostraTelaInicio(){
        setVisible(true);
    }
    
    public void ocultaTelaInicio(){
        setVisible(false);
    }
    
    private class GerenciadorDeBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ocultaTelaInicio();
            //controladorGeral.play(tf.getText());
        }
        
    }
        
}
