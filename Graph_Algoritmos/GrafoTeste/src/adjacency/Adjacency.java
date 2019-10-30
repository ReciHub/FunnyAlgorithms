/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjacency;

/**
 *
 * @author Vinicius Silva
 */
public class Adjacency{
  private String sigla1;
  private String sigla2;
  private double valor;
  
  public Adjacency(String sigla1,String sigla2,double valor){
      this.sigla1 = sigla1;
      this.sigla2 = sigla2;
      this.valor = valor;
  }// End Adjacency()

    public String getSigla1(){
        return sigla1;
    }// End getSigla1()

    public void setSigla1(String sigla1){
        this.sigla1 = sigla1;
    }// End setSigla1()

    public String getSigla2(){
        return sigla2;
    }// End getSigla2()

    public void setSigla2(String sigla2){
        this.sigla2 = sigla2;
    }// End setSigla2()

    public double getValor(){
        return valor;
    }// End getValor()

    public void setValor(double valor){
        this.valor = valor;
    }// End setValor()   
}// End Adjacency
