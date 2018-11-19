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
import br.ufsc.ine5605.entidades.Jogador;
import br.ufsc.ine5605.exception.NadaSelecionadoException;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaSavedGame extends JFrame{
    
    private JTable tabela;
    private JScrollPane spBaseTabela;
    private JLabel lb;
    private JButton btDelete;
    private JButton btContinue;
    private JButton btNewGame;
    private ArrayList<Jogador> jogadores = new ArrayList<>();
    private int indiceJogador;
    
    public TelaSavedGame(ArrayList<Jogador> jogadores){
        super("SAVED GAME");
        this.jogadores = jogadores;
        
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
        
        btContinue = new JButton();
        btContinue.setText("CONTINUAR");
        btContinue.setActionCommand("CONTINUAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        container.add(btContinue, c);
        
        btDelete = new JButton();
        btDelete.setText("EXCLUIR");
        btDelete.setActionCommand("EXCLUIR");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 2;
        container.add(btDelete, c);
        
        btNewGame = new JButton();
        btNewGame.setText("NEW GAME");
        btNewGame.setActionCommand("NEW GAME");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 3;
        container.add(btNewGame, c);
        
        //fazendo a tabela
        this.atualizaDados();
        
        tabela.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tabela.setFillsViewportHeight(true);

        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 4;
        
        spBaseTabela = new JScrollPane(tabela);
        container.add(spBaseTabela, c);
        
        setLocationRelativeTo(null);
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        btContinue.addActionListener(btManager);
        btDelete.addActionListener(btManager);
        btNewGame.addActionListener(btManager);
    }
    
    private void atualizaDados(){
        String[] nomeColunas = {"", "NOME", "NIVEL"};
        Object[][] tabelaParaPorNaTabela = new Object[jogadores.size()][3];
        int i = 0;
        for(Jogador jogador: jogadores){
            Object[] infos = {i, jogador.getNome(), jogador.getNivelInt()};
            tabelaParaPorNaTabela[i] = infos;
            i++;
        }
        this.tabela = new JTable(tabelaParaPorNaTabela, nomeColunas);
    }
    
    public void setIndiceJogador(){
        this.indiceJogador = tabela.getSelectedRow();
    }
    
    public int getIndiceJogador(){
        return this.indiceJogador; 
    }
    
    public void mostraTela(){
        setVisible(true);
    }
    
    public void ocultaTela(){
        setVisible(false);
    }
    
    private class GerenciadorDeBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("NEW GAME")){
                ocultaTela();
                ControladorGeral.getInstance().inicio();
            }else if(e.getActionCommand().equals("CONTINUAR")){
                setIndiceJogador();
                try{
                    if(getIndiceJogador()!=-1){
                        ocultaTela();
                        ControladorGeral.getInstance().continuarComJogador(getIndiceJogador());
                    }else{
                        throw new NadaSelecionadoException();
                    }
                }catch(NadaSelecionadoException ex){
                    TelaDeAviso tela = new TelaDeAviso(ex.getMessage());
                    tela.mostraTela();
                }
            }else if(e.getActionCommand().equals("EXCLUIR")){
                setIndiceJogador();
                try{
                    if(getIndiceJogador() != -1){
                        ControladorGeral.getInstance().excluirJogador(getIndiceJogador());
                        ocultaTela();
                    }else{
                        throw new NadaSelecionadoException();
                    }
                }catch(NadaSelecionadoException ex){
                    TelaDeAviso tela = new TelaDeAviso(ex.getMessage());
                    tela.mostraTela();
                }
            }
            
        }
        
    }
        
}
