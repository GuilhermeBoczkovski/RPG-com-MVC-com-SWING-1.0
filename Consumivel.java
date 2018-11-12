package rpgcommvccomswing;

public class Consumivel extends Item{
    
    public Consumivel(String nome){
        super(nome);
    }
    
    /**
     * retorna um valor que sera adicionado a vida do jogador
     * ideia:
     * receber o nivel do jogador e calcular a vida a ser restaurada apartir disso
     * @return int = valor a restaurar
     */
    public int restauraVida(int vidaTotal){
        double vidaRestaurada = vidaTotal * 0.25;
        return (int)vidaRestaurada;
    }
    
}
