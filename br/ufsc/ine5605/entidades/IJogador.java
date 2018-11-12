package br.ufsc.ine5605.entidades;

import br.ufsc.ine5605.exception.FeiticoNaoListadoException;
import br.ufsc.ine5605.entidades.Arma;
import br.ufsc.ine5605.entidades.Feitico;
import br.ufsc.ine5605.entidades.TipoElemento;
import java.util.ArrayList;

public interface IJogador {
    
    public ArrayList<Feitico> verFeiticos(TipoElemento tipo);
    
    public void addFeitico(Feitico feitico);
    
    public void delFeitico(String nome) throws FeiticoNaoListadoException;
    
    public void trocaArma(Arma arma);
}
