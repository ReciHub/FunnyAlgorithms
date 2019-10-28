let sum = (n) => {
    var sum = 0;

    for (var i = 0 ; i <= n; i++) sum+= i;
    console.log('Sum of numbers', {sum: sum});
}

sum(5); //5+4+3+2+1 = 15