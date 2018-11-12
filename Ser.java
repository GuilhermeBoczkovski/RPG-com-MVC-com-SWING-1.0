package rpgcommvccomswing;

class Ser {
    private final String nome;
    private int vidaAtual;
    private int vidaTotal;
    
    public Ser(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getVidaAtual(){
        return this.vidaAtual;
    }
    
    public int getVidaTotal(){
        return this.vidaTotal;
    }
    
    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }
    
    public void setVidaTotal(int vidaTotal) {
        this.vidaTotal = vidaTotal;
    }
}
