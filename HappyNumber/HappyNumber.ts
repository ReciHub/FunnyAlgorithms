/*
 *  Some numbers are happy. Well they're only happy if sum of squares
 *  of their digits ends up as 1!
 */

function isHappy(n: number): boolean {
	if (n == 1 || n == 7) return true;

	let sum: number = n;

  	while (sum > 9) {
  		sum = sum
      		.toString()
      		.split('')
      		.map((digit) => {
      			return Number(digit);
      		})
      		.reduce((partialSum, a) => Math.pow(a, 2) + partialSum, 0);

    	if (sum == 1 || sum == 7) {
      		return true;
    	}
	}

  	return false;
}