
//usando if else

function calculadora(operador, termo1, termo2){

    if (operador ==='+'){
        return termo1+termo2
    } else if (operador ==='-'){
        return termo1-termo2
    } else if (operador === '*'){
        return termo1*termo2
    } else{
        return termo1/termo2
    }

}

//usando switch 

function calculadora_switch(operador, termo1, termo2){

    switch(operador){
        case '+':
            return termo1+termo2
        case '-':
            return termo1-termo2
        case '*':
            return termo1*termo2
        default:
            return termo1/termo2
    }
        
}

console.log(calculadora('+', 8 , 2))

console.log(calculadora_switch('+', 8, 2))