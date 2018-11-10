package rpgcommvccomswing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;

public class MapeadorJogador {

    private HashMap<String, Jogador> cacheJogador = new HashMap<>();
    private final String filename = "Jogador.jooj";

    public MapeadorJogador(){
        this.load();
    }

    public Jogador get(String nomeJogador){
        return cacheJogador.get(nomeJogador);
    }

    public void put(Jogador jogador){
        cacheJogador.put(jogador.getNome(), jogador);
        persist();
    }

    public void persist(){
        try {
            FileOutputStream fOut = new FileOutputStream(filename); 
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(cacheJogador);

            oOut.flush();
            fOut.flush();

            oOut.close();
            fOut.close();

        } catch (FileNotFoundException ex){
            System.out.println(ex);
        } catch (IOException ex){
            System.out.println(ex);
        }
    }

    public void load(){
        try {
            FileInputStream fIn = new FileInputStream(filename);
            ObjectInputStream oIn = new ObjectInputStream(fIn);

            this.cacheJogador = (HashMap) oIn.readObject();

            oIn.close();
            fIn.close();

        } catch (FileNotFoundException ex){
            System.out.println("ERRO AO ENCONTRAR O ARQUIVO");
        this.persist();
        } catch (ClassNotFoundException ex){
            System.out.println("ERRO AO ENCONTRAR O ARQUIVO");
        } catch (IOException ex){
            System.out.println("ERRO AO ENCONTRAR O ARQUIVO");
        }
    }

    public Collection getList(){
        return this.cacheJogador.values();
    }
}