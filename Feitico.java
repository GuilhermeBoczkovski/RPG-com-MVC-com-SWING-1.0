package rpgcommvccomswing;

public class Feitico {

    private final String nome;

    private final int dano;

    private final int nivel;

    private final TipoElemento tipoElemento;
    
    Feitico(int nivel, String nome, TipoElemento tipoElemento) {
        this.nome = nome;
        this.nivel = nivel;
        int vida = (4*nivel)+16;
        this.dano = (int) ((Math.random() * ((0.30*vida - 0.15*vida) + 1)) + 0.15*vida);
        this.tipoElemento = tipoElemento;
    }

    public String getNome(){
        return nome;
    }
    public int getDano(){
        return dano;
    }
    public TipoElemento getTipoElemento(){
        return tipoElemento;
    }
    
}
