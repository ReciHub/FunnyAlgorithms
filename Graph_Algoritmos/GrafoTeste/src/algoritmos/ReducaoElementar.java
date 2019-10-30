/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import graph.Graph;

/**
 *
 * @author Vinicius Silva
 */
public class ReducaoElementar{
    private Graph graph;
    private int[][] matriz;
    
    public ReducaoElementar(Graph g){
        this.graph = g;
        this.matriz = g.getAdjacencia();
    }// End ReducaoElementar()
    
    public int[][] reducaoElementar(){
        for(int i = 0; i < graph.getN(); i++){
            for(int j = 0; j < graph.getN(); j++){
                if(i == j){
                    matriz[i][j] = 0;
                }else if(i < (graph.getN()-1) && j < (graph.getN())){
                    matriz[i][j] = 0;
                }// End else if
            }// End for
        }// End for
        return matriz;
    }// End reducaoElementar()
}// End ReducaoElementar()
