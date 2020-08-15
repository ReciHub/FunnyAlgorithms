Dados dos puntos A y B, crea el vector A->B. IMPORTANTE: Debe definirse la clase Point. Es llamado Vec para no confundirlo con vector como colección de elementos.


static class Vec { 
    public double x, y;
    public Vec(double _x, double _y) {
        this.x = _x;
        this.y = _y;
    }
}
static Vec toVector(Point a, Point b) {       
	return new Vec(b.x - a.x, b.y - a.y); 
}



