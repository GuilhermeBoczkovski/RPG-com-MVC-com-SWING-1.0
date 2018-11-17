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
import br.ufsc.ine5605.controladores.ControladorFogueira;

public class TelaCriarFeitico extends JFrame{
    
    private JButton btConfirmar;
    private JLabel lblNome;
    private JTextField nome;
    private JButton btVoltar;
    private JLabel lb1;
    private JButton btFogo;
    private JButton btAgua;
    private JButton btGrama;
    private JButton btPedra;
    private JLabel lblAviso;
    
    public TelaCriarFeitico(){
        super("CRIAR FEITICO");
        
        setSize(700,400);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        setLocationRelativeTo(null);
        
        c.ipadx = 200;
        
        lblNome = new JLabel();
        lblNome.setText("Entre o nome do feitiço");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lblNome, c);
        
        nome = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        container.add(nome, c);
        
        btConfirmar = new JButton("CONFIRMAR");
        btConfirmar.setActionCommand("CONFIRMAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        container.add(btConfirmar, c);
        
        btVoltar = new JButton("VOLTAR");
        btVoltar.setActionCommand("VOLTAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        container.add(btVoltar, c);
        
        TelaCriarFeitico.GerenciadorDeBotoes btManager = new TelaCriarFeitico.GerenciadorDeBotoes();
        btConfirmar.addActionListener(btManager);
        btVoltar.addActionListener(btManager);
    }
    
    public TelaCriarFeitico(String titulo){
        super(titulo);
        
        setSize(400,300);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        setLocationRelativeTo(null);
        
        lb1 = new JLabel();
        lb1.setText("Escolha o elemento do feitico novo");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lb1, c);
        
        btFogo = new JButton("FOGO");
        btFogo.setActionCommand("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        container.add(btFogo, c);
        
        btAgua = new JButton("AGUA");
        btAgua.setActionCommand("2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        container.add(btAgua, c);
        
        btGrama = new JButton("GRAMA");
        btGrama.setActionCommand("3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        container.add(btGrama, c);
        
        btPedra = new JButton("PEDRA");
        btPedra.setActionCommand("4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        container.add(btPedra, c);
        
        btVoltar = new JButton("VOLTAR");
        btVoltar.setActionCommand("VOLTAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        container.add(btVoltar, c);
        
        TelaCriarFeitico.GerenciadorDeBotoes btManager = new TelaCriarFeitico.GerenciadorDeBotoes();
        btFogo.addActionListener(btManager);
        btAgua.addActionListener(btManager);
        btGrama.addActionListener(btManager);
        btPedra.addActionListener(btManager);
        btVoltar.addActionListener(btManager);
    }
    
    public TelaCriarFeitico(boolean erroOuAcerto){
        super("AVISO");
        
        setSize(400,300);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        setLocationRelativeTo(null);
        
        if(erroOuAcerto == false){
            lblAviso = new JLabel();
            lblAviso.setText("Voce não possui grimorios para criar um feitico");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 0;
            container.add(lblAviso, c);
        } else {
            lblAviso = new JLabel();
            lblAviso.setText("Feitiço criado com sucesso!");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 0;
            container.add(lblAviso, c);
        }
        
        btVoltar = new JButton("OK");
        btVoltar.setActionCommand("VOLTAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        container.add(btVoltar, c);
        
        TelaCriarFeitico.GerenciadorDeBotoes btManager = new TelaCriarFeitico.GerenciadorDeBotoes();
        btVoltar.addActionListener(btManager);
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
            if(e.getActionCommand().equals("CONFIRMAR")){
                ocultaTela();
                ControladorFogueira.getInstance().pegaNomeFeiticoNovo(nome.getText());
            } else if (e.getActionCommand().equals("VOLTAR")){
                ocultaTela();
            } else {
                ControladorFogueira.getInstance().criarFeitico( e.getActionCommand());
                ocultaTela();
            }
        }
        
    }
}
