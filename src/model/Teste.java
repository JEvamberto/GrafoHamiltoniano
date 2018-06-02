/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jose
 */
public class Teste {
    
    public static void main(String[] args) {
        Grafo grafo= new Grafo(3);
        
        grafo.addIncidencia(0, 1);
        grafo.addIncidencia(1, 2);
        grafo.addIncidencia(2, 0);
        grafo.EhHamiltoniano();
        
        
    }
    
}
