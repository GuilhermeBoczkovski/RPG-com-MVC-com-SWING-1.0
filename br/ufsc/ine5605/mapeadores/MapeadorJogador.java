package br.ufsc.ine5605.mapeadores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import br.ufsc.ine5605.entidades.Jogador;
import java.util.ArrayList;

public class MapeadorJogador {

    private ArrayList<Jogador> cacheJogador = new ArrayList<>();
    private final String filename = "Jogador.jooj";

    public MapeadorJogador(){
        this.load();
    }

    public Jogador get(String nomeJogador){
        int i = 0;
        for(Jogador jogador : cacheJogador){
            if(jogador.getNome().equals(nomeJogador)){
                break;
            }else{
                i++;
            }
        }
        return cacheJogador.get(i);
    }
    
    public Jogador get(int i){
        return cacheJogador.get(i);
    }
    
    public void put(Jogador jogador){
        cacheJogador.add(jogador);
        persist();
    }
    
    public void exclude(int i){
        cacheJogador.remove(i);
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

            this.cacheJogador = (ArrayList) oIn.readObject();

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

    public ArrayList<Jogador> getList(){
        return this.cacheJogador;
    }
}