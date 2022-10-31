(function () {
	var canvas, ctx, color, btn, movesMade, quad, status, moves, restart, victory;

	//Arrays
	var arr = new Array();
	var arrStatus = ["Iniciar","Jogando","Ganhou","Perdeu"];
	var arrColor = ["#808080","#FFFF00","#FF0000","#0080FF","#00FF00","#8000FF"];
	//Constantes
	var MAXMOVES = 25; 
	var SIZE = 30;
	var ARRAYLENGHT = 14

	function main () {
		canvas = document.getElementById("puzzle"); 
		ctx = canvas.getContext("2d");
		ctx.clearRect(0, 0, canvas.width, canvas.height);
		moves = document.getElementById('moves');
		status = document.getElementById('status');
		restart = document.getElementById('restart');
		intConfig();
	};

	function intConfig ( ) {
		victory = false;
		movesMade = 0;
		arr = [];
		moves.innerHTML = movesMade;
		status.innerHTML = arrStatus[0];
		configureBtn();
		draw();
		arr[0][0].setChange( true );
		changeStatus();
	};

	function configureBtn () {
		btn = document.getElementsByClassName("btn");
		for (var i = 0; i < btn.length; i++ ) {
			btn[i].onclick = function  () {
				if (arr[0][0].color != arrColor[ this.value - 1 ]) {
					if (movesMade < MAXMOVES) {
						if (victory == false) {
							movesMade++;
							changeColor(this.value);
						};
					};
				};
			};
		};
		restart.onclick = function () {
			intConfig();
		};
	};

	function changeStatus () {

		for ( var i = 0; i < 3 ; i++ ) {
			
			//Mudar a cor do quadrado
			for ( var j = 0 ; j < arr.length ; j++ ) {
				for (var k = 0; k < arr[j].length; k++) {
					if ( arr[j][k].getChange() == true ) {
						//Direita
						if ( arr[ j ][ k ] != arr[j][ARRAYLENGHT - 1] ) {
							if ( arr[j][ k + 1 ].color == arr[ j ][ k ].color ) {
								arr[j][ k + 1 ].setChange(true);
							}
						};
						//Esquerda
						if ( arr[ j ][ k ] != arr[j][0] ) {
							if ( arr[j][ k - 1 ].color == arr[ j ][ k ].color ) {
								arr[j][ k - 1 ].setChange(true);
							}
						};
						//Para Baixo
						if ( arr[ j ][ k ] != arr[ARRAYLENGHT - 1][k] ) {
							if ( arr[ j + 1 ][ k ].color == arr[ j ][ k ].color ) {
								arr[ j + 1 ][ k ].setChange(true);
							}
						};
						//Para cima
						if ( arr[ j ][ k ] != arr[0][k] ) {
							if ( arr[ j - 1][ k ].color == arr[ j ][ k ].color ) {
								arr[ j - 1][ k ].setChange(true);
							}
						};
					};
				};
				
			}
		}
	}

	function changeColor (color) {
		for (var i = 0; i < arr.length; i++) {
			for (var j = 0; j < arr[i].length; j++) {
				if( arr[i][j].getChange() == true){
					arr[i][j].color = arrColor[ color - 1 ]	
				};
			};
		};
		reDraw();
	};

	function reDraw ( ) {
		var flood;
		var auxArr = arr;
		arr = [];
		ctx.clearRect(0, 0, canvas.width, canvas.height);
		for (var i = 0; i < auxArr.length; i++) {
			var row = new Array();
			for (var j = 0; j < auxArr[i].length; j++) {
				quad = new square( auxArr[i][j].x, auxArr[i][j].y, auxArr[i][j].width, auxArr[i][j].height, auxArr[i][j].color, ctx);
				quad.draw();
				row.push(quad);
				row[j].setChange(auxArr[i][j].getChange());
			};
			arr[i] = row;
		};

		flood = arr.every(function(elemento){
			return elemento.every(function(obj){
				console.log(obj.color)
				return obj.color === arr[0][0].color
			})
		});

		moves.innerHTML = movesMade;
		if (flood) {
			victory = true;
			status.innerHTML = arrStatus[2];
		} else {
			if (movesMade == MAXMOVES) {
				status.innerHTML = arrStatus[3];
			}else {
				status.innerHTML = arrStatus[1];
			};
		};

		changeStatus();
	}

	function draw () {
		for (var i = 0; i < ARRAYLENGHT; i++) {
			var row = new Array();
			for (var j = 0; j < ARRAYLENGHT; j++) {
				quad = new square( i*SIZE, j*SIZE, SIZE, SIZE, randColor(), ctx);
				quad.draw();
				row.push(quad);
			};
			arr[i] = row;
		};
	}
	function randColor () {
		color = Math.floor((Math.random()*6)+1);
		switch(color){
			case 1:
				return '#808080';
			break;
			case 2:
				return '#FFFF00';
			break;
			case 3:
				return '#FF0000';
			break;
			case 4:
				return '#0080FF';
			break;
			case 5:
				return '#00FF00';
			break;
			case 6:
				return '#8000FF';
			break;
		}
	}
	//incia o main
	main();
})();