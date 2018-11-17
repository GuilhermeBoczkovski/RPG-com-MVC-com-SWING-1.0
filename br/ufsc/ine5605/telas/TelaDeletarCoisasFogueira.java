package br.ufsc.ine5605.telas;

import br.ufsc.ine5605.controladores.ControladorFogueira;
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
import br.ufsc.ine5605.entidades.Consumivel;
import br.ufsc.ine5605.entidades.Item;
import br.ufsc.ine5605.exception.NadaSelecionadoException;
import javax.swing.JLabel;

public class TelaDeletarCoisasFogueira extends JFrame{
    private JLabel texto;
    private JTable tabela;
    private int indice;
    private JScrollPane spBaseTabela;
    private ArrayList<Feitico> feiticos;
    private ArrayList<Item> consumiveis;
    private JButton btOk;
    private JButton btVoltar;
    private JLabel lblAviso;
    
    public TelaDeletarCoisasFogueira(ArrayList<ConteudoTelaFogueira> conteudos, String titulo){
        super(titulo);
        
        feiticos = new ArrayList<>();
        for(ConteudoTelaFogueira cont : conteudos){
            feiticos.add(cont.feitico);
        }
        this.atualizaDadosFeitico();
        
        setSize(700,400);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        texto = new JLabel();
        texto.setText("Escolha um feitico para esquecer:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(texto, c);
        
        tabela.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tabela.setFillsViewportHeight(true); // nao sei
        

        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;
        
        spBaseTabela = new JScrollPane(tabela);
        container.add(spBaseTabela, c);
        
        setLocationRelativeTo(null);
        
        btOk = new JButton("ESQUECER");
        btOk.setActionCommand("ESQUECER");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        container.add(btOk, c);
        
        btVoltar = new JButton("VOLTAR");
        btVoltar.setActionCommand("VOLTAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        container.add(btVoltar, c);
        
        TelaDeletarCoisasFogueira.GerenciadorDeBotoes btManager = new TelaDeletarCoisasFogueira.GerenciadorDeBotoes();
        btOk.addActionListener(btManager);
        btVoltar.addActionListener(btManager);
    }

    public TelaDeletarCoisasFogueira(ArrayList<ConteudoTelaFogueira> conteudos) {
        super("DESCARTAR ITENS");
        
        consumiveis = new ArrayList<>();
        for(ConteudoTelaFogueira cont : conteudos){
            consumiveis.add(cont.item);
        }
        this.atualizaDadosItem();
        
        setSize(700,400);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        texto = new JLabel();
        texto.setText("Escolha um item para descartar:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(texto, c);
        
        tabela.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tabela.setFillsViewportHeight(true); // nao sei
        

        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;
        
        spBaseTabela = new JScrollPane(tabela);
        container.add(spBaseTabela, c);
        
        setLocationRelativeTo(null);
        
        btOk = new JButton("DESCARTAR");
        btOk.setActionCommand("DESCARTAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        container.add(btOk, c);
        
        btVoltar = new JButton("VOLTAR");
        btVoltar.setActionCommand("VOLTAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        container.add(btVoltar, c);
        
        TelaDeletarCoisasFogueira.GerenciadorDeBotoes btManager = new TelaDeletarCoisasFogueira.GerenciadorDeBotoes();
        btOk.addActionListener(btManager);
        btVoltar.addActionListener(btManager);
        
    }
    
    public TelaDeletarCoisasFogueira(boolean ehFeitico){
        super("AVISO");
        
        setSize(400,300);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        setLocationRelativeTo(null);
        
        if(ehFeitico == false){
            lblAviso = new JLabel();
            lblAviso.setText("Item descartado com sucesso");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 0;
            container.add(lblAviso, c);
        } else {
            lblAviso = new JLabel();
            lblAviso.setText("Feitiço esquecido com sucesso");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 0;
            container.add(lblAviso, c);
        }
        
        btVoltar = new JButton("OK");
        btVoltar.setActionCommand("OK");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        container.add(btVoltar, c);
        
        TelaDeletarCoisasFogueira.GerenciadorDeBotoes btManager = new TelaDeletarCoisasFogueira.GerenciadorDeBotoes();
        btVoltar.addActionListener(btManager);
    }
    
     public void mostraTela(){
        super.setVisible(true);
    }
    
    public void ocultaTela(){
        super.setVisible(false);
    }
    
    private void setIndice() {
        this.indice = tabela.getSelectedRow();    
    }
    
     private int getIndice() {
        return this.indice;
    }
    
    private void atualizaDadosFeitico() {
        String[] nomeColunas = {"INDICE", "NOME", "DANO", "TIPO ELEMENTO"};
        Object[][] tabelaParaPorNaTabela = new Object[feiticos.size()][4];
        int i = 0;
        for(Feitico feitico: feiticos){
            Object[] infos = {i, feitico.getNome(), feitico.getDano(), feitico.getTipoElemento()};
            tabelaParaPorNaTabela[i] = infos;
            i++;
        }
        this.tabela = new JTable(tabelaParaPorNaTabela, nomeColunas);
    }
    
    private void atualizaDadosItem() {
        String[] nomeColunas = {"INDICE", "NOME"};
        Object[][] tabelaParaPorNaTabela = new Object[consumiveis.size()][2];
        int i = 0;
        for(Item item: consumiveis){
            Object[] infos = {i, item.getNome()};
            tabelaParaPorNaTabela[i] = infos;
            i++;
        }
        this.tabela = new JTable(tabelaParaPorNaTabela, nomeColunas);
    }

    private class GerenciadorDeBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            if(!e.getActionCommand().equals("OK")){
                setIndice();
                int i = getIndice();
                try{
                    if((e.getActionCommand().equals("ESQUECER") || e.getActionCommand().equals("DESCARTAR")) && i == -1){
                        throw new NadaSelecionadoException();
                    } else {
                        if(e.getActionCommand().equals("ESQUECER")){
                            ocultaTela();
                            ControladorFogueira.getInstance().esquecerFeitico(i);
                        } else if(e.getActionCommand().equals("DESCARTAR")){
                            ocultaTela();
                            ControladorFogueira.getInstance().descartarItem(i);
                        } else {
                            ocultaTela();
                        }
                    }
                } catch(NadaSelecionadoException exc){
                    TelaDeException erro = new TelaDeException(exc.getMessage());
                    erro.mostraTela();
                }
            } else {
                ocultaTela();
            }
        }
    }
}
