package br.ufsc.ine5605.telas;

import br.ufsc.ine5605.controladores.ControladorBau;
import br.ufsc.ine5605.entidades.Item;
import br.ufsc.ine5605.entidades.TipoEvento;
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


public class TelaListagemBasicaFogueira extends JFrame{

    private  ArrayList<TipoEvento> diario;
    private JTable tabelaDiario;
    private JScrollPane spBaseTabela;
    private JButton btOk;
    private ArrayList<Item> itensTabelaJogador;
    private JTable tabelaBolsa;
    
    public TelaListagemBasicaFogueira(ArrayList<ConteudoTelaFogueira> eventos){
        super("DIARIO");
        this.diario = new ArrayList<>();
        for(ConteudoTelaFogueira evento: eventos){
            diario.add(evento.evento);
        }
        this.atualizaDadosDiario();
        setSize(600, 330);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        tabelaDiario.setPreferredScrollableViewportSize(new Dimension(500, 70));
        
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 4;
        
        spBaseTabela = new JScrollPane(tabelaDiario);
        container.add(spBaseTabela, c);
        
        setLocationRelativeTo(null);
        
        btOk = new JButton("OK");
        btOk.setActionCommand("OK");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(btOk, c);
        
        TelaListagemBasicaFogueira.GerenciadorDeBotoes btManager = new TelaListagemBasicaFogueira.GerenciadorDeBotoes();
        btOk.addActionListener(btManager);
    }

    public TelaListagemBasicaFogueira(ArrayList<ConteudoTelaFogueira> itens, boolean contexto) {
        super("BOLSA");
        this.itensTabelaJogador = new ArrayList<>();
        for(ConteudoTelaFogueira item: itens){
            itensTabelaJogador.add(item.item);
        }
        this.atualizaDadosItens();
        setSize(600, 330);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        tabelaBolsa.setPreferredScrollableViewportSize(new Dimension(500, 70));
        
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 4;
        
        spBaseTabela = new JScrollPane(tabelaBolsa);
        container.add(spBaseTabela, c);
        
        setLocationRelativeTo(null);
        
        btOk = new JButton("OK");
        btOk.setActionCommand("OK");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(btOk, c);
        
        TelaListagemBasicaFogueira.GerenciadorDeBotoes btManager = new TelaListagemBasicaFogueira.GerenciadorDeBotoes();
        btOk.addActionListener(btManager);
        
    }

    public void ocultaTela() {
        super.setVisible(false);
    }

    public void mostraTela() {
       super.setVisible(true);
    }
    
    private void atualizaDadosDiario(){
        String[] nomeColunas = {"", "EVENTO"};
        Object[][] tabelaParaPorNaTabela = new Object[diario.size()][2];
        int i = 0;
        for(TipoEvento evento: diario){
            Object[] infos = {i+1, evento};
            tabelaParaPorNaTabela[i] = infos;
            i++;
        }
        this.tabelaDiario = new JTable(tabelaParaPorNaTabela, nomeColunas);
    }

    private void atualizaDadosItens(){
        String[] nomeColunas = {"", "NOME"};
        Object[][] tabelaParaPorNaTabelaBolsa = new Object[itensTabelaJogador.size()][2];
        int i = 0;
        for(Item item: itensTabelaJogador){
            Object[] infos = {i, item.getNome()};
            tabelaParaPorNaTabelaBolsa[i] = infos;
            i++;
        }
        this.tabelaBolsa = new JTable(tabelaParaPorNaTabelaBolsa, nomeColunas);
    }
    
    private class GerenciadorDeBotoes implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ocultaTela();
        }
    }
    
}
