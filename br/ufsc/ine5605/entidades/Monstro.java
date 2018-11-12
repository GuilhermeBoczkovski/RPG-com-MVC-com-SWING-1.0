package br.ufsc.ine5605.entidades;

import br.ufsc.ine5605.entidades.Ser;
import br.ufsc.ine5605.entidades.TipoElemento;

public class Monstro extends Ser{
    private int forca;
    private double esquiva;
    private TipoElemento tipoElemento;

    public Monstro(int nivel , TipoElemento tipoElemento) {
        super("Monstro nivel: " + nivel);
        super.setVidaAtual(10+(10*nivel));
        super.setVidaTotal(10+(10*nivel));
        this.forca = (int)((Math.random()*((0.2*super.getVidaTotal() - 0.10*super.getVidaTotal()) + 1))+0.10*20);
        this.esquiva = 1.5 + 0.1*nivel;
        this.tipoElemento = tipoElemento;
    }

    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }

    public void setTipoElemento(TipoElemento tipoElemento) {
        this.tipoElemento = tipoElemento;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public double getEsquiva() {
        return esquiva;
    }

    public void setEsquiva(int esquiva) {
        this.esquiva = esquiva;
    }
    
    
}
