package br.ufsc.ine5605.main;



import br.ufsc.ine5605.entidades.Feitico;
import br.ufsc.ine5605.telas.TelaTabelaFeiticos;
import br.ufsc.ine5605.entidades.TipoElemento;
import br.ufsc.ine5605.telas.ConteudoTelaBatalha;
import java.util.ArrayList;

public class RpgComMVC {

    public static void main(String[] args) {
        
        ConteudoTelaBatalha contTela1 = new ConteudoTelaBatalha();
        ConteudoTelaBatalha contTela2 = new ConteudoTelaBatalha();
        ConteudoTelaBatalha contTela3 = new ConteudoTelaBatalha();
        ConteudoTelaBatalha contTela4 = new ConteudoTelaBatalha();
        contTela1.feitico = new Feitico(1, "1", TipoElemento.AGUA);
        contTela2.feitico = new Feitico(1, "2", TipoElemento.FOGO);
        contTela3.feitico = new Feitico(1, "3", TipoElemento.GRAMA);
        contTela4.feitico = new Feitico(1, "4", TipoElemento.PEDRA);
        ArrayList<ConteudoTelaBatalha> arr = new ArrayList<>();
        arr.add(contTela1);
        arr.add(contTela2);
        arr.add(contTela3);
        arr.add(contTela4);
        TelaTabelaFeiticos tela = new TelaTabelaFeiticos(arr);
        tela.mostraTela();
        
        //ControladorGeral ctrlG = new ControladorGeral();
    }
    
}
