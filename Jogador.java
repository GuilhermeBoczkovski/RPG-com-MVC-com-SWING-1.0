package rpgcommvccomswing;

import java.util.ArrayList;

public class Jogador extends Ser implements IJogador {
    
    private static final long serialVersionUID = 1L;
    
    private double nivel;
    private boolean possuiChave;
    private double esquiva;
    private int grimorios;
    private final Diario diario;
    private ArrayList<Feitico> feiticos = new ArrayList<>();
    private Arma arma;
    private final Bolsa bolsa = new Bolsa();

    public Jogador(String nome) {
        super(nome);
        this.nivel = 1.5;
        super.setVidaAtual(10+(this.getNivelInt()*10));
        super.setVidaTotal(10+(this.getNivelInt()*10));
        this.possuiChave = false;
        this.esquiva = 1.5;
        this.grimorios = 0;
        this.diario = new Diario();
        this.feiticos.add(new Feitico(this.getNivelInt(), "Pedregulhos Sinistros", TipoElemento.PEDRA));
        this.arma = new Arma(this.getNivelInt());
    }

    public Jogador(int nivel, String nome){
        super(nome);
        this.nivel = nivel;
        super.setVidaAtual(10+(10*nivel));
        super.setVidaTotal(10+(10*nivel));
        this.possuiChave = true;
        this.esquiva = 1.5 + 0.1*nivel;
        this.grimorios = 15;
        this.diario = new Diario();
        this.arma = new Arma(this.getNivelInt());
        this.feiticos.add(new Feitico(this.getNivelInt(), "Pedregulhos Sinistros", TipoElemento.PEDRA));
        this.feiticos.add(new Feitico(this.getNivelInt(), "Furia de Poseidon", TipoElemento.AGUA));
        this.feiticos.add(new Feitico(this.getNivelInt(), "Chama do Dragão", TipoElemento.FOGO));
        this.feiticos.add(new Feitico(this.getNivelInt(), "Erva Venenosa", TipoElemento.GRAMA));
        this.bolsa.addConsumivel(new Consumivel("Pocao de Vida"));
        this.bolsa.addConsumivel(new Consumivel("Pocao de Vida"));
        this.bolsa.addConsumivel(new Consumivel("Pocao de Vida"));
        this.bolsa.addConsumivel(new Consumivel("Pocao de Vida"));
    }
    
    public ArrayList<Feitico> verFeiticos(TipoElemento tipo){
        ArrayList<Feitico> feiticosDoTipo = new ArrayList();
        for(Feitico feitico : feiticos){
            if(feitico.getTipoElemento() == tipo){
                feiticosDoTipo.add(feitico);
            }
        }
        return feiticosDoTipo;
    }
    
    public void addFeitico(Feitico feitico){
        this.feiticos.add(feitico);
    }
    
    public void delFeitico(String nome){
        boolean existe = false;
        try{
            for(Feitico feitico : feiticos){
                if(feitico.getNome().equals(nome)){
                    existe = true;
                    feiticos.remove(feitico);
                    break;
                }
            }
            if(!existe){
                throw new FeiticoNaoListadoException();
            }
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    public void delFeitico(int indice){
        feiticos.remove(indice);
    }
    
    public void trocaArma(Arma arma){
        this.arma = arma;
    }
    
    public void ganhaExperiencia(){
        double nivelInicial = this.getNivelInt();
        this.nivel = nivel + 2/nivel;
        if(nivel-nivelInicial >=1){
            this.setEsquiva(this.getEsquiva()+0.1);
            this.setVidaTotal(10+(this.getNivelInt()*10));
            this.setVidaAtual(this.getVidaTotal());
        }
    }
    
    public void usarItem(int indice) {
        Consumivel item = this.bolsa.getConsumivel(indice);
        int vidaExtra = item.restauraVida(this.getVidaTotal());
        this.bolsa.dellConsumivel(indice);
        
        this.setVidaAtual(this.getVidaAtual() + vidaExtra);
        
        if(this.getVidaAtual()>this.getVidaTotal()){
            this.setVidaAtual(this.getVidaTotal());
        }
    }
    
/*------------GET-------------*/
    public double getNivel() {
        return this.nivel;
    }
    public int getNivelInt() {
        return (int)this.nivel;
    }
    public boolean getPossuiChave() {
        return this.possuiChave;
    }
    public double getEsquiva() {
        return this.esquiva;
    }
    public int getGrimorios() {
        return this.grimorios;
    }
    public Diario getDiario() {
        return this.diario;
    }
    public Arma getArma() {
        return this.arma;
    }
    public ArrayList<Feitico> getFeiticos() {
        return this.feiticos;
    }
    public Consumivel getConsumivelBolsa(int indice){
        return this.bolsa.getConsumivel(indice);
    }
    public ArrayList<Consumivel> getConsumiveisBolsa(){
        return this.bolsa.verConsumiveis();
    }
    public Feitico getFeitico(int i){
        return this.feiticos.get(i);
    }
/*------------SET--------------*/
    public void setNivel(double nivel) {
        this.nivel = nivel;
    }
    public void setPossuiChave(boolean possuiChave) {
        this.possuiChave = possuiChave;
    }
    public void setEsquiva(double esquiva) {
        this.esquiva = esquiva;
    }
    public void setGrimorios(int grimorios) {
        this.grimorios = grimorios;
    }
    public void setArma(Arma arma) {
        this.arma = arma;
    }
    public void setFeiticos(ArrayList<Feitico> feiticos) {
        this.feiticos = feiticos;
    }
/*------------ACTION------------*/
    public void addConsumivelBolsa(Consumivel consumivel){
        this.bolsa.addConsumivel(consumivel);
    }
    public void dellConsumivelBolsa(int indice){
        this.bolsa.dellConsumivel(indice);
    }
}
