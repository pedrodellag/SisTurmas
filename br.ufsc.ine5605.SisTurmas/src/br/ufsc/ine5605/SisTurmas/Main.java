/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.SisTurmas;

import br.ufsc.ine5605.SisTurmas.Controle;

/**
 *
 * @author 11832332993
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controle controle = new Controle();
        controle.inicia();
        //  Alternativo - - - > ( new Controle() ).inicia();
    }
    
}
