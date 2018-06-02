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
public class Grafo {
    
    private int[][] incidencia;
    private int [] grauVertice; 
    private int ordem;
    
    public Grafo(int tamanho){
        
        this.incidencia=new int [tamanho][tamanho];
        this.ordem=tamanho;
        this.grauVertice=new int [ordem];
    }
    
    public void  addIncidencia (int v1,int v2){
        //grafo não orientado;
        this.incidencia[v1][v2]=1;
        this.incidencia[v2][v1]=1;
        
        
    
    }
    
    //calcular grauDoVertice;
    
    private void CalcularGrauDeVertice(){
    
        for (int i = 0; i < this.ordem; i++) {
            for (int j = 0; j < this.ordem; j++) {
                this.grauVertice[i]=this.grauVertice[i]+this.incidencia[i][j];
            }
        }
    
    }
    
    public boolean EhHamiltoniano(){
        
        //Teorema: Se G é um grafo de ordem p (>=3) tal que o grau(v) >= p/2 para cada vértice v de G, 
        //então G é hamiltoniano.

      this.CalcularGrauDeVertice();
        
       int P=ordem/2;
        
        if (this.ordem<3) {
            System.out.println("Não hamiltoniano");
            return false;
            
        }else{
        
            for (int i = 0; i < this.ordem; i++) {
               
                if (this.grauVertice[i]< P) {
                    System.out.println("Não é um grafo hamiltoniano");
                    return false;
                    
                   
                }

                
            }
        
        }
        
        
        System.out.println("É um grafo hamiltoniano");
        return true;
    }
    
    
    
    
    
    
    
}
