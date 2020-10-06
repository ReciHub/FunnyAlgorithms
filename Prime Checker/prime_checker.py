def isPrime(number):
    ##to be a prime it must be divided only by himself or by 1
    
    ##1 is not a prime, neither 0 or negative numbers
    if (number <= 1):
        return False;
    else:
        for i in range(2, number):
            if (number % i == 0):
                return False;
      
    return True;