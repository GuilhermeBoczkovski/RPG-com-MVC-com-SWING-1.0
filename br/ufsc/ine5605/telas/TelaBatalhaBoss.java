package br.ufsc.ine5605.telas;

import java.util.ArrayList;
import java.util.Scanner;
import br.ufsc.ine5605.controladores.ControladorBatalhaBoss;
import br.ufsc.ine5605.entidades.Feitico;
import br.ufsc.ine5605.entidades.Jogador;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaBatalhaBoss  extends TelaEncontro{
        
    private JLabel lbNome;
    private JLabel lbNivel;
    private JLabel lbSala;
    private JLabel lbVida;
    private JLabel lbVazia;
    private JLabel lbNomeMonstro;
    private JLabel lbNivelMonstro;
    private JLabel lbVidaMonstro;
    private JLabel lbNarra1;
    private JLabel lbNarra2;
    private JLabel lbNarra3;
    private JLabel lbNarra4;
    private JLabel lbImgJogador;
    private JLabel lbImgAuxiliar;
    private JButton bt1;
    private JButton bt2;
    private JButton bt3;
    private JButton bt4;
    private JButton bt5;
    private JButton bt6;
    private JButton btVazio;
    
    
    public TelaBatalhaBoss(){
        super("BATALHA FINAAAAAL");
    
        setSize(900,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.ipadx = 200;
        
        /*----------DADOS JOGADOR----------*/
        lbNome = new JLabel();
        lbNome.setText("NOME: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lbNome, c);

        lbNivel = new JLabel();
        lbNivel.setText("NIVEL: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        container.add(lbNivel, c);

        lbVida = new JLabel();
        lbVida.setText("VIDA: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        container.add(lbVida, c);

        lbSala = new JLabel();
        lbSala.setText("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        container.add(lbSala, c);
        /*----------VAZIO 1----------*/
        lbVazia = new JLabel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        container.add(lbVazia, c);
        
        lbVazia = new JLabel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        container.add(lbVazia, c);
        
        lbVazia = new JLabel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        container.add(lbVazia, c);
        
        lbVazia = new JLabel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        container.add(lbVazia, c);
        /*----------DADOS MONSTRO----------*/
        lbNomeMonstro = new JLabel();
        lbNomeMonstro.setText("NOME MONSTRO: DEMOGORGON");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        container.add(lbNomeMonstro, c);

        lbNivelMonstro = new JLabel();
        lbNivelMonstro.setText("NIVEL MONSTRO: 10");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        container.add(lbNivelMonstro, c);

        lbVidaMonstro = new JLabel();
        lbVidaMonstro.setText("VIDA MONSTRO: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        container.add(lbVidaMonstro, c);
        
        lbVazia = new JLabel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 3;
        container.add(lbVazia, c);
        /*----------IMAGENS----------*/
        c.ipady = 400;
        lbImgJogador = new JLabel();
        lbImgJogador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/ine5605/imagens/jogadoratacando.png")));
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 4;
        container.add(lbImgJogador, c);
        
        lbVazia = new JLabel();
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 4;
        container.add(lbVazia, c);
        
        lbImgAuxiliar = new JLabel();
        lbImgAuxiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/ine5605/imagens/monstro.png")));
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 2;
        c.gridy = 4;
        container.add(lbImgAuxiliar, c);
        c.ipady = 0;
        /*----------NARRACAO----------*/
        c.gridwidth = 3;
        lbNarra1 = new JLabel();
        lbNarra1.setText("...");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        container.add(lbNarra1, c);
        
        lbNarra2 = new JLabel();
        lbNarra2.setText("...");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 6;
        container.add(lbNarra2, c);
        
        lbNarra3 = new JLabel();
        lbNarra3.setText("...");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 7;
        container.add(lbNarra3, c);
        
        lbNarra4 = new JLabel();
        lbNarra4.setText("...");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 8;
        container.add(lbNarra4, c);
        c.gridwidth = 1;
        /*----------BOTOES 1----------*/
        bt1 = new JButton();
        bt1.setText("Atacar demogorgon");
        bt1.setActionCommand("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 9;
        container.add(bt1, c);
        
        bt2 = new JButton();
        bt2.setText("Analizar demogorgon");
        bt2.setActionCommand("2");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 10;
        container.add(bt2, c);
        
        bt3 = new JButton();
        bt3.setText("Ver Feitiços");
        bt3.setActionCommand("3");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 11;
        container.add(bt3, c);
        
        bt4 = new JButton();
        bt4.setText("-");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 12;
        container.add(bt4, c);
        /*----------BOTOES 2----------*/
        bt5 = new JButton();
        bt5.setText("Usar Item");
        bt5.setActionCommand("5");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 9;
        container.add(bt5, c);
        
        bt6 = new JButton();
        bt6.setText("Meus Atributos");
        bt6.setActionCommand("6");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 10;
        container.add(bt6, c);
        
        btVazio = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 11;
        container.add(btVazio, c);
        
        btVazio = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 12;
        container.add(btVazio, c);
        /*----------BOTOES 3----------*/
        btVazio = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 9;
        container.add(btVazio, c);
        
        btVazio = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 10;
        container.add(btVazio, c);
        
        btVazio = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 11;
        container.add(btVazio, c);
        
        btVazio = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 12;
        container.add(btVazio, c);
        
        TelaBatalhaBoss.GerenciadorDeBotoes btManager = new TelaBatalhaBoss.GerenciadorDeBotoes();
        bt1.addActionListener(btManager);
        bt2.addActionListener(btManager);
        bt3.addActionListener(btManager);
        bt4.addActionListener(btManager);
        bt5.addActionListener(btManager);
        bt6.addActionListener(btManager);
        
        
    }
    
    @Override
    public void mostraTela() {
        super.mostraTela();
    }

    @Override
    public void ocultaTela() {
        super.ocultaTela();
    }

    public void atualizaDados(ConteudoTelaBatalha dadosTelaCompactados) {
        if(dadosTelaCompactados.jogador != null){
            String vidaJogador = ("VIDA: " + 
                Integer.toString(dadosTelaCompactados.jogador.getVidaAtual())
                + "/" + Integer.toString(dadosTelaCompactados.jogador.getVidaTotal()));
            lbVida.setText(vidaJogador);
            lbVidaMonstro.setText("VIDA: " + 
                    Integer.toString(dadosTelaCompactados.monstro.getVidaAtual()) 
                    + "/" + Integer.toString(dadosTelaCompactados.monstro.getVidaTotal()));
            
            lbNome.setText("NOME: " + dadosTelaCompactados.jogador.getNome());
            lbNivel.setText("NIVEL: " + Integer.toString(dadosTelaCompactados.jogador.getNivelInt()));
            lbNomeMonstro.setText("NOME: DEMOGORGON");
            lbNivelMonstro.setText("NIVEL: " + Integer.toString(dadosTelaCompactados.jogador.getNivelInt()));
            
            lbNarra1.setText("...");
            lbNarra2.setText("...");
            lbNarra3.setText("...");
            lbNarra4.setText("...");
        }
    }

    public void mostraAtaque(ConteudoTelaBatalha conteudoTelaAtaqueJogador, ConteudoTelaBatalha conteudoTelaAtaqueMonstro) {
        ControladorBatalhaBoss.getInstance().atualizaDadosTela();
        lbNarra1.setText(conteudoTelaAtaqueJogador.atacante.getNome() + " ataca " + conteudoTelaAtaqueJogador.atacado.getNome() + " com " + conteudoTelaAtaqueJogador.feitico.getNome() + " causando " + conteudoTelaAtaqueJogador.danoAtaque + " de dano");
        lbNarra2.setText(conteudoTelaAtaqueMonstro.atacante.getNome() + " ataca " + conteudoTelaAtaqueMonstro.atacado.getNome() + " causando " + conteudoTelaAtaqueMonstro.danoAtaque + " de dano");
        if(conteudoTelaAtaqueMonstro.atacado.getVidaAtual()<=0){
            ControladorBatalhaBoss.getInstance().gameOver();
        }
    }

    public void mostraMenuAtaque(ArrayList<ConteudoTelaBatalha> compactados) {
        TelaTabelaFeiticos telaFeiticos = new TelaTabelaFeiticos(compactados);
        telaFeiticos.ehBoss();
        telaFeiticos.mostraTela();
    }

    public void mostraFimBatalha(ConteudoTelaBatalha conteudoTela) {
        ocultaTela();
        TelaFimBatalha telaFim = new TelaFimBatalha(conteudoTela);
        telaFim.mostraTela();
    }

    public void mostraAnalise(ConteudoTelaBatalha conteudoTela) {
        TelaAnaliseMonstro telaAnalise = new TelaAnaliseMonstro(conteudoTela);
        telaAnalise.mostraTela();
    }

    public void mostraFeiticos(ArrayList<ConteudoTelaBatalha> conteudoTelaS) {
        TelaTabelaFeiticos tela = new TelaTabelaFeiticos(conteudoTelaS, true);
        tela.mostraTela();
    }
    
    public void mostraMenuFeitico() {
        TelaMenuFeitico telaMenuFeitico = new TelaMenuFeitico();
        telaMenuFeitico.mostraTela();
    }

    public void mostraMenuItens(ArrayList<ConteudoTelaBatalha> conteudoTelaS) {
        TelaTabelaItens tela = new TelaTabelaItens(conteudoTelaS, true);
        tela.mostraTela();
    }

    public void mostraMeusAtributos(Jogador jogador) {
        TelaAtributosJogador tela = new TelaAtributosJogador(jogador);
        tela.mostraTela();
    }
    
    private class GerenciadorDeBotoes implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            ControladorBatalhaBoss.getInstance().executaOpcao(e.getActionCommand());
        }
        
    }
}