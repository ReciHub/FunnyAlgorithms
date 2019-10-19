Conversiones de grados sexagesimales a radianes y viceversa.

static double DegToRad(double d) { 
	return d * Math.PI / 180.0; 
}

static double RadToDeg(double r) { 
	return r * 180.0 / Math.PI;
}
