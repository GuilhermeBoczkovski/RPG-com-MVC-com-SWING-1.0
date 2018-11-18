package br.ufsc.ine5605.exception;

public class NomeVazioException extends Exception{
    
    public NomeVazioException(){
        super("O nome não pode estar vazio...");
    }
    
}
