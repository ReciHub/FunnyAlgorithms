function square(x, y , w, h, color, ctx){
    this.x = x;
    this.y = y;
    this.width = w;
    this.height = h;
    this.color = color;
    var changeColor = false;

    this.draw = function( ) {
    	ctx.fillStyle = color
		ctx.fillRect( this.x, this.y, this.width, this.height );
    }

    this.setChange = function (set) {
    	changeColor = set;
    }

    this.getChange = function ( ) {
    	return changeColor;
    }
}