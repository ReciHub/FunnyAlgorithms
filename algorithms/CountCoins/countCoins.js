// This is a JavaScript function to convert an amount to coins.

function countCoins (money) {
    let coins = [25, 10, 5, 2, 1];
    let result = [];
    for (let i = 0; i < coins.length; i++) {
        while(money >= coins[i]) {
            result.push(coins[i]);
            money = money - coins[i]
        }
    }
    return result
}

console.log(countCoins(46))
// Output: [25, 10, 10, 1]
