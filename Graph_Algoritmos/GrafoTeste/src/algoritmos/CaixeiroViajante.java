/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Vinicius Silva
 */
public class CaixeiroViajante {
    private static int INFINITY = Integer.MAX_VALUE;
    private static int path[][]; //matriz de caminhos minimos
    private static int dp[][]; //matriz de custos
    private static int thisDistanceMatrix[][];
    private static int startVertex = 0;	

    public static int[][] computeTSP(int[][] distanceMatrix){
        ArrayList<Integer> s = new ArrayList<Integer>();	//Conjunto S
        int n = distanceMatrix.length;
        thisDistanceMatrix = distanceMatrix;
        int npow = (int) Math.pow(2, n) - 1; //15

        dp = new int[n][npow]; //matriz de custo
        path = new int[n][npow]; //matriz caminho

        for(int i = 0; i < n; i++) dp[i][startVertex] = distanceMatrix[i][startVertex];
        int countS = 1; // |S|        
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();	

        while(countS < n - 1){
            for(int currentVertex = 1; currentVertex < n; currentVertex++){
                for (int city = 1; city < n; city++)
                        if(currentVertex != city)
                                s.add(city);				 
                permutations = permute(s, countS);
                for (int k = 0; k < permutations.size(); k++)
                    minCost(currentVertex, permutations.get(k)); //atualiza matrizes dp e path				
                s.clear();
                permutations.clear();
            }// End for		
            countS++;
        }// End while

        /* Calculando custo minimo final */
        for (int city = 1; city < n; city++)//todas as cidades menos a primeira (current)
                s.add(city);

        minCost(startVertex, s);
        System.out.println("Minimum cost: " + dp[startVertex][npow-1]);
        /* Get min Path */
        System.out.println("Minimum tour: "+Arrays.toString(getMinPath(s)));
        return path;
    }// End computeTSP()

    private static void minCost(int val, ArrayList<Integer> s){
        int col = numArray2int(s);	//valor da coluna que sera guardado 2elevN		
        int min = INFINITY;
        int index = -1;

        for(int j: s){
            index++;
            //Calcular o g usando cada elemento de S, já aproveitando o valores da matriz de acumulação
            int cost = thisDistanceMatrix[val][j] + dp[ j ][ col - (int) (Math.pow(2, j)) ];
            if(cost < min){
                min = cost;
                dp[val][col] = min;
                path[val][col] = s.get(index);
            }// End if
        }// End for	
    }// End mainCost()

    private static int[] getMinPath(ArrayList<Integer> s){
        int[] minPath = new int[s.size() + 2]; // 0 -> {...} -> 0
        minPath[0] = 0;
        int col = 0;
        int row = 0;
        int min = 0;

        for (int i = 1; i < minPath.length; i++){
            col = numArray2int(s);		//Calcula o valor do conjunto S
            min = path[row][col];
            minPath[i] = min;
            row = min;		

            /* exclui do conjunto s a cidade escolhida */
            for (int j = 0; j < s.size(); j++){	
                if(s.get(j) == min){s.remove(j);break;}
            }// End for
        }// End for
        return minPath;
    }// End getMinPath()

    //Gera todos os possivei conjuntos de tamanho sizeS para os valores contidos em S
    private static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> s, int sizeS){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int[] sub = new int[sizeS];

        if(sizeS <= s.size()){
            for (int i = 0; (sub[i] = i) < sizeS-1; i++);
            result.add(getSubset(s,sub));
            while(true){
                int i;
                for(i = sizeS-1; (i >= 0) && (sub[i] == s.size() - sizeS + i); i--);
                    if (i < 0)
                        break;
                    else{ 
                        sub[i]++;
                        for (++i ; i < sizeS; i++)
                            sub[i] = sub[i - 1] + 1;					
                        
                        result.add(getSubset(s,sub));
                        }// End else
            }// End while
        }// End if
        return result;
    }// End permute()

    private static ArrayList<Integer> getSubset(ArrayList<Integer> input, int[] subset){
        ArrayList<Integer> res = new ArrayList<Integer>();
            for(int i = 0; i < subset.length; i++){
                res.add(input.get(subset[i]));
            }// End for
        return res;
    }// End getSubset()

    private static int numArray2int(ArrayList<Integer> ar){
        int res = 0;

        for (int i = 0; i < ar.size(); i++)
            res += Math.pow(2,ar.get(i));		
        return res;
    }// End numArray2int()

    private static void showBiMatrix(int[][] m){
        for(int[] rows : m){
            for(int col : rows){
                System.out.format("%5d", col);
            }// End for
            System.out.println();
        }// End for
        System.out.println();
    }// End showBiMatrix()

    public static int getINFINITY(){
        return INFINITY;
    }// End getINFINITY()

    public static void setINFINITY(int INFINITY){
        CaixeiroViajante.INFINITY = INFINITY;
    }// End setINFINITY()

    public static int[][] getPath(){
        return path;
    }// End getPath()

    public static void setPath(int[][] path){
        CaixeiroViajante.path = path;
    }// End setPath()

    public static int[][] getDp(){
        return dp;
    }// End getDp()

    public static void setDp(int[][] dp){
        CaixeiroViajante.dp = dp;
    }// End setDp()

    public static int[][] getThisDistanceMatrix(){
        return thisDistanceMatrix;
    }// End getThisDistanceMatrix()

    public static void setThisDistanceMatrix(int[][] thisDistanceMatrix){
        CaixeiroViajante.thisDistanceMatrix = thisDistanceMatrix;
    }// End setThisDistanceMatrix()

    public static int getStartVertex(){
        return startVertex;
    }// End getStartVertex()

    public static void setStartVertex(int startVertex){
        CaixeiroViajante.startVertex = startVertex;
    }// End setStartVertex()
}// End caixeiroViajante
