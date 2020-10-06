function checkSameDigits(cpf) {
  if(cpf == "00000000000" ||
  cpf == "11111111111" ||
  cpf == "22222222222" ||
  cpf == "33333333333" ||
  cpf == "44444444444" ||
  cpf == "55555555555" ||
  cpf == "66666666666" ||
  cpf == "77777777777" ||
  cpf == "88888888888" ||
  cpf == "99999999999") {
    return true
  }
  else {
    return false
  }
}

function isValidCPF(cpf) {
  //cpf is a personal document number in Brazil. see: https://en.wikipedia.org/wiki/Cadastro_de_Pessoas_F%C3%ADsicas
  var reg = /[^A-Za-z0-9]/g;
  cpf = cpf.replace(reg,"")
  
  if(cpf.length != 11) {
    console.log(cpf)
    return false
  }
  else if(checkSameDigits(cpf)){
    return false
  }
  else {

    sum = 0
    for (let i = 0; i < 9; i++) {
      sum += parseInt(cpf[i]) * (10-i);
    }
    firstDigit = ((sum * 10) % 11) % 10;
    if (firstDigit != cpf[9]){
      return false;
    }
    else {
      newSum = 0
      for (let i = 0; i < 10; i++) {
        newSum += parseInt(cpf[i]) * (11-i);
      }
      secondDigit = ((newSum * 10) % 11) % 10;
      if (secondDigit != cpf[10]){
        return false;
      }
      else {
        return true
      }
    }
  }

}

//making tests

console.log(isValidCPF("529.982.247-25"));
//true

console.log(isValidCPF("111.111.111-11"));
//false

console.log(isValidCPF("123.456.789-12"));
//false

