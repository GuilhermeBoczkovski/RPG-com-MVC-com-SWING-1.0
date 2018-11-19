package br.ufsc.ine5605.telas;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import br.ufsc.ine5605.controladores.ControladorGeral;
import br.ufsc.ine5605.exception.NomeMuitoGrandeException;
import br.ufsc.ine5605.exception.NomeVazioException;

public class TelaInicio extends JFrame{
    
    
    
    private JLabel lb1;
    private JLabel lb2;
    private JTextField tf;
    private JLabel lb3;
    private JButton bt;
    
    public TelaInicio(){
        super("NEW GAME");
        
        setSize(1024,384);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        lb1 = new JLabel();
        lb1.setText("Seja Bem Vindo, Herói");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lb1, c);
        
        lb2 = new JLabel();
        lb2.setText("Você é um feiticeiro, estudou por anos na escola de magia "
                    + "e agora chegou a hora de colocar seus conhecimentos em "
                    + "prática. Primeiramente, qual o seu nome?");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        container.add(lb2, c);
        
        tf = new JTextField("");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        container.add(tf, c);
        
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
    
    public void mostraTelaInicio(){
        setVisible(true);
    }
    
    public void ocultaTelaInicio(){
        setVisible(false);
    }
    
    private class GerenciadorDeBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                if((tf.getText().length()>0) && (tf.getText().length()<=20)){
                    ocultaTelaInicio();
                    ControladorGeral.getInstance().play(tf.getText());
                }else if(tf.getText().length()<=0){
                    throw new NomeVazioException();
                }else if(tf.getText().length()>20){
                    throw new NomeMuitoGrandeException();
                }
            }catch(NomeVazioException ex){
                TelaDeAviso tela = new TelaDeAviso(ex.getMessage());
                tela.mostraTela();
            }catch(NomeMuitoGrandeException ex){
                TelaDeAviso tela = new TelaDeAviso(ex.getMessage());
                tela.mostraTela();
            }
        }
        
    }
}
