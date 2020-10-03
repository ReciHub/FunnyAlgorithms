Determina si el punto r está en la misma linea que los puntos p y q. IMPORTANTE: Deben incluirse las estructuras point y vec.


static double cross(Vec a, Vec b) { 
	return a.x * b.y - a.y * b.x; 
}
static boolean collinear(Point p, Point q, Point r) {
	return Math.abs(cross(toVector(p, q), toVector(p, r))) < 1e-9; 
}
