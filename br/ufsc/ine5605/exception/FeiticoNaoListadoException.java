/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.exception;

/**
 *
 * @author guilh
 */
public class FeiticoNaoListadoException extends Exception {

    public FeiticoNaoListadoException(){
        super("Feitiço pedido não está listado");
    }
    
}
