/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import java.util.ArrayList;

/**
 *
 * @author Vinicius Silva
 */
public class Solucao{
    /** 
     * Atributes
     */
    private int distanciaMinima;
    private ArrayList<Integer> caminho;

    /**
     * Constructor: Solucao
     */
    public Solucao(){
        setDistanciaMinima(0);
        setCaminho(new ArrayList<Integer>());
    }// End Solucao()
    
    /**
     * Constructor: Solution
     */
    public Solucao(ArrayList<Integer> caminho, int distanciaMinima) {
        setDistanciaMinima(distanciaMinima);
        setCaminho(caminho);
    }// End Solucao()
    
    /**
     * toS
     */
    public String toS(){
        String toS = "";
        toS += "Distância Mínima: " + distanciaMinima;
        toS += "\nCaminho: ";
        for(int i = 0; i < caminho.size(); i++){
            if(i < caminho.size()-1)
                toS += (caminho.get(i) + 1) + " -> "; 
            else
                toS += (caminho.get(i) + 1);
        }// End for
        return toS;
    }// End toS()
    
    /**
     * @param distanciaMinima setar distancia minima
     */
    public void setDistanciaMinima(int distanciaMinima){
        this.distanciaMinima = distanciaMinima;
    }// End setDistanciaMinima()
    
    /**
     * incrementarDistancia
     */
    public void incrementarDistancia(int distancia){
        distanciaMinima += distancia;
    }// End incrementarDistancia()
    
    /**
     * @param caminho setar o caminho
     */
    public void setCaminho(ArrayList<Integer> caminho){
            this.caminho = caminho;
    }// End setCaminho()
    
    /**
     * getTamanhoCaminho
     */
    public int getTamanhoCaminho(){
        return caminho.size();
    }// End getTamanhoCaminho()
    
    /**
     * getUltimaCidade
     */
    public int getUltima() {
        return caminho.get(caminho.size()-1);
    }// End getUltima()
    
    /**
     * addCidadeNoCaminho
     */
    public void addNoCaminho(int value){
        caminho.add(value);
    }// End addNoCaminho()
    
    /**
     * getCaminho
     */
    public ArrayList<Integer> getCaminho(){
        return (ArrayList<Integer>) caminho.clone();
    }// End getCaminho()
    
    /**
     * getDistanciaMinima
     */
    public int getDistanciaMinima(){
        int aux = distanciaMinima;
        return aux;
    }// End getDistanciaMinima()
}// End Solucao
