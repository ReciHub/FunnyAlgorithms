class Matrix {
    constructor(row,coloumn){
        this.rows = row
    this.col = coloumn
    this.matrix=[]
    for (let i = 0; i<this.rows ;i++){
      this.matrix[i]=[]
      for (let k = 0;k<this.col;k++){
        this.matrix[i][k]=0
      }
    }
       console.table(this.matrix) 
    }
        fill(n){
    for (let i = 0; i<this.rows ;i++){
      this.matrix[i]=[]
      for (let k = 0;k<this.col;k++){
        this.matrix[i][k]=n
      }
  
    }
        console.table(this.matrix)
  }
  generate(){
    for (let i = 0; i<this.rows ;i++){
      this.matrix[i]=[]
      for (let k = 0;k<this.col;k++){
        this.matrix[i][k] = Math.floor(Math.random()*10)
      }
  
    }
        // console.table(this.matrix)
  }
  
  }
  
  
  let t = new Matrix(3,2)
  let j = (t.Matrix)
  let add =k.fill(5) 
// simple program to generate javascript matrix

  
  