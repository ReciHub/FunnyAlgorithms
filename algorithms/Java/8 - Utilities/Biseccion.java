Método de bisección para una función f(m)

static double eps = 0.0000001;

static double bis(double a, double b) {
		double m = (a+b)/2;
		if(Math.abs(f(m)) < eps) return m;
		if(f(a) * f(m) < 0) return bis(a, m);
		return bis(m, b);
	}
}
