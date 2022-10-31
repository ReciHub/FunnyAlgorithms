Retorna el polígono convexo mas pequeño que cubre (ya sea en el borde o en el interior) un set de puntos. Recibe un vector de puntos, y retorna un vector de puntos indicando el polígono resultante. Es necesario que esten definidos previamente: 

Estructuras: point y vec
Métodos: collinear, euclideanDistance, ccw (de inPolygon) y angle.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

static ArrayList<Point> ConvexHull (ArrayList<Point> P) {
  int i, j, n = (int)P.size();
  if (n <= 3) {
    if (P.get(0).x != P.get(n-1).x || P.get(0).y != P.get(n-1).y) P.add(P.get(0)); 
    return P;
  }
  int P0 = 0;
  for (i = 1; i < n; i++)
    if (P.get(i).y  < P.get(P0).y || (P.get(i).y == P.get(P0).y && P.get(i).x > P.get(P0).x)) P0 = i;
  Point temp = P.get(0); P.set(0, P.get(P0)); P.set(P0 ,temp); 
  Point pivot = P.get(0);
  Collections.sort(P, new Comparator<Point>(){
    public int compare(Point a, Point b) { 
      if (collinear(pivot, a, b)) return euclideanDistance(pivot, a) < euclideanDistance(pivot, b) ? -1 : 1;
      double d1x = a.x - pivot.x, d1y = a.y - pivot.y;
      double d2x = b.x - pivot.x, d2y = b.y - pivot.y;
      return (Math.atan2(d1y, d1x) - Math.atan2(d2y, d2x)) < 0 ? -1 : 1;
    }
  });
  ArrayList<Point> S = new ArrayList<Point>();
  S.add(P.get(n-1)); S.add(P.get(0)); S.add(P.get(1));
  i = 2; 
  while (i < n) { 
    j = S.size() - 1;
    if (ccw(S.get(j-1), S.get(j), P.get(i))) S.add(P.get(i++)); 
    else S.remove(S.size() - 1); 
  }
  return S;
}