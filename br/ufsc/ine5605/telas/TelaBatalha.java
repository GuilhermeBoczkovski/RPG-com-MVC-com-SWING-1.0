package br.ufsc.ine5605.telas;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import br.ufsc.ine5605.controladores.ControladorBatalha;

public class TelaBatalha extends TelaEncontro{
    
/*
    private ControladorBatalha controladorBatalha;
    private Scanner teclado;
    
    public TelaBatalha(ControladorBatalha controladorBatalha){
        super("");
        this.teclado = new Scanner(System.in);
        this.controladorBatalha = controladorBatalha;
    }
    
    public void mostraMenuBatalha(){
        System.out.println("=============================");
        System.out.println("Qual a sua próxima ação?");
        System.out.println("1- Atacar Monstro (escolher feitiço)");
        System.out.println("2- Analizar Monstro");
        System.out.println("3- Ver Feitiços");
        System.out.println("4- Ver Itens");
        System.out.println("5- Usar Item");
        System.out.println("6- Meus Atributos");
        String opcaoString = teclado.nextLine();
        this.controladorBatalha.executaOpcao(opcaoString);
    }
    
    public void mostraAtaque(ConteudoTelaBatalha conteudoTelaAtaqueJogador, ConteudoTelaBatalha conteudoTelaAtaqueMonstro){
        System.out.println(conteudoTelaAtaqueJogador.atacante.getNome() + " ataca " + conteudoTelaAtaqueJogador.atacado.getNome() + " com " + conteudoTelaAtaqueJogador.feitico.getNome());
        System.out.println("Dano causado: " + conteudoTelaAtaqueJogador.danoAtaque);
        System.out.println("A vida do " + conteudoTelaAtaqueJogador.atacado.getNome() + " é: " + conteudoTelaAtaqueJogador.atacado.getVidaAtual() + "/" + conteudoTelaAtaqueJogador.atacado.getVidaTotal());
        System.out.println(conteudoTelaAtaqueMonstro.atacante.getNome() + " ataca " + conteudoTelaAtaqueMonstro.atacado.getNome());
        System.out.println("Dano causado: " + conteudoTelaAtaqueMonstro.danoAtaque);
        System.out.println("A vida do " + conteudoTelaAtaqueMonstro.atacado.getNome() + " é: " + conteudoTelaAtaqueMonstro.atacado.getVidaAtual() + "/" + conteudoTelaAtaqueMonstro.atacado.getVidaTotal());
        if(conteudoTelaAtaqueMonstro.atacado.getVidaAtual()>0){
            this.mostraMenuBatalha();
        }else{
            this.controladorBatalha.gameOver();
        }        
    }
    
    public void mostraFimBatalha(ConteudoTelaBatalha conteudoTela){
        System.out.println("O herói defere um último feitiço de misericórdia no monstro!");
        System.out.println("Dano causado: " + conteudoTela.danoAtaque);
        System.out.println("O poderoso " + conteudoTela.atacado.getNome() + " finalmente cai ao chão!");
        if(conteudoTela.ganhouChave = true){
            System.out.println("Voce encontra a chave para batalhar com o boss final!!");
            System.out.println("A próxima vez que encontrar uma fogueira poderá escolher enfrenta-lo");
            System.out.println("CUIDADO!! Lembre-se que ele eh nivel 10!");
        }
        System.out.println("Você então segue seu caminho...");
        System.out.println("");
    }

    public void mostraAnalise(ConteudoTelaBatalha monstro){
        System.out.println("--ANÁLISE DO MONSTRO--");
        System.out.println("VIDA: " + monstro.monstro.getVidaAtual() + "/" +
                monstro.monstro.getVidaTotal());
        System.out.println("ELEMENTO: " + monstro.monstro.getTipoElemento());
        System.out.println("FORÇA: " + monstro.monstro.getForca());
        System.out.println("ESQUIVA: " + monstro.monstro.getEsquiva() + "%");
        this.mostraMenuBatalha();
    }

    public void mostraItens(ArrayList<ConteudoTelaBatalha> conteudoTelaS, ConteudoTelaBatalha conteudoTela){
        System.out.println("=============================");
        if(conteudoTelaS.size()>0){
            System.out.println("Os Consumíveis são:");
            for(int i = 0; i < conteudoTelaS.size(); i++){
                System.out.println("Índice:        " + i);
                System.out.println("Nome:          " + conteudoTelaS.get(i).consumivel.getNome());
            }
        }else{
            System.out.println("Você não possui consumiveis");
        }
        System.out.println("Sua arma é: ");
        System.out.println("Nome: " + conteudoTela.arma.getNome());
        System.out.println("Dano: +" + conteudoTela.arma.getDano());
        this.mostraMenuBatalha();
    }

    public void mostraFeiticos(ArrayList<ConteudoTelaBatalha> conteudoTelaS){
        System.out.println("=============================");
        if(conteudoTelaS.isEmpty()){
            System.out.println("Voce nao possui feiticos desse tipo");
            this.mostraMenuBatalha();
        }else{
            System.out.println("Os Feitiços são:");
            for(int i = 0; i < conteudoTelaS.size(); i++){
                //System.out.println("Índice:   " + conteudoTelaS.get(i).feitico.getIndice());!!!!
                System.out.println("Nome:     " + conteudoTelaS.get(i).feitico.getNome());
                System.out.println("Dano:     " + conteudoTelaS.get(i).feitico.getDano());
                System.out.println("Elemento: " + conteudoTelaS.get(i).feitico.getTipoElemento());
            }
            this.mostraMenuBatalha();
        }
    }

    public void mostraMenuFeitico(){
        System.out.println("=============================");
        System.out.println("Escolha o tipo de feitico para ver:");
        System.out.println("1 - FOGO");
        System.out.println("2 - AGUA");
        System.out.println("3 - GRAMA");
        System.out.println("4 - PEDRA");
        String opcao = teclado.nextLine();
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.tipoString = opcao;
        this.controladorBatalha.verFeiticos(conteudoTela);
    }

    public void mostraMenuAtaque(ArrayList<ConteudoTelaBatalha> conteudoTelaS){
        System.out.println("=============================");
        System.out.println("Seus feiticos sao:");
        int i = 0;
        for(ConteudoTelaBatalha conteudoTela: conteudoTelaS){
            System.out.println("indice " + i + ": " + conteudoTela.feitico.getNome() + ", tipo:  " + conteudoTela.feitico.getTipoElemento() + ", dano:  +" + conteudoTela.feitico.getDano());
            i++;
        }
        System.out.println("");
        System.out.println("Qual feitiço gostaria de usar?");
        System.out.println("(digite o indice do feitiço)");
        String indiceFeiticoString = teclado.nextLine();
        if(this.controladorBatalha.indiceFeiticoValido(indiceFeiticoString)){
            int indiceFeiticoInt = Integer.parseInt(indiceFeiticoString);
            ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
            conteudoTela.indiceFeitico = indiceFeiticoInt;
            this.controladorBatalha.atacar(conteudoTela);
        }else{
            System.out.println("Numero invalido, tente novamente...");
            this.mostraMenuAtaque(conteudoTelaS);
        }
    }
    
    public void mostraMenuItens(ArrayList<ConteudoTelaBatalha> conteudoTelaS){
        System.out.println("=============================");
        if(conteudoTelaS.isEmpty()){
            System.out.println("Você não possui itens");
            this.mostraMenuBatalha();
        } else {
            System.out.println("Seus itens são: ");
            int contador = 0;
            for(ConteudoTelaBatalha conteudoTela: conteudoTelaS){
                System.out.println(contador + "- " + conteudoTela.consumivel.getNome());
                contador++;
            }
            System.out.println("Qual item gostaria de usar?");
            System.out.println("(digite o indice do item)");
            String indiceItemString = teclado.nextLine();
            int indiceItemInt = Integer.parseInt(indiceItemString);
            ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
            conteudoTela.indiceItem = indiceItemInt;
            this.controladorBatalha.usarItem(indiceItemInt);
        }
    }
    
    public void mostraMeusAtributos(Jogador jogador){
        System.out.println("--ATRIBUTOS DO JOGADOR--");
        System.out.println("NIVEL: " + jogador.getNivelInt());
        System.out.println("VIDA: " + jogador.getVidaAtual() + "/" + jogador.getVidaTotal());
        System.out.println("ESQUIVA: " + jogador.getEsquiva() + "%");
        this.mostraMenuBatalha();
    }

    public void mostraInicioBatalha() {
        System.out.println("");
        System.out.println("Você entra numa sala escura...");
        System.out.println("Começa a entrar mais afundo na sala quando de repente");
        System.out.println("um monstro do tamanho de dois homens aparece na sua frente!!");
        System.out.println("Imediatamente você pega seu cajado e se prepara para a batalha");
        this.mostraMenuBatalha();
    }

    public void mostraOpcaoInvalida() {
        System.out.println("");
        System.out.println("Opcao invalida, tente novamente");
        System.out.println("");
        this.mostraMenuBatalha();
    }

    public void mostraExcecao(String message) {
        System.out.println(message);
    }

    void mostraPassagemNivel(int nivelInicial, int nivelFinal) {
        System.out.println("");
        System.out.println("PARABENS!!");
        System.out.println("O heroi subiu do nivel " + nivelInicial + " para o nivel " +  nivelFinal);
        System.out.println("");
    }

*/
    
    private ControladorBatalha controladorBatalha;
    private JLabel lbNome;
    private JLabel lbNivel;
    private JLabel lbSala;
    private JLabel lbVida;
    private JLabel lbVazia;
    private JLabel lbNomeMonstro;
    private JLabel lbNivelMonstro;
    private JLabel lbVidaMonstro;
    private JLabel  lbNarra1;
    private JLabel  lbNarra2;
    private JLabel  lbNarra3;
    private JLabel  lbNarra4;
    private JLabel lbImgJogador;
    private JLabel lbImgAuxiliar;
    private JButton bt1;
    private JButton bt2;
    private JButton bt3;
    private JButton bt4;
    private JButton bt5;
    private JButton bt6;
    private JButton btVazio;
    
    
    public TelaBatalha(ControladorBatalha controladorBatalha){
        super("");
        this.controladorBatalha = controladorBatalha;
    
        setSize(1024,768);
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
        lbSala.setText("SALA: ");
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
        lbNomeMonstro.setText("NOME MONSTRO: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        container.add(lbNomeMonstro, c);

        lbNivelMonstro = new JLabel();
        lbNivelMonstro.setText("NIVEL MONSTRO: ");
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
        lbImgJogador = new JLabel("IMAGEM JOGADOR");
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 4;
        container.add(lbImgJogador, c);
        
        lbVazia = new JLabel();
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 4;
        container.add(lbVazia, c);
        
        lbImgAuxiliar = new JLabel("IMAGEM MONSTRO");
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 2;
        c.gridy = 4;
        container.add(lbImgAuxiliar, c);
        c.ipady = 0;
        /*----------NARRACAO----------*/
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
        /*----------BOTOES 1----------*/
        bt1 = new JButton();
        bt1.setText("Atacar Monstro");
        bt1.setActionCommand("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 9;
        container.add(bt1, c);
        
        bt2 = new JButton();
        bt2.setText("Analizar Monstro");
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
        bt4.setText("Ver Itens");
        bt4.setActionCommand("4");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 12;
        container.add(bt4, c);
        /*----------BOTOES 2----------*/
        bt4 = new JButton();
        bt4.setText("Usar Item");
        bt5.setActionCommand("5");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 9;
        container.add(bt4, c);
        
        bt5 = new JButton();
        bt5.setText("Meus Atributos");
        bt6.setActionCommand("6");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 10;
        container.add(bt5, c);
        
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
        
        TelaBatalha.GerenciadorDeBotoes btManager = new TelaBatalha.GerenciadorDeBotoes();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mostraAtaque(ConteudoTelaBatalha conteudoTelaAtaqueJogador, ConteudoTelaBatalha conteudoTelaAtaqueMonstro) {
        lbNarra1.setText(conteudoTelaAtaqueJogador.atacante.getNome() + " ataca " + conteudoTelaAtaqueJogador.atacado.getNome() + " com " + conteudoTelaAtaqueJogador.feitico.getNome() + "causando " + conteudoTelaAtaqueJogador.danoAtaque + "de dano");
        lbNarra2.setText(conteudoTelaAtaqueMonstro.atacante.getNome() + " ataca " + conteudoTelaAtaqueMonstro.atacado.getNome() + "causando " + conteudoTelaAtaqueMonstro.danoAtaque + "de dano");
        if(conteudoTelaAtaqueMonstro.atacado.getVidaAtual()<=0){
            this.controladorBatalha.gameOver();
        }
    }

    public void mostraMenuAtaque(ArrayList<ConteudoTelaBatalha> compactados) {
            
            TelaTabelaFeiticos telaFeiticos = new TelaTabelaFeiticos(compactados);
            telaFeiticos.mostraTela();
            telaFeiticos.getIndiceFeitico();
        /*
        int indiceFeitico = 0;
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.indiceFeitico = indiceFeitico;
        this.controladorBatalha.atacar(conteudoTela);
        */
    }
    
    /*
    System.out.println("Seus feiticos sao:");
        int i = 0;
        for(ConteudoTelaBatalha conteudoTela: conteudoTelaS){
            System.out.println("indice " + i + ": " + conteudoTela.feitico.getNome() + ", tipo:  " + conteudoTela.feitico.getTipoElemento() + ", dano:  +" + conteudoTela.feitico.getDano());
            i++;
        }
        System.out.println("");
        System.out.println("Qual feitiço gostaria de usar?");
        System.out.println("(digite o indice do feitiço)");
        String indiceFeiticoString = teclado.nextLine();
        if(this.controladorBatalha.indiceFeiticoValido(indiceFeiticoString)){
            int indiceFeiticoInt = Integer.parseInt(indiceFeiticoString);
            ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
            conteudoTela.indiceFeitico = indiceFeiticoInt;
            this.controladorBatalha.atacar(conteudoTela);
        }else{
            System.out.println("Numero invalido, tente novamente...");
            this.mostraMenuAtaque(conteudoTelaS);
        }
    */
    private class GerenciadorDeBotoes implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            controladorBatalha.executaOpcao(e.getActionCommand());
        }
        
    }
}
