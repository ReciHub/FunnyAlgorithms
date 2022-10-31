Calcula el area de un polígono representado como un ArrayList de puntos. IMPORTANTE: Definir P[0] = P[n-1] para cerrar el polígono. El algorítmo utiliza el metodo de determinante de la matriz de puntos de la figura. IMPORTANTE: Debe definirse previamente la clase Point.

public static double area(ArrayList<Point> P) {
  double result = 0.0;
  for (int i = 0; i < P.size()-1; i++) {
   	result += ((P.get(i).x * P.get(i + 1).y) - (P.get(i + 1).x * P.get(i).y));
  }
  return Math.abs(result) / 2.0; 
}
