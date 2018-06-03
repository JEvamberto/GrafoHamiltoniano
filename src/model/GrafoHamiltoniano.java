/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author jose
 */
public class GrafoHamiltoniano {

    private int[][] incidencia;
    private int[] grauVertice;
    private int ordem;
    boolean visitados[];

    public GrafoHamiltoniano(int tamanho) {

        this.incidencia = new int[tamanho][tamanho];
        this.ordem = tamanho;
        this.grauVertice = new int[ordem];
        this.visitados = new boolean[ordem];

    }

    public void addIncidencia(int v1, int v2) {
        //grafo não orientado;
        this.incidencia[v1][v2] = 1;
        this.incidencia[v2][v1] = 1;

    }

    public void EhHamiltoniano() {

        int verticeInicial = 0;

        Stack pilha = new Stack();
        ArrayList lista[] = new ArrayList[this.ordem];

        for (int verticeEscolhido = 0; verticeEscolhido < this.ordem; verticeEscolhido++) {
            for (int i = 0; i < this.ordem; i++) {

                //Obtendo os vizinhos de cada vertice;
                if (this.incidencia[verticeEscolhido][i] == 1) {

                    if (lista[verticeEscolhido] == null) {
                        lista[verticeEscolhido] = new ArrayList();//Adiciona os vizinhos dos vertices na lista
                    } else {
                        lista[verticeEscolhido].add(i);
                    }

                }

                //Fim de obter os vizinhos
            }
        }
         //Marcando todos como não visitados
        for (int i = 0; i < this.ordem; i++) {
            visitados[i] = false;
        }

        pilha.push(verticeInicial);

        int verticeEscolhido;
        while (!pilha.isEmpty()) {

            verticeEscolhido = (int) pilha.peek();
            visitados[verticeEscolhido] = true;
            //Se o próxmimo vizinho já foi visitado

            if (this.TodosVisitados()
                    && (int) lista[verticeEscolhido].get(lista[verticeEscolhido].size() - 1) == verticeInicial) {
                System.out.println("È um grafo hamiltoniano");
                break;
            }
            //Adiciona na pilha
            if (!(visitados[(int) lista[verticeEscolhido].get(lista[verticeEscolhido].size() - 1)])) {
                pilha.push(lista[verticeEscolhido].remove(lista[verticeEscolhido].size() - 1));
            }
            //remove da da pilha
            
             if (lista[verticeEscolhido].isEmpty()) {//Está não  legal a ordem das coisas
                pilha.pop();
            }
            

        }
        
        if (pilha.isEmpty()) {
            
            System.out.println("Nao é um grafo Hamiltoniano");
        }

    }

    public boolean TodosVisitados() {

        for (int i = 0; i < this.ordem; i++) {
            if (visitados[i] == false) {
                return false;
            }
        }
        return true;
    }

}
