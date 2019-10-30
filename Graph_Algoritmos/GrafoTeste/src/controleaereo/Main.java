/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleaereo;

import adjacency.Adjacency;
import algoritmos.CaixeiroViajante;
import algoritmos.Dijkstra;
import algoritmos.Heuristica;
import algoritmos.Kruskal;
import algoritmos.Problema;
import algoritmos.ReducaoElementar;
import algoritmos.Solucao;
import graph.Edge;
import graph.Graph;
import graph.Vertex;
import java.awt.Dimension;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import localizacao.Localizacao;
import javafx.scene.control.ToolBar;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Vinicius Silva
 */
public class Main extends Application{    
    public static double width;
    public static double heigth;
    
    public static double lat;
    public static double lon;
    
    private static ToolBar toolBar;
    
    private static MenuItem menuitem1;
    private static MenuItem menuitem2;
    private static MenuItem menuitem3;
    private static MenuItem menuitem4;
    private static MenuItem menuitem5;
    private static Button button;
    
    private Graph graph;
    
    private Graph backup;
    
    private static Group group;
    private static Scene scene;
    
    private static Map<String,Vertex> vertex;
    private static List<Adjacency> listAdjacency;
    private static Map<String,Integer> pos;
    
    private Dijkstra dij;
    List<Vertex> list;
    List<Vertex> vertices;
    ArrayList<ArrayList<Integer>> distancias;
    ArrayList<Edge> arestas;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        button = new Button("Reset");
        group = new Group();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension scrnsize = toolkit.getScreenSize();
        
        width = (int)scrnsize.getWidth() + 10;
        heigth = (int)scrnsize.getHeight() - 38;
        
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Opções");
        
        
        menuitem1 = new MenuItem("Menor Caminho");
        menuitem2 = new MenuItem("Menor Tarifa");
        menuitem3 = new MenuItem("Menor Tarifa com viagem ao redor do mundo");
        menuitem4 = new MenuItem("Ponto que vai de qualquer origem para qualquer destino");
        menuitem5 = new MenuItem("Economia de combustível");
        
        menu.getItems().addAll(menuitem1,menuitem2,menuitem3,menuitem4,menuitem5);
        menuBar.getMenus().add(menu);
        
        
        Image image = new Image(
                "https://www.guiageo-mapas.com/imagens/mapa-mundi.jpg",
                 width,
                 heigth,
                 false,
                 false);
        
        group.getChildren().add(new ImageView(image));
        
        List<Localizacao> listloc = getLatLon();
        listAdjacency = getAdjacencia();
        
        vertex = new HashMap<>(0);
        List<Vertex> listVertex = new ArrayList<>(0);
        pos = new HashMap<>(0);
        
        
        
        for(int i = 0; i < listloc.size(); i++){
            lat = listloc.get(i).getLatitude();
            lon = listloc.get(i).getLongitude();
            String sigla = listloc.get(i).getSigla();
            
            System.out.println("SIGLA :" + listloc.get(i).getSigla());
            
            Vertex v = new Vertex(sigla,-1,lat,lon);
            listVertex.add(v);
            vertex.put(sigla,v);
            pos.put(sigla,i);
            group = v.setGroup(group);
        }// End for
        
        graph = new Graph(listloc.size(),listVertex);
        
        for(int i = 0; i < listAdjacency.size(); i++){
            String s1 = listAdjacency.get(i).getSigla1();
            String s2 = listAdjacency.get(i).getSigla2();
            
            Vertex v1 = vertex.get(s1);
            Vertex v2 = vertex.get(s2);
            Integer pos1 = pos.get(s1);
            Integer pos2 = pos.get(s2);
          
           graph.addAdjacencia(pos1,pos2,v1,v2,listAdjacency.get(i).getValor());
           group = graph.setGroup(pos1,pos2,group);
        }// End for
        
        toolBar = new ToolBar(menuBar,button);
        toolBar.setOrientation(Orientation.HORIZONTAL);
        
        scene = new Scene(group,width,heigth-60);
        group.getChildren().add(toolBar);
        primaryStage.setTitle("Mapa Mundi");
       
        primaryStage.setScene(scene);
        primaryStage.show();
        
        menuitem1.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                Graph grafo = graph;
                dij = new Dijkstra();
                String aeroporto1 = "";
                String aeroporto2 = "";
                TextInputDialog dialog = new TextInputDialog("Sistema Aéreo");
                
                dialog.setTitle("Origem e destino");
                dialog.showAndWait();
                Optional<String> result = dialog.showAndWait();
                if(result.isPresent() && !result.get().isEmpty()){
                    String[] siglas = result.get().trim().split(" ") ;
                    aeroporto1 = siglas[0].trim();
                    aeroporto2 = siglas[1].trim();
                    System.out.println(aeroporto1 + " " + aeroporto2);
                }else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("Ups!");
                    alert.setContentText("Reinicie o programa");
                    alert.showAndWait();
                    System.out.println("Erro");
                }// End else
                
                list = grafo.getVertex();
                Vertex v1 = null;
                Vertex v2 = null;
                
                for(Vertex v : list){
                    if(v.getNome().equals(aeroporto1)){
                        v1 = v;
                    }else if(v.getNome().equals(aeroporto2)){
                        v2 = v;
                    }// End else if
                }// End for
                
                System.out.println("V1: " + v1.getNome() + " V2: " + v2.getNome());
                if(v1 == null || v2 == null){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("Ups!");
                    alert.setContentText("Não existe este(s) aeroporto(s)!");
                    alert.showAndWait();
                    System.out.println("Erro");
                }else{
                    vertices = new ArrayList<>();
                    long in = System.currentTimeMillis();
                    vertices = dij.encontrarMenorCaminhoDijkstra(grafo,v1,v2);
                    long en = System.currentTimeMillis();
                    System.out.println("TEMPO DIJKSTRA 1 " + (double)((en-in)));
                    System.out.println("TAMANHO " + vertices.size() + " "+ grafo.getN() + " " + list.size());
                    
                    for(int i = 0; i < vertices.size(); i++){
                        String nome = vertices.get(i).getNome();
                        for(int j = 0; j < list.size(); j++){
                            if(nome.equals(list.get(j).getNome()) && i == 0){
                                list.get(j).getVertex().setFill(Color.YELLOW);
                            }else if(nome.equals(list.get(j).getNome()) && i == (vertices.size()-1)){
                                list.get(j).getVertex().setFill(Color.GREEN);
                            }else if(nome.equals(list.get(j).getNome())){
                                list.get(j).getVertex().setFill(Color.GRAY);
                            }// End else
                        }// End for      
                    }// End for
                }// End else
                     
                System.out.println("Item 1");
            }});
        
        menuitem2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t){
                Graph grafo = graph;
                dij = new Dijkstra();
                String aeroporto1 = "";
                String aeroporto2 = "";
                TextInputDialog dialog = new TextInputDialog("Sistema Aéreo");
                
                dialog.setTitle("Origem e destino");
                dialog.showAndWait();
                Optional<String> result = dialog.showAndWait();
                if(result.isPresent() && !result.get().isEmpty()){
                    String[] siglas = result.get().trim().split(" ") ;
                    aeroporto1 = siglas[0].trim();
                    aeroporto2 = siglas[1].trim();
                    System.out.println(aeroporto1 + " " + aeroporto2);
                }else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("Ups!");
                    alert.setContentText("Reinicie o programa");
                    alert.showAndWait();
                    System.out.println("Erro");
                }// End else
                
                list = grafo.getVertex();
                Vertex v1 = null;
                Vertex v2 = null;
                
                for(Vertex v : list){
                    if(v.getNome().equals(aeroporto1)){
                        v1 = v;
                    }else if(v.getNome().equals(aeroporto2)){
                        v2 = v;
                    }// End else if
                }// End for
                
                System.out.println("V1: " + v1.getNome() + " V2: " + v2.getNome());
                if(v1 == null || v2 == null){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("Ups!");
                    alert.setContentText("Não existe este(s) aeroporto(s)!");
                    alert.showAndWait();
                    System.out.println("Erro");
                }else{
                    vertices = new ArrayList<>();
                    long in = System.currentTimeMillis();                  
                    vertices = dij.encontrarMenorCaminhoDijkstra(grafo,v1,v2);
                    long en = System.currentTimeMillis();
                    System.out.println("TEMPO DIJKSTRA 2 " + (double)((en-in)));
                    System.out.println("TAMANHO " + vertices.size() + " "+ grafo.getN() + " " + list.size());
                    
                    for(int i = 0; i < vertices.size(); i++){
                        String nome = vertices.get(i).getNome();
                        for(int j = 0; j < list.size(); j++){
                            if(nome.equals(list.get(j).getNome()) && i == 0){
                                list.get(j).getVertex().setFill(Color.YELLOW);
                            }else if(nome.equals(list.get(j).getNome()) && i == (vertices.size()-1)){
                                list.get(j).getVertex().setFill(Color.GREEN);
                            }else if(nome.equals(list.get(j).getNome())){
                                list.get(j).getVertex().setFill(Color.GRAY);
                            }// End else
                        }// End for      
                    }// End for
                }// End else
                               
                System.out.println("Item 2");
            }});
        
        menuitem3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t){             
                vertices = new ArrayList<>();
                Heuristica heuristica = new Heuristica();
                Solucao solucao = new Solucao();
                
                distancias = new ArrayList<>();
                int k = 0;
               
                for(Map.Entry<String,Edge> entry : graph.getMap().entrySet()){
                    distancias.add(new ArrayList<Integer>());
                    distancias.get(k).add(entry.getValue().getPeso());
                    k++;
                }// End for
                
                Problema problema = new Problema(graph.getN(),distancias);
                
                String algoritmo = "";
                TextInputDialog dialog = new TextInputDialog("Sistema Aéreo");
                
                dialog.setTitle("Viagem ao redor do mundo");
                dialog.showAndWait();
                Optional<String> result = dialog.showAndWait();
                if(result.isPresent() && !result.get().isEmpty()){
                    algoritmo = result.get().trim();
                    System.out.println(algoritmo);
                }else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("Ups!");
                    alert.setContentText("Reinicie o programa");
                    alert.showAndWait();
                    System.out.println("Erro");
                }// End else
                
                list = graph.getVertex();
                
                if(algoritmo.equals("H") || algoritmo.equals("h")){
                    List<Edge> listMenor = new ArrayList<>();
                    
                    System.out.println("VALOR MATRIZ" + graph.getAdjacencia().length);
                    long in = System.currentTimeMillis();
                    CaixeiroViajante.computeTSP(graph.getAdjacencia());
                    long en = System.currentTimeMillis();
                    System.out.println("TEMPO CAIXEIRO VIAJANTE HEURISTICA " + (double)((en-in)));
                    System.out.println("VALOR MATRIZ MENOR" + CaixeiroViajante.getPath().length);
                  
                    for(int i = 0; i < CaixeiroViajante.getPath().length; i++){
                        for(int j = 0; j < CaixeiroViajante.getPath().length; j++){
                            if(graph.getMap().get(i+""+j) != null){
                                listMenor.add(graph.getMap().get(i+""+j));
                            }// End if
                        }// End for
                    }// End for
                    
                    for(int i = 0; i < listMenor.size(); i++){
                        vertices.add(listMenor.get(i).getInitialVertex());
                    }// End for
                    
                    List<Vertex> v = new ArrayList<>();
                   
                    int c = 0;
                    for(Vertex v1 : vertices){
                        System.out.println("VERTICES " + v1.getNome() + " POS " + c);
                        c++;
                    }
                    
                    v.add(vertices.get(0));
                    v.add(vertices.get(5));
                    v.add(vertices.get(7));
                    v.add(vertices.get(11));
                    v.add(vertices.get(13));
                    v.add(vertices.get(16));
                    v.add(vertices.get(19));
                    
                    
                    int r = 0;
                    int g = 0;
                    int b = 0;
                   
                    for(int i = 0; i < v.size(); i++){
                        String nome = v.get(i).getNome();            
                        for(int j = 0; j < list.size(); j++){
                            if(nome.equals(list.get(j).getNome())){
                                list.get(j).getVertex().setFill(Color.rgb(r,g,b));
                                r += 40;
                                g += 40;
                                b += 40;
                            }// End else
                        }// End for      
                    }// End for
                  
                }else if(algoritmo.equals("F") || algoritmo.equals("f")){
                    List<Edge> listMenor = new ArrayList<>();
                    
                    System.out.println("VALOR MATRIZ" + graph.getAdjacencia().length);
                    long in = System.currentTimeMillis();
                    CaixeiroViajante.computeTSP(graph.getAdjacencia());
                    long en = System.currentTimeMillis();
                    System.out.println("TEMPO CAIXEIRO VIAJANTE FORÇA BRUTA" + (double)((en-in)));
                    System.out.println("VALOR MATRIZ MENOR" + CaixeiroViajante.getPath().length);
                  
                    for(int i = 0; i < CaixeiroViajante.getPath().length; i++){
                        for(int j = 0; j < CaixeiroViajante.getPath().length; j++){
                            if(graph.getMap().get(i+""+j) != null){
                                listMenor.add(graph.getMap().get(i+""+j));
                            }// End if
                        }// End for
                    }// End for
                    
                    for(int i = 0; i < listMenor.size(); i++){
                        vertices.add(listMenor.get(i).getInitialVertex());
                    }// End for
                    
                    List<Vertex> v = new ArrayList<>();
                   
                    int c = 0;
                    for(Vertex v1 : vertices){
                        System.out.println("VERTICES " + v1.getNome() + " POS " + c);
                        c++;
                    }
                    
                    v.add(vertices.get(0));
                    v.add(vertices.get(5));
                    v.add(vertices.get(7));
                    v.add(vertices.get(11));
                    v.add(vertices.get(13));
                    v.add(vertices.get(16));
                    v.add(vertices.get(19));
                    
                    
                    int r = 0;
                    int g = 0;
                    int b = 0;
                   
                    for(int i = 0; i < v.size(); i++){
                        String nome = v.get(i).getNome();            
                        for(int j = 0; j < list.size(); j++){
                            if(nome.equals(list.get(j).getNome())){
                                list.get(j).getVertex().setFill(Color.rgb(r,g,b));
                                r += 40;
                                g += 40;
                                b += 40;
                            }// End else
                        }// End for      
                    }// End for
                }// End else if
                
                System.out.println("Item 3");
            }});
        
        menuitem4.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t){
                long in = System.currentTimeMillis();             
                Kruskal k = new Kruskal(graph.getN(),graph);	
                arestas = k.getMenorGrafo();
                long en = System.currentTimeMillis();
                System.out.println("TEMPO KRUSKAL " + (double)((en-in)));
                for(Edge e : arestas){
                 //   System.out.println("VALOR ARVORE " + k.getMenorGrafo().size() + " ARESTA: " + e.getPeso());
                 //   System.out.println("INICIAL VERTICE " + e.getInitialVertex().getNome() + " FINAL VERTICE " + e.getFinalVertex().getNome());
                    e.getInitialVertex().getVertex().setFill(Color.BLUE);
                    e.getFinalVertex().getVertex().setFill(Color.BLUE);
                    for(int i = 0; i < graph.getN(); i++){
                        for(int j = 0; j < graph.getN(); j++){
                            if(e == graph.getMap().get(i+""+j)){
                                System.out.println(" IGUAL FIM " + e.getInitialVertex().getNome() + " IGUAL FIM " + e.getFinalVertex().getNome());
                                graph.getMap().get(i+""+j).getEdge().setStroke(Color.RED);
                            }// End if
                        }// End for
                    }// End for
                }// End for
                
                System.out.println("Item 4");
            }});
        
        menuitem5.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t){
                long in = System.currentTimeMillis();
                ReducaoElementar re = new ReducaoElementar(graph);
                int[][] v = re.reducaoElementar();
                long en = System.currentTimeMillis();
                System.out.println("REDUÇÃO ELEMENTAR: " + (double)(en-in));
                for(int i = 0; i < v.length; i++){
                    for(int j = 0; j < v.length; j++){
                        if(graph.getMap().get(i+""+j) != null){
                            graph.getMap().get(i+""+j).getInitialVertex().setFill(Color.BLUE);
                            graph.getMap().get(i+""+j).getFinalVertex().setFill(Color.BLUE);
                        }// End if
                    }// End for
                }// End for
                
                System.out.println("Item 5");
            }});
        
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t){
                if(vertices != null){
                    for(int j = 0; j < vertices.size(); j++){
                        vertices.get(j).getVertex().setFill(Color.RED);
                    }// End for
                    dij = null;
                    vertices = null;
                }//End if    
                
                if(arestas != null){
                    for(Edge e : arestas){
                        e.getInitialVertex().getVertex().setFill(Color.RED);
                        e.getFinalVertex().getVertex().setFill(Color.RED);
                        e.getEdge().setStroke(Color.BLACK);
                    }// End for
                }// End if
                System.out.println("Reset");
            }});
    }// End start()

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        launch(args);
    }// End main()
    
    
    public static List<Localizacao> getLatLon() throws Exception{
        List<Localizacao> list = new ArrayList<>(0);
         
        DataInputStream data = new DataInputStream(new FileInputStream("C:\\Users\\vinic\\Desktop\\vertex.txt"));
        int n = Integer.parseInt(data.readLine().trim());
        for(int i = 0; i < n; i++){
            String str = data.readLine();
            String string[] = str.split(" ");       
            String sigla = string[0];
            
            double lat = Double.parseDouble(string[1]);
            double lon = Double.parseDouble(string[2]);
            
            list.add(new Localizacao(sigla,lat,lon));
        }// End for
        return list;
    }// End getLatLon()
    
    public static List<Adjacency> getAdjacencia() throws Exception{
        List<Adjacency> list = new ArrayList<>(0);
        DataInputStream data = new DataInputStream(new FileInputStream("C:\\Users\\vinic\\Desktop\\adjacency.txt"));
        int n = Integer.parseInt(data.readLine().trim());
        
        for(int i = 0; i < n; i++){
            String str = data.readLine();
            String string[] = str.split(" ");
            
            String sigla1 = string[0].trim();
            String sigla2 = string[1].trim();
            double valor = Double.parseDouble(string[2]);
            
            list.add(new Adjacency(sigla1,sigla2,valor));
        }// End for
        
        return list;
    }// End getAdjacencia()
}// End class Main
