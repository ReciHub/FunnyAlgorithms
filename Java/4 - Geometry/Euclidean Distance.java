Halla la distancia euclideana de 2 puntos en dos dimensiones (x,y). Para usar el primer método, debe definirse previamente la clase Point

    
/*Trabajando con la clase Point*/
static double euclideanDistance(Point p1, Point p2) {           
  return Math.hypot(p1.x - p2.x, p1.y - p2.y); 
} 
/*Trabajando con los valores x y y de cada punto*/
static double euclideanDistance(double x1, double y1, double x2, double y2){ 
    return Math.hypot(x2 - x1, y2 - y1);         
} 


