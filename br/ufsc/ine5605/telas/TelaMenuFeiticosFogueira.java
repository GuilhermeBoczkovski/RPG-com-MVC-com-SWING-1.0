package br.ufsc.ine5605.telas;

import br.ufsc.ine5605.controladores.ControladorFogueira;
import br.ufsc.ine5605.entidades.Feitico;
import br.ufsc.ine5605.entidades.TipoElemento;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaMenuFeiticosFogueira extends JFrame{
    private JButton btFogo;
    private JButton btAgua;
    private JButton btGrama;
    private JButton btPedra;
    private JLabel lb1;
    private ArrayList<Feitico> feiticos;
    private JTable tabela;
    private JScrollPane spBaseTabela;
    private JButton btOk;
    
    public TelaMenuFeiticosFogueira() {
        super("FEITICOS");
        
        setSize(400,300);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        setLocationRelativeTo(null);
        
        lb1 = new JLabel();
        lb1.setText("Escolha o elemento dos feitiços que deseja ver");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lb1, c);
        
        btFogo = new JButton();
        btFogo.setText("FOGO");
        btFogo.setActionCommand("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        container.add(btFogo, c);
        
        btAgua = new JButton();
        btAgua.setText("AGUA");
        btAgua.setActionCommand("2");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        container.add(btAgua, c);
        
        btGrama = new JButton();
        btGrama.setText("GRAMA");
        btGrama.setActionCommand("3");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        container.add(btGrama, c);
        
        btPedra = new JButton();
        btPedra.setText("PEDRA");
        btPedra.setActionCommand("4");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 4;
        container.add(btPedra, c);
        
        TelaMenuFeiticosFogueira.GerenciadorDeBotoes btManager = new TelaMenuFeiticosFogueira.GerenciadorDeBotoes();
        btFogo.addActionListener(btManager);
        btAgua.addActionListener(btManager);
        btGrama.addActionListener(btManager);
        btPedra.addActionListener(btManager);
    }
    
    public TelaMenuFeiticosFogueira(TipoElemento tipo, ArrayList<ConteudoTelaFogueira> conteudo){
        super("FEITICOS DE " + tipo.toString());
        
        feiticos = new ArrayList<>();
        for(ConteudoTelaFogueira cont : conteudo){
            feiticos.add(cont.feitico);
        }
        this.atualizaDados();
        setSize(700, 400);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        tabela.setPreferredScrollableViewportSize(new Dimension(650, 70));
        
        c.fill = GridBagConstraints.CENTER;
        c.gridwidth = 2;
        c.gridheight = 2;
        c.gridx = 0;
        c.gridy = 4;
        
        spBaseTabela = new JScrollPane(tabela);
        container.add(spBaseTabela, c);
        
        setLocationRelativeTo(null);
        
        btOk = new JButton("OK");
        btOk.setActionCommand("OK");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(btOk, c);
        
        TelaMenuFeiticosFogueira.GerenciadorDeBotoes btManager = new TelaMenuFeiticosFogueira.GerenciadorDeBotoes();
        btOk.addActionListener(btManager);
        
    }
    
    public void mostraTela(){
        setVisible(true);
    }
    
    public void ocultaTela(){
        setVisible(false);
    }
    
    private void atualizaDados(){
        String[] nomeColunas = {"INDICE", "NOME", "DANO", "ELEMENTO"};
        Object[][] tabelaParaPorNaTabela = new Object[feiticos.size()][4];
        int i = 0;
        for(Feitico feitico: feiticos){
            Object[] infos = {i, feitico.getNome(), feitico.getDano(), feitico.getTipoElemento()};
            tabelaParaPorNaTabela[i] = infos;
            i++;
        }
        this.tabela = new JTable(tabelaParaPorNaTabela, nomeColunas);
    }    
    
    private class GerenciadorDeBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!e.getActionCommand().equals("OK")){
                ocultaTela();
                ControladorFogueira.getInstance().verFeiticos(e.getActionCommand());
            } else {
                ocultaTela();
            }
        }
    }
}
