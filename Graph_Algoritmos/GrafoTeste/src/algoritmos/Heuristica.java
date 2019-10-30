/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

/**
 *
 * @author Vinicius Silva
 */
public class Heuristica{
    private int numeroDeCidades;
    private int numeroDeCidadesPow;

    public Heuristica(){ }// End Heuristica()

    public Solucao solucao(Problema problema){
        Solucao solucao = new Solucao();
        setNumeroDeCidades(problema.getNumero());
        setNumeroDeCidadesPow((int)Math.pow(2, getNumeroDeCidades()));
        int matrizDP[][] = new int [getNumeroDeCidades()][getNumeroDeCidadesPow()]; 
        int matrizCaminho[][] = new int [getNumeroDeCidades()][getNumeroDeCidadesPow()];

        for (int i = 0; i < getNumeroDeCidades(); i++){
            for (int j = 0; j < getNumeroDeCidadesPow(); j++){
                matrizDP[i][j] = -1;
                matrizCaminho[i][j] = -1;
            }// End for
        }// End for

        for(int i = 0; i < getNumeroDeCidades(); i++){
            matrizDP[i][0] = problema.getDistancia(i, 0);
        }// End for

        solucao.addNoCaminho(0);
        solucao.setDistanciaMinima(algoritmoHeuristica(0, getNumeroDeCidadesPow() - 2, matrizDP, matrizCaminho, problema));
        getCaminho(0, getNumeroDeCidadesPow() - 2, matrizCaminho, solucao);
        solucao.addNoCaminho(0);
        return solucao;
    }// End Solucao()

    /**
     * algoritmoHeuristica
     */
    public int algoritmoHeuristica(int inicio, int set, int[][]matrizDP, int[][]matrizCaminho, Problema problema) {
        int mascara, marcado, resultado = -1, temp;
        if(matrizDP[inicio][set] != -1) return matrizDP[inicio][set];
            else{
                for(int i = 0; i < getNumeroDeCidades(); i++){
                    mascara = getNumeroDeCidadesPow() - 1 - (int) Math.pow(2, i);
                    marcado = set & mascara;
                    if(marcado != set){
                        temp = problema.getDistancia(inicio, i) + algoritmoHeuristica(i, marcado, matrizDP, matrizCaminho, problema);
                        if(resultado == -1 || resultado > temp){
                            resultado = temp;
                            matrizCaminho[inicio][set] = i;
                        }// End if
                    }// End if
                }// End for
                matrizDP[inicio][set] = resultado;
                return resultado;
            }// End else
    }// End algoritmoHeuristica()

    /**
     * getPath
     */
    public void getCaminho(int start, int set, int[][]matrizCaminho, Solucao solucao){
        if(matrizCaminho[start][set] == -1) return;
        int x = matrizCaminho[start][set];
        int mascara = getNumeroDeCidadesPow() -1 - (int)Math.pow(2, x);
        int marcado = set & mascara;
        solucao.addNoCaminho(x);
        getCaminho(x, marcado, matrizCaminho, solucao);
    }// End getCaminho()

    /**
     * @return numeroDeCidades
     */
    public int getNumeroDeCidades(){
        int aux = numeroDeCidades;
        return aux;
    }// End getNumeroDeCidades()

    /**
     * @param numeroDeCidades setar numeroDeCidades
     */
    public void setNumeroDeCidades(int numeroDeCidades){
        this.numeroDeCidades = numeroDeCidades;
    }// End setNumeroDeCidades()

    /**
     * @return numeroDeCidadesPow
     */
    public int getNumeroDeCidadesPow(){
        int aux = numeroDeCidadesPow;
        return aux;
    }// End getNumeroDeCidadesPow()

    /**
     * @param numeroDeCidadesPow setar numeroDeCidadesPow
     */
    public void setNumeroDeCidadesPow(int numeroDeCidadesPow){
        this.numeroDeCidadesPow = numeroDeCidadesPow;
    }// End setNumeroDeCidadesPow()
}// End Heuristica()
