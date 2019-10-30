/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import controleaereo.Main;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Vertex implements Comparable<Vertex>{
    private int grau;
    private String nome;
    private Circle vertex;
    
    private double x;
    private double y;
   
    private double lat;
    private double lon;
   
    private int distancia;
    private boolean visitado = false;
    private ArrayList<Edge> adj;
    private Vertex pai;
    private Color color;
    
    public Vertex(int x, int y){
        this.x = x;
        this.y = y;
    }// End Vertex
    
    public Vertex(String name,int grau,double lat,double lon){
        this.grau  = grau;
        this.nome = name;
        
        this.x = (lon + 180) * (Main.width / 360);
        double latRad = lat * Math.PI / 180;
        double mercN = Math.log(Math.tan((Math.PI/4) + (latRad/2)));
        this.y = (Main.heigth/2) - (Main.width*mercN/(2*Math.PI));

        this.lat = lat;
        this.lon = lon;
        
        this.vertex = new Circle(8);
        this.vertex.setTranslateX((int)this.x);
        this.vertex.setTranslateY((int)this.y);
        this.vertex.setFill(Color.RED);
        
        this.adj = new ArrayList<Edge>(0);
    }// End Vertex()
    
        public Vertex(){}// End Vertex()
        
        public void setPai(Vertex pai){    
            this.pai = pai;
        }// End setPai()
        
        public Vertex getPai(){    
            return this.pai;
        }// End getPai()
        
        public void setDistancia(int distancia){
            this.distancia = distancia;
        }// End setDistancia()
        
        public int getDistancia(){    
            return this.distancia;
        }// End getDistancia()
        
        public void visitar (){    
            this.visitado = true;
        }// End visitar()
        
        public boolean verificarVisita(){       
            return visitado;
        }// End verificarVisita()
        
        public void addAdj(Edge e){
            adj.add(e);
        }// End addAdj()
        
        public ArrayList<Edge> getArestas(){
            return adj;
        }// End getArestas()
        
        public void setArestas(Edge edge){
            this.adj.add(edge);
        }// End getArestas()

        public Group setGroup(Group group){
            group.getChildren().add(this.vertex);
            return group;
        }// End setScene()

        public int getGrau(){
            return grau;
        }// End getGrau()

        public void setGrau(int grau){
            this.grau = grau;
        }// End setGrau()

        public Circle getVertex(){
            return vertex;
        }// End getVertex()

        public void setVertex(Circle vertex){
            this.vertex = vertex;
        }// End setVertex()

        public double getX(){
            return x;
        }// End getX()

        public void setX(double x){
            this.x = x;
        }// End setX()

        public double getY(){
            return y;
        }// End getY()

        public void setY(double y){
            this.y = y;
        }// End setY()

        public double getLat(){
            return lat;
        }// End getLat()

        public void setLat(double lat){
            this.lat = lat;
        }// End setLat()

        public double getLon(){
            return lon;
        }// End getLon()

        public void setLon(double lon){
            this.lon = lon;
        }// End setLon()    

    public String getNome(){
        return nome;
    }// End getNome()

    public void setNome(String nome){
        this.nome = nome;
    }// End setNome()

    public boolean isVisitado(){
        return visitado;
    }// End isVisitado()

    public void setVisitado(boolean visitado){
        this.visitado = visitado;
    }// End setVisitado()

    public Color getColor(){
        return color;
    }// End getColor()

    public void setColor(Color color){
        this.color = color;
    }// End setColor()
    
    public void setFill(Color color){
        this.vertex.setFill(color);
    }// End setFill()
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Vertex){
            Vertex vRef = (Vertex) obj;
            if(this.getNome().equals(vRef.getNome())) return true;
        }// End if
        return false;
    }// End equals()

    @Override
    public int compareTo(Vertex o) {
        if(this.getDistancia() < o.getDistancia()) return -1;
        else if(this.getDistancia() == o.getDistancia()) return 0;
        return 1;
    }// End compareTo()
}// End Vertex