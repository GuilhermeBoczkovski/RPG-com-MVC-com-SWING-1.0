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

public class TelaFimBatalha extends JFrame{

    private JLabel lb1;
    private JLabel lb2;
    private JLabel lb3;
    private JLabel lb4;
    private JLabel lb5;
    private JLabel lb6;
    private JLabel lb7;
    private JButton bt;
    
    public TelaFimBatalha(ConteudoTelaBatalha conteudoTela){
        super("PARABÉNS!!!");
    
        setSize(900,700);

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.ipadx = 200;
        
        lb1 = new JLabel();
        lb1.setText("O herói defere um último feitiço de misericórdia no monstro!");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lb1, c);
        
        lb2 = new JLabel();
        lb2.setText("Dano causado: " + conteudoTela.danoAtaque);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        container.add(lb2, c);
        
        lb3 = new JLabel();
        lb3.setText("O poderoso " + conteudoTela.atacado.getNome() + " finalmente cai ao chão!");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        container.add(lb3, c);
        
        lb4 = new JLabel();
        lb4.setText("Voce encontrou a chave para batalhar com o boss final!!");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        container.add(lb4, c);
        
        lb5 = new JLabel();
        lb5.setText("A próxima vez que encontrar uma fogueira poderá escolher enfrenta-lo");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        container.add(lb5, c);
        
        lb6 = new JLabel();
        lb6.setText("CUIDADO!! Lembre-se que ele eh nivel 10!");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        container.add(lb6, c);
        
        if(conteudoTela.passouDeNivel){
            lb7 = new JLabel();
            lb7.setText("Parabens!! Voce passou de nivel!!");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 6;
            container.add(lb7, c);
        }
        
        bt = new JButton();
        bt.setText("OK");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 7;
        container.add(bt, c);
        
        TelaFimBatalha.GerenciadorDeBotoes btManager = new TelaFimBatalha.GerenciadorDeBotoes();
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
            ControladorBatalha.getInstance().saiDaBatalha();
        }
        
    }
}
