package rpgcommvccomswing;

public class Arma extends Item{
    private int dano;
    
    public Arma(int nivel){
        super("Cajado magico de nivel " + nivel);
        double dano = 3 + (1.5 * nivel);
        this.dano = (int) dano;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
    
}
