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
import br.ufsc.ine5605.controladores.ControladorBau;
import java.util.ArrayList;


public class TelaBauSwing extends JFrame{
    
    
    private JLabel text2;
    private JLabel text1;
    private JLabel txtGrimorio;
    private JLabel txtArma;
    private JLabel txtConsumivel;
    private JLabel txtItens;
    private JButton btSair;
    private JButton btMostraItens;
    private JButton btMostraArma;
    private JButton btComparaArmas;
    private JButton btVerItensBau;
    private JLabel espaco;

    
    private ControladorBau ctrlBau;
    private boolean temArma;
    private boolean temGrimorio;
    private boolean temConsumivel;
    
    public TelaBauSwing(ControladorBau aThis){
        super("Bau");
        
        this.ctrlBau = aThis;
        
        this.updateAtributes(ctrlBau.compactarItensBoolean());
        
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.ipadx = 200;
        
        /*----------IMAGENS----------*/
        c.ipady = 400;
        JLabel lbImgJogador = new JLabel("IMAGEM JOGADOR");
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lbImgJogador, c);
        
        espaco = new JLabel();
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 0;
        container.add(espaco, c);
        
        JLabel lbImgAuxiliar = new JLabel("IMAGEM BAU");
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 2;
        c.gridy = 0;
        container.add(lbImgAuxiliar, c);
        c.ipady = 0;
        
        //-----------NARRACAO-----------\\
        text1 = new JLabel();
        text1.setText("Voce encontrou um baú, Voce abre e é isso que voce encontra:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        container.add(text1, c);
        
        
        if(temArma && !temGrimorio && !temConsumivel){
            txtItens = new JLabel();
            txtItens.setText("Uma arma.");
            c.fill = GridBagConstraints.HORIZONTAL;
            //c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 3;
            container.add(txtItens, c);
        } else if(!temArma && temGrimorio && !temConsumivel){
            txtItens = new JLabel();
            txtItens.setText("Um grimorio.");
            c.fill = GridBagConstraints.HORIZONTAL;
            //c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 3;
            container.add(txtItens, c);
        } else if(!temArma && !temGrimorio && temConsumivel){
            txtItens = new JLabel();
            txtItens.setText("Um consumivel.");
            c.fill = GridBagConstraints.HORIZONTAL;
            //c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 3;
            container.add(txtItens, c);
        } else if(temArma && !temGrimorio && temConsumivel){
            txtItens = new JLabel();
            txtItens.setText("Uma arma e um consumivel.");
            c.fill = GridBagConstraints.HORIZONTAL;
            //c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 3;
            container.add(txtItens, c);
        } else if (!temArma && temGrimorio && temConsumivel){
            txtItens = new JLabel();
            txtItens.setText("Um consumivel e um grimório");
            c.fill = GridBagConstraints.HORIZONTAL;
            //c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 3;
            container.add(txtItens, c);
        } else if (temArma && temGrimorio && !temConsumivel){
            txtItens = new JLabel();
            txtItens.setText("Uma Arma e um grimório");
            c.fill = GridBagConstraints.HORIZONTAL;
            //c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 3;
            container.add(txtItens, c);
        } else if (temArma && temGrimorio && temConsumivel){
            txtItens = new JLabel();
            txtItens.setText("Uma Arma, um grimório e um consumivel");
            c.fill = GridBagConstraints.HORIZONTAL;
            //c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 3;
            container.add(txtItens, c);
        }
        
        //------------ESPACO-----------\\
        
        espaco = new JLabel();
        c.gridwidth = 1;
        c.fill = GridBagConstraints.VERTICAL;
        c.ipady = 10;
        c.gridx = 0;
        c.gridy = 4;
        container.add(espaco, c);
        c.ipady = 0;
        
        
        //------------BOTOES-----------\\
        btMostraItens = new JButton("VER ITENS DA BOLSA");
        btMostraItens.setActionCommand("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 5;
        container.add(btMostraItens, c);
        
        btMostraArma = new JButton("VER SUA ARMA");
        btMostraArma.setActionCommand("2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        container.add(btMostraArma, c);
        
        btSair = new JButton("SAIR");
        btSair.setActionCommand("0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 5;
        container.add(btSair, c);
        
        
        int i = 6;
        if(temArma){
            btComparaArmas = new JButton();
            btComparaArmas.setText("PEGAR ARMA DO BAU");
            btComparaArmas.setActionCommand("3");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridwidth = 3;
            c.gridx = 0;
            c.gridy = i;
            container.add(btComparaArmas, c);
            c.gridwidth = 0;
            i++;
        }
        
        if(temConsumivel){
            btVerItensBau = new JButton();
            btVerItensBau.setText("PEGAR CONSUMÍVEL DO BAU");
            btVerItensBau.setActionCommand("4");
            c.gridwidth = 3;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = i;
            container.add(btVerItensBau, c);
            c.gridwidth = 0;
        }
        
        TelaBauSwing.GerenciadorDeBotoes btManager = new TelaBauSwing.GerenciadorDeBotoes();
        btSair.addActionListener(btManager);
        btMostraItens.addActionListener(btManager);
        btMostraArma.addActionListener(btManager);
        if(temArma){
            btComparaArmas.addActionListener(btManager);
        }
        if(temConsumivel){
            btVerItensBau.addActionListener(btManager);
        }
    }
    
    public TelaBauSwing(){
        super("AVISO");
        
        setSize(500,300);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        setLocationRelativeTo(null);
        
        text1 = new JLabel();
        text1.setText("Voce pegou o grimorio e sai da sala");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(text1, c);
        
        
        btSair = new JButton("OK");
        btSair.setActionCommand("SAIR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        container.add(btSair, c);
        
        TelaBauSwing.GerenciadorDeBotoes btManager = new TelaBauSwing.GerenciadorDeBotoes();
        btSair.addActionListener(btManager);
    }
    
    public void mostraTelaBau(){
        setVisible(true);
    }
    
    public void ocultaTelaBau(){
        setVisible(false);
    }

    public void updateAtributes(ConteudoTelaBau itensBau) {
        this.temArma = itensBau.temArma;
        this.temConsumivel = itensBau.temConsumivel;
        this.temGrimorio = itensBau.temGrimorio;
        
        if(btComparaArmas != null && temArma == false){
            btComparaArmas.setText("---");
        }
        
        if(btVerItensBau != null && temConsumivel == false){
            btVerItensBau.setText("---");
        }
    }
    
    private class GerenciadorDeBotoes implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!e.getActionCommand().equals("SAIR")){
                ControladorBau.getInstance().executaOpcao(e.getActionCommand());
            } else {
                ocultaTelaBau();
            }
        }
        
    }
}

