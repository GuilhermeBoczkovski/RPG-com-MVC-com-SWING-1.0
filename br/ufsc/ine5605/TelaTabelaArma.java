package br.ufsc.ine5605.telas;

import br.ufsc.ine5605.controladores.ControladorBatalha;
import br.ufsc.ine5605.controladores.ControladorBau;
import br.ufsc.ine5605.entidades.Arma;
import br.ufsc.ine5605.entidades.Consumivel;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import br.ufsc.ine5605.entidades.Feitico;
import br.ufsc.ine5605.entidades.Item;
import javax.swing.JLabel;

public class TelaTabelaArma extends JFrame{
    
    private JTable tabelaArmaJogador;
    private JTable tabelaArmaBau;
    private JScrollPane spBaseTabela;
    private Arma armaJogador;
    private Arma armaBau;
    private JButton btOk;
    private JButton btTrocar;
    private JLabel txtArmaJogador;
    private JLabel txtArmaBau;
    
    public TelaTabelaArma(ConteudoTelaBau arma, boolean armaJogador){
        super("SUA ARMA");
        this.armaJogador = arma.armaJogador;
        
        this.atualizaDadosSoParaJogador();
        setSize(600, 330);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        tabelaArmaJogador.setPreferredScrollableViewportSize(new Dimension(320, 25));
        
        c.fill = GridBagConstraints.CENTER;
        c.gridwidth = 2;
        c.gridheight = 2;
        c.gridx = 0;
        c.gridy = 4;
        
        spBaseTabela = new JScrollPane(tabelaArmaJogador);
        container.add(spBaseTabela, c);
        
        setLocationRelativeTo(null);
        
        btOk = new JButton("OK");
        btOk.setActionCommand("OK");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(btOk, c);
        
        TelaTabelaArma.GerenciadorDeBotoes btManager = new TelaTabelaArma.GerenciadorDeBotoes();
        btOk.addActionListener(btManager);
    }
    
    public TelaTabelaArma(ConteudoTelaBau armas){
        super("TROCAR ARMA");
        this.armaJogador = armas.armaJogador;
        this.armaBau = armas.armaBau;
        
        this.atualizaDados();
        setSize(700, 400);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        tabelaArmaJogador.setPreferredScrollableViewportSize(new Dimension(320, 25));
        
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;
        
        spBaseTabela = new JScrollPane(tabelaArmaJogador);
        container.add(spBaseTabela, c);
        
        setLocationRelativeTo(null);
        
        txtArmaJogador = new JLabel("ARMA DO JOGADOR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(txtArmaJogador, c);
        
        tabelaArmaBau.setPreferredScrollableViewportSize(new Dimension(320, 25));
        
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 1;
        
        spBaseTabela = new JScrollPane(tabelaArmaBau);
        container.add(spBaseTabela, c);
        
        txtArmaBau = new JLabel("ARMA DO BAU");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        container.add(txtArmaBau, c);
        
        btTrocar = new JButton("TROCAR A ARMA ATUAL COM A DO BAU");
        btTrocar.setActionCommand("TROCAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        container.add(btTrocar, c);
        
        btOk = new JButton("VOLTAR");
        btOk.setActionCommand("OK");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        container.add(btOk, c);
        
        TelaTabelaArma.GerenciadorDeBotoes btManager = new TelaTabelaArma.GerenciadorDeBotoes();
        btOk.addActionListener(btManager);
        btTrocar.addActionListener(btManager);
    }
    
    public void mostraTela(){
        super.setVisible(true);
    }
    
    public void ocultaTela(){
        super.setVisible(false);
    }
    
    private void atualizaDadosSoParaJogador(){
        String[] nomeColunas = {"NOME", "DANO"};
        Object[][] tabelaParaPorNaTabelaJogador = new Object[1][2];
        Object[] infos = { armaJogador.getNome(), armaJogador.getDano()};
        tabelaParaPorNaTabelaJogador[0] = infos;
            
        this.tabelaArmaJogador = new JTable(tabelaParaPorNaTabelaJogador, nomeColunas);
    }
    
    private void atualizaDados(){
        String[] nomeColunas = {"NOME", "DANO"};
        Object[][] tabelaParaPorNaTabelaJogador = new Object[1][2];
        Object[] infosJogador = { armaJogador.getNome(), armaJogador.getDano()};
        tabelaParaPorNaTabelaJogador[0] = infosJogador;
            
        this.tabelaArmaJogador = new JTable(tabelaParaPorNaTabelaJogador, nomeColunas);
        
        Object[][] tabelaParaPorNaTabelaBau = new Object[1][2];
        Object[] infosBau = { armaBau.getNome(), armaBau.getDano()};
        tabelaParaPorNaTabelaBau[0] = infosBau;
            
        this.tabelaArmaBau = new JTable(tabelaParaPorNaTabelaBau, nomeColunas);
    }

    private class GerenciadorDeBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("OK")){
                ocultaTela();
            } else {
                ocultaTela();
                ControladorBau.getInstance().trocarArma();
            }
        }
    }
    
    
}
