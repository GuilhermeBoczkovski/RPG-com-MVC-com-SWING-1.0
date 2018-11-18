package br.ufsc.ine5605.exception;

public class NomeMuitoGrandeException extends Exception{
    
    public NomeMuitoGrandeException(){
        super("O nome escolhido é grande demais...");
    }
    
}
