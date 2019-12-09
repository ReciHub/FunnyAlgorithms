Dados 3 puntos A, B, y C, determina el valor del angulo ABC (origen en B) en radianes. IMPORTANTE: Definir la clase Point y Vec (Geometric Vector). Si se desea convertir a grados sexagesimales, revisar Sexagesimal degrees and radians.

static double angle(Point a, Point b, Point c) { 
  	Vec ba = toVector(b, a);
  	Vec bc = toVector(b, c);
  	return Math.acos((ba.x * bc.x + ba.y * bc.y) / Math.sqrt((ba.x * ba.x + ba.y * ba.y) * (bc.x * bc.x + bc.y * bc.y))); 
}
