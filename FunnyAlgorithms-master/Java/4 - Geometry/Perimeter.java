Calcula el perímetro de un polígono representado como un vector de puntos. IMPORTANTE: Definir P[0] = P[n-1] para cerrar el polígono. La estructura point debe estar definida, al igual que el método euclideanDistance.

public static double perimeter (ArrayList<Point> P) {
  double result = 0.0;
  for (int i = 0; i < P.size()-1; i++){
    result += euclideanDistance(P.get(i), P.get(i+1));
  }
  return result; 
}
