La clase punto será la base sobre la cual se ejecuten otros algoritmos. 

static class Point { 
	public double x, y;
  	public Point() { this.x = this.y = 0.0; }
  	public Point(double _x, double _y){
  		this.x = _x;
  		this.y = _y;
  	} 
  	public boolean equals(Point other){
  		if(Math.abs(this.x - other.x) < 1e-9 && (Math.abs(this.y - other.y) < 1e-9)) return true;
  		return false;
  	}
}
