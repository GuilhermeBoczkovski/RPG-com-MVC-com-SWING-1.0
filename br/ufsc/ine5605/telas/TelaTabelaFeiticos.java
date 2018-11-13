package br.ufsc.ine5605.telas;

import br.ufsc.ine5605.controladores.ControladorBatalha;
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

public class TelaTabelaFeiticos extends JFrame{
    
    private JTable tabela;
    private JScrollPane spBaseTabela;
    private ArrayList<Feitico> feiticos;
    private JButton btAtaque;
    private int indiceFeitico;
    
    public TelaTabelaFeiticos(ArrayList<ConteudoTelaBatalha> conteudos){
        super("ATAQUE");
        feiticos = new ArrayList<>();
        for(ConteudoTelaBatalha cont : conteudos){
            System.out.println(cont.feitico.getNome());
            feiticos.add(cont.feitico);
        }
        this.atualizaDados();
        setSize(1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        tabela.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tabela.setFillsViewportHeight(true); // nao sei
        

        c.fill = GridBagConstraints.CENTER;
        c.gridwidth = 2;
        c.gridheight = 4;
        c.gridx = 0;
        c.gridy = 4;
        
        spBaseTabela = new JScrollPane(tabela);
        container.add(spBaseTabela, c);
        
        setLocationRelativeTo(null);
        
        btAtaque = new JButton("ATACAAAAAR");
        btAtaque.setActionCommand("ATAQUE");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(btAtaque, c);
        
        TelaTabelaFeiticos.GerenciadorDeBotoes btManager = new TelaTabelaFeiticos.GerenciadorDeBotoes();
        btAtaque.addActionListener(btManager);
    }
    
    public void mostraTela(){
        super.setVisible(true);
    }
    
    public void ocultaTela(){
        super.setVisible(false);
    }
    
    private void atualizaDados(){
        String[] nomeColunas = {"INDICE", "NOME", "DANO", "TIPO ELEMENTO"};
        Object[][] tabelaParaPorNaTabela = new Object[4][feiticos.size()];
        int i = 0;
        for(Feitico feitico: feiticos){
            Object[] infos = {i, feitico.getNome(), feitico.getDano(), feitico.getTipoElemento()};
            tabelaParaPorNaTabela[i] = infos;
            i++;
        }
        this.tabela = new JTable(tabelaParaPorNaTabela, nomeColunas);
    }    
    
    public void setIndiceFeitico(){
        this.indiceFeitico = tabela.getSelectedRow();
    }
    
    public int getIndiceFeitico(){
        return this.indiceFeitico; 
    }
    
    private class GerenciadorDeBotoes implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            ocultaTela();
            setIndiceFeitico();
            int i = getIndiceFeitico();
            ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
            conteudoTela.indiceFeitico = i;
            ControladorBatalha.getInstance().atacar(conteudoTela);
        }
        
    }
}