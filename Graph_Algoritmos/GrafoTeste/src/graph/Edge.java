/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import controleaereo.Main;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Edge implements Comparable<Object>{
    private Vertex initialVertex;
    private Vertex finalVertex;
    private double xinicial;
    private double yinicial;
    private double xfinal;
    private double yfinal;
    private Line edge;
   
    private int peso;
    private Color color;
    
    public Edge(Vertex initialVertex,Vertex finalVertex,int peso){
       this.initialVertex = initialVertex;
       this.finalVertex = finalVertex;
       this.xinicial = this.initialVertex.getX();
       this.yinicial = this.initialVertex.getY();
       this.xfinal = this.finalVertex.getX();
       this.yfinal = this.finalVertex.getY();
       this.edge = new Line(xinicial,yinicial,xfinal,yfinal);
       this.edge.setStrokeWidth(2);
       this.edge.setStroke(Color.BLACK);
       this.peso = peso;
    }// End Edge()
    
    public Edge(Vertex initialVertex,Vertex finalVertex){
       this.initialVertex = initialVertex;
       this.finalVertex = finalVertex;
       this.xinicial = this.initialVertex.getX();
       this.yinicial = this.initialVertex.getY();
       this.xfinal = this.finalVertex.getX();
       this.yfinal = this.finalVertex.getY();
       this.edge = new Line(xinicial,yinicial,xfinal,yfinal);
       this.edge.setStrokeWidth(2);
       this.edge.setStroke(Color.BLACK);
       this.peso = 1;
    }// End Edge()
    
    public Edge(int latinicial,int loninicial,int latfinal,int lonfinal){
        
        this.xinicial = (loninicial + 180) * (Main.width / 360);
        double latRad = latinicial * Math.PI / 180;
        double mercN = Math.log(Math.tan((Math.PI/4) + (latRad/2)));
        this.yinicial = (Main.heigth/2) - (Main.width*mercN/(2*Math.PI));


        this.xfinal = (lonfinal + 180) * (Main.width / 360);
        double latRadfinal = latfinal * Math.PI / 180;
        double mercNfinal = Math.log(Math.tan((Math.PI/4) + (latRadfinal/2)));
        this.yfinal = (Main.heigth/2) - (Main.width*mercNfinal/(2*Math.PI));
        this.edge.setStrokeWidth(2);
        this.edge = new Line(xinicial,yinicial,xfinal,yfinal);
        this.edge.setStroke(Color.BLACK);
    }// End Edge()

    public void setPeso(int novoPeso){
        this.peso = novoPeso;
    }// End setPeso()

    public int getPeso(){
        return peso;
    }// End getPeso()
        
    public Group setGroup(Group group){
        group.getChildren().add(this.edge);
        return group;
    }// End setScene()

    public Vertex getInitialVertex(){
        return initialVertex;
    }// End getInitialVertex()

    public void setInitialVertex(Vertex initialVertex){
        this.initialVertex = initialVertex;
    }// End setInitialVertex()

    public Vertex getFinalVertex(){
        return finalVertex;
    }// End getFinalVertex()

    public void setFinalVertex(Vertex finalVertex){
        this.finalVertex = finalVertex;
    }// End setFinalVertex()

    public double getXinicial(){
        return xinicial;
    }// End getXinicial()

    public void setXinicial(double xinicial){
        this.xinicial = xinicial;
    }// End setXinicial()

    public double getYinicial(){
        return yinicial;
    }// End getYinicial()

    public void setYinicial(double yinicial){
        this.yinicial = yinicial;
    }// End setYinicial()

    public double getXfinal(){
        return xfinal;
    }// End getXfinal()

    public void setXfinal(double xfinal){
        this.xfinal = xfinal;
    }// End setXfinal()

    public double getYfinal(){
        return yfinal;
    }// End getYfinal()

    public void setYfinal(double yfinal){
        this.yfinal = yfinal;
    }// End setYfinal()

    public Line getEdge(){
        return edge;
    }// End getEdge()

    public void setEdge(Line edge){
        this.edge = edge;
    }// End setEdge()

    public Color getColor(){
        return color;
    }// End getColor()

    public void setColor(Color color){
        this.color = color;
    }// End setColor()
    
    public void setFill(Color color){
        this.edge.setFill(color);
    }// End setFill()
    
     public int compareTo(Object o) {
        Edge arestaAux = (Edge) o;
        if (this.getPeso() < arestaAux.getPeso())
            return -1;
        else if (this.getPeso() > arestaAux.getPeso())
            return 1;
        else
            return 0;
    }// End compareTo()
}// End Edge