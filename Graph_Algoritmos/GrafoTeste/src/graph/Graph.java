/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.Group;

/**
 *
 * @author Vinicius Silva
 */
public class Graph{
    private int[][] adjacencia;
    private Map<String,Edge> map;
    private List<Vertex> vertex;
    private int n;

    public Graph(){
        
    }// End Graph()
    
    public Graph(int n,List<Vertex> vertex){
        this.n = n;
        this.adjacencia = new int[n][n];
        this.map = new HashMap<>();
        this.vertex = vertex;
        this.map = new HashMap<>();
    }// End Graph()
    
    public Graph(int[][] adjacencia){
      this.n = adjacencia.length;
      this.adjacencia = adjacencia;
    //  this.map = new HashMap<>();
    }// End Graph()
    
  //  public Graph(int[][] adjacencia,Map<String,Circle> map){
    
   //}// End Graph()
    
    public void addAdjacencia(int i,int j,Vertex v1,Vertex v2,double valor){
        this.adjacencia[i][j] = 1;
        Edge edge = new Edge(v1,v2);
        edge.setPeso((int)valor);
        this.map.put(i+""+j,edge);
        v1.addAdj(edge);
        v2.addAdj(edge);
        v1.setGrau(v1.getArestas().size());
        v2.setGrau(v1.getArestas().size());    
    }// End Vertex
    
    public Group setGroup(int i,int j,Group group){
        return this.map.get(i+""+j).setGroup(group);
    }// End setGroup
    
    public List<Vertex> getVertices(){
        return this.vertex;
    }// End getVertices()

    public int getN(){
        return n;
    }// End getN()

    public void setN(int n){
        this.n = n;
    }// End setN()

    public int[][] getAdjacencia(){
        return adjacencia;
    }// End getAdjacencia()

    public void setAdjacencia(int[][] adjacencia) {
        this.adjacencia = adjacencia;
    }// End setAdjacencia()

    public Map<String,Edge> getMap(){
        return map;
    }// End getMap()

    public void setMap(Map<String,Edge> map){
        this.map = map;
    }// End setMap()

    public List<Vertex> getVertex(){
        return vertex;
    }// End getVertex()

    public void setVertex(List<Vertex> vertex){
        this.vertex = vertex;
    }// End setVertex()
}// End Graph()
