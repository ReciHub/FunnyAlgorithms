function tipo_triangulo(termo1, termo2, termo3){

    if ( termo1>=termo2+termo3 || termo2>=termo3+termo1 || termo3>=termo2+termo1){

        return 'none'

    } else{

        if (termo1===termo2 && termo1===termo3){
            return ' equilateral'
        } else if (termo1!==termo2 && termo2!==termo3 && termo3!==termo1 ){
            return 'escalene'
        } else{
            return 'isosceles'
        }

    }

}

console.log(tipo_triangulo(2, 2, 2))