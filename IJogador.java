package rpgcommvccomswing;

import java.util.ArrayList;

public interface IJogador {
    
    public ArrayList<Feitico> verFeiticos(TipoElemento tipo);
    
    public void addFeitico(Feitico feitico);
    
    public void delFeitico(String nome) throws FeiticoNaoListadoException;
    
    public void trocaArma(Arma arma);
}
