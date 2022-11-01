const array = [1, 2, 3];



function sum(vetor) {

  let soma = vetor.reduce((valora, valorb) => valora + valorb, 0)

  return soma

}

function sumOdds(vetor) {

  //selecionando os valores impares
  
  let soma = vetor.filter((value) => value % 2 !== 0)

  soma = soma.reduce((valora, valorb) => valora + valorb, 0);

  return soma
}

function product(vetor) {

  let soma = vetor
  
  //multiplicando iniciando por 1, pois do contrário retornaria 0
  
  soma = soma.reduce((valora, valorb) => valora * valorb, 1);

  return soma

}


console.log(sum(array))
console.log(sumOdds(array))
console.log(product(array))