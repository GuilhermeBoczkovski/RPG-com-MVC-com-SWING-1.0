package rpgcommvc;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class TelaBauSwing extends JFrame{
    
    
    private JLabel text;
    private JLabel lbl;
    private JLabel txtGrimorio;
    private JLabel txtArma;
    private JLabel txtConsumivel;
    private JLabel textArma;
    private JLabel textConsumivel;
    private JLabel textGrimorio;

    
    private ControladorBau ctrlBau;
    private boolean temArma;
    private boolean temGrimorio;
    private boolean temConsumivel;
    
    public TelaBauSwing(ControladorBau aThis){
        super("Bau");
        
        this.ctrlBau = aThis;
        
        ConteudoTelaBau itens = ctrlBau.compactarItensBoolean();
        this.temArma = itens.temArma;
        this.temGrimorio = itens.temGrimorio;
        this.temConsumivel = itens.temConsumivel;
        
        setSize(1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        lbl = new JLabel();
        lbl.setText("Voce encontrou um baú!");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lbl, c);
        
        text = new JLabel();
        text.setText("Voce abre e é isso que voce encontra...");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        container.add(text, c);
        
        if(temArma){
            txtArma = new JLabel();
            txtArma.setText("Uma arma.");
            c.fill = GridBagConstraints.HORIZONTAL;
            //c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 2;
            container.add(txtArma, c);
        }
        if(temGrimorio){
            txtGrimorio = new JLabel();
            txtGrimorio.setText("Um grimorio.");
            c.fill = GridBagConstraints.HORIZONTAL;
            //c.weightx = 0.5;
            c.gridx = 1;
            c.gridy = 2;
            container.add(txtGrimorio, c);
        }
        if(temConsumivel){
            txtConsumivel = new JLabel();
            txtConsumivel.setText("Um consumivel.");
            c.fill = GridBagConstraints.HORIZONTAL;
            //c.weightx = 0.5;
            c.gridx = 2;
            c.gridy = 2;
            container.add(txtConsumivel, c);
        }
        
    }
    
    public void mostraTelaBau(){
        setVisible(true);
    }
    
    public void ocultaTelaBau(){
        setVisible(false);
    }
}

