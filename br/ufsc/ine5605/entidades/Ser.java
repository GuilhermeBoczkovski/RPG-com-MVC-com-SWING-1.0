package br.ufsc.ine5605.entidades;

import java.io.Serializable;

public class Ser implements Serializable{
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
