function romanToDecimal(roman) {
	var lookup = {M:1000,CM:900,D:500,CD:400,C:100,XC:90,L:50,XL:40,X:10,IX:9,V:5,IV:4,I:1},roman = '',i;
	  
    for (var i = 0; i < roman.length; i++) {
        var curr = lookup[roman.charAt(i)];
        var pre = lookup[roman.charAt(i - 1)];

        if (i == 0) {
            num += curr;
            continue;
        }

        if (curr <= pre) {
            num += curr;
        } else {
            num = num - pre * 2 + curr;
        }
    }
    return num;
}

romanToDecimal('MCMXCVI');