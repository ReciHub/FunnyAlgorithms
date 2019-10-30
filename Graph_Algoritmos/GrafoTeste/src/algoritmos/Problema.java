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
public class Problema{
    private int numero;
    private ArrayList<ArrayList<Integer>> distancias;
    /**
     * Constructor: Problema
     */
    public Problema(int n, ArrayList<ArrayList<Integer>> distancias) {
        setNumero(n);
        setDistancias(distancias);
    }// End Problema()
    /**
     * showInfoProblema
     */
    public String toS(){
        String toS = "";
        toS += "Número de cidades: " + numero + "\nDistâncias: ";
        for(int i = 0; i < distancias.size(); i++) {
            toS += "\n" + (i+1) + ": ";
            for (int j = 0; j < distancias.get(i).size(); j++) {
                toS += (j+1) + "(" + distancias.get(i).get(j) + ") ";
            }// End for
        }// End for
        return toS;
    }// End toS()
   
    public int getNumero(){
        int aux = numero;
        return aux;
    }// End getNumero()
   
    public void setNumero(int numero){
        this.numero = numero;
    }// End setNumeroDeCidades()
    
    /**
     * @return distancia
     */
    public int getDistancia(int de, int para){
        return distancias.get(de).get(para);
    }// End getDistancia()
    
    /**
     * @param distancias setar distancias
     */
    public void setDistancias(ArrayList<ArrayList<Integer>> distancias){
        this.distancias = distancias;
    }// End setDistancias()
}// End Prol
