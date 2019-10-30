/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import graph.Graph;
import graph.Vertex;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Vinicius Silva
 */
public class Dijkstra{
    // Atributos usados na funcao encontrarMenorCaminho

	// Lista que guarda os vertices pertencentes ao menor caminho encontrado
	List<Vertex> menorCaminho = new ArrayList<Vertex>();

	// Variavel que recebe os vertices pertencentes ao menor caminho
	Vertex verticeCaminho = new Vertex();

	// Variavel que guarda o vertice que esta sendo visitado
	Vertex atual = new Vertex();

	// Variavel que marca o vizinho do vertice atualmente visitado
	Vertex vizinho = new Vertex();

	// Lista dos vertices que ainda nao foram visitados
	List<Vertex> naoVisitados = new ArrayList<Vertex>();
        
     // Algoritmo de Dijkstra
    public List<Vertex> encontrarMenorCaminhoDijkstra(Graph grafo,Vertex v1,Vertex v2){
       	// Adiciona a origem na lista do menor caminho
	menorCaminho.add(v1);

	// Colocando a distancias iniciais
	for (int i = 0; i < grafo.getVertices().size(); i++){
            // Vertice atual tem distancia zero, e todos os outros,
            // 9999("infinita")
            if (grafo.getVertices().get(i).getNome().equals(v1.getNome())) {
		grafo.getVertices().get(i).setDistancia(0);
            }else{
                grafo.getVertices().get(i).setDistancia(9999);
            }// End else
            // Insere o vertice na lista de vertices nao visitados
            this.naoVisitados.add(grafo.getVertices().get(i));
	}// End for
        Collections.sort(naoVisitados);

        // O algoritmo continua ate que todos os vertices sejam visitados
        while(!this.naoVisitados.isEmpty()){
            atual = this.naoVisitados.get(0);
            System.out.println("Pegou esse vertice:  " + atual);
            for(int i = 0; i < atual.getArestas().size(); i++) {
                vizinho = atual.getArestas().get(i).getFinalVertex();
                System.out.println("Olhando o vizinho de " + atual + ": "+ vizinho);
                if(!vizinho.verificarVisita()){
                    if(vizinho.getDistancia() > (atual.getDistancia() + atual.getArestas().get(i).getPeso())){
                        vizinho.setDistancia(atual.getDistancia() + atual.getArestas().get(i).getPeso());
                        vizinho.setPai(atual);
                        if(vizinho == v2){
                            menorCaminho.clear();
                            verticeCaminho = vizinho;
                            menorCaminho.add(vizinho);
                            while(verticeCaminho.getPai() != null){
                                menorCaminho.add(verticeCaminho.getPai());
                                verticeCaminho = verticeCaminho.getPai();
                            }// End while
                            // Ordena a lista do menor caminho, para que ele
                            // seja exibido da origem ao destino.
                            Collections.sort(menorCaminho);
                        }// End if
                    }// End if
                }// End if
             }// End for
            // Marca o vertice atual como visitado e o retira da lista de nao
            // visitados
            atual.visitar();
            this.naoVisitados.remove(atual);
            Collections.sort(naoVisitados);
            System.out.println("Nao foram visitados ainda:"+naoVisitados);

        }// End while
        return menorCaminho;
    }// End encontrarMenorCaminhoDijkstra()
    
    public void clear(){
        this.menorCaminho.clear();
        this.verticeCaminho = null;
        this.atual = null;
        this.vizinho = null;
        this.naoVisitados.clear();
    }// End clear()
    
    public void set(){
        this.menorCaminho = new ArrayList<Vertex>();
        this.verticeCaminho = new Vertex();
        this.atual = new Vertex();
        this.vizinho = new Vertex();
        this.naoVisitados = new ArrayList<Vertex>();
    }// End set()
}// End class Dijkstra
