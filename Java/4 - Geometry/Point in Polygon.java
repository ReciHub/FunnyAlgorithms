Determina si un punto pt se encuentra en el polígono P. Este polígono se define como un vector de puntos, donde el punto 0 y n-1 son el mismo. IMPORTANTE: Deben incluirse las estructuras point y vec, ademas del método angle y el método cross que se encuentra en Collinear Points.


static boolean ccw (Point p, Point q, Point r) {
  return cross(toVector(p, q), toVector(p, r)) > 0; 
}
  
static boolean inPolygon (Point pt, ArrayList<Point> P) {
  if (P.size() == 0) return false;
  double sum = 0;    
  for (int i = 0; i < P.size()-1; i++) {
    if (ccw(pt, P.get(i), P.get(i+1))) sum += angle(P.get(i), pt, P.get(i+1)); 
    else sum -= angle(P.get(i), pt, P.get(i+1));
  }
  if(Math.abs(Math.abs(sum) - 2*Math.acos(-1.0)) < 1e-9) return true;
  return false;
}
