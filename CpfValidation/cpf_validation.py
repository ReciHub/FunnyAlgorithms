import string

def checkSameDigits(cpf):
    if(cpf == "00000000000" or
       cpf == "11111111111" or
       cpf == "22222222222" or
       cpf == "33333333333" or
       cpf == "44444444444" or
       cpf == "55555555555" or
       cpf == "66666666666" or
       cpf == "77777777777" or
       cpf == "88888888888" or
       cpf == "99999999999"):
        return True
    else:
        return False

def isValidCPF(cpf):
    ##cpf is a personal document number in Brazil. see: https://en.wikipedia.org/wiki/Cadastro_de_Pessoas_F%C3%ADsicas
    
    #eliminate symbols from analysis
    cpf = ''.join(c for c in cpf if c in string.digits)
    
    if(len(cpf) != 11):
        return False
    elif(checkSameDigits(cpf)):
        return False
    else:
        mySum = 0
        for i in range(9):
            mySum += int(cpf[i]) * (10-i);
            
    firstDigit = ((mySum * 10) % 11) % 10;


    if (firstDigit != int(cpf[9])):
        return False
    else:
        newSum = 0
        for i in range(10):
            newSum += int(cpf[i]) * (11-i)
        secondDigit = ((newSum * 10) % 11) % 10;
        if (secondDigit != int(cpf[10])):
            return False;
        else:
            return True