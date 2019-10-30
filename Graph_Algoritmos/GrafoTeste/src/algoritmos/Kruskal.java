/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Vinicius Silva
 */
public class Kruskal{
    private static Random r;
    private static float menorCaminho = 0;
    private ArrayList<Edge> grafoGerado;
    ArrayList<Edge> menorGrafo;
    private static List<Vertex> listaVertices;
    private static ArrayList<Edge> listaArestas;

    private ArrayList<Vertex> conjuntoDisjunto;
    private int sementeAleatoria;
    private int numeroPontos;
    private int maxArestas;
    private Graph g;
        
        
    public Kruskal(int numeroPontos,Graph g){
        // TODO Auto-generated constructor stub
        this.numeroPontos = numeroPontos;
        this.maxArestas = (this.numeroPontos * (this.numeroPontos - 1)) / 2;
        this.sementeAleatoria = 10;
        
        this.g = g;
        listaVertices = g.getVertices();
        listaArestas = new ArrayList<Edge>(this.maxArestas);
        menorGrafo = new ArrayList<Edge>();
        r = new Random();
        geradorVerticesAleatorios(sementeAleatoria,this.numeroPontos,maxArestas);
    }// End Kruskal()
    
    
     public float geradorVerticesAleatorios(int seed, int numeroPontos, int maxArestas){    
         //Popula lista com pontos aleatÃ³rios
        for (int i = 0; i < numeroPontos; i++){
            listaVertices.get(i).setX(r.nextInt(Integer.MAX_VALUE)%20);
            listaVertices.get(i).setY(r.nextInt(Integer.MAX_VALUE)%13);
        }// End for						 
        
        //Matriz de AdjacÃªncia
        for(int i = 0; i < numeroPontos; i++){
          for(int j = 0; j < numeroPontos; j++){
            if(i != j && this.g.getMap().get(i+""+j) != null){
                Vertex u = listaVertices.get(i);
                Vertex v = listaVertices.get(j);             
                Edge e = this.g.getMap().get(i+""+j);
                e.setPeso((int)distanciaEntrePontos(u,v));
                listaArestas.add(e);
            }// End if	        
          }// End for
        }// End for

        grafoGerado = new ArrayList<Edge>();

        //Ordena arestas crescentemente
        Collections.sort(listaArestas);

        //Kruskal
        for(Edge e : listaArestas){
          Vertex u = e.getInitialVertex();
          Vertex v = e.getFinalVertex();
          
          if(procurar(u) != procurar(v)) { // u e v nÃ£o sao do mesmo conjunto
            grafoGerado.add(e);	        
            unir(u,v);
          }// End if
        }// End for

        int cont = 1;
        for(Edge e : grafoGerado){
            System.out.print("Aresta: "+cont++);
            System.out.print(" - U"+"("+e.getInitialVertex().getX()+","+e.getInitialVertex().getY()+")");
            System.out.println(" - V"+"("+e.getFinalVertex().getX()+","+e.getFinalVertex().getY()+")"); 	
            menorCaminho += Math.sqrt(e.getPeso());
        }// End for	    

        System.out.println("Tamanho da arvore: "+ grafoGerado.size());

        //REMOVER ARESTAS COINCIDENTES

        for (Edge aresta : grafoGerado){
            if(aresta.getInitialVertex().getX() == aresta.getFinalVertex().getX() &&
               aresta.getInitialVertex().getY() == aresta.getFinalVertex().getY()){
            }else{
                menorGrafo.add(aresta);
            }// End else	
        }// End for

        System.out.println("Total da Árvore minima: "+ menorGrafo.size());
        System.out.println("\t Tamanho do percurso "+menorCaminho);
        return menorCaminho;
    }// End getRandom()
	  
    public ArrayList<Edge> getMenorGrafo(){
        return this.grafoGerado;
    }// End getMenorGrafo()
    
    public int procurar(Vertex no){
        Vertex noAux = no;
        //Busca pai
        while(noAux.getPai() != null) noAux = noAux.getPai();
        
        int i = 0;
        while(!noAux.getNome().equals(listaVertices.get(i).getNome())) i++;
        return i;
    }// End procurar()
    
    public static float distanciaEntrePontos(Vertex a, Vertex b) {
        return (float) (Math.pow((b.getY() - a.getY()), 2) + Math.pow((b.getX() - a.getX()), 2));
    }// End distanciaEntrePontos()
    
     public void unir(Vertex u, Vertex v) {
        int indiceU = procurar(u);
        int indiceV = procurar(v);

        //Nos são do mesmo cunjunto
        if(indiceU == indiceV) return;
        //Busca os nós pais na lista de nós
        Vertex noA = this.listaVertices.get(indiceU);
        Vertex noB = this.listaVertices.get(indiceV);
            
        //Concatena o menor grafo no maior grafo
        if(noA.getGrau() < noB.getGrau()){
          noA.setPai(noB);
        }else if(noA.getGrau() > noB.getGrau()){
          noB.setPai(noA);
        }else{
          noB.setPai(noA);
          noA.setGrau(noA.getGrau()+1);
            }// End else if
    }// End unir()
}// End Kruskal
