
/**
 * Objective :
 * Push all the zero’s of a given array to the end of the array. 
 * The order of all other elements should be same.
 * 
 * For example :
 * If the given arrays is 		{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}
 * Then it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}
 

*/


var a = [1, 2, 0, 4, 3, 0, 3, 0, 2, 0,9];
function moveZero(b) {
    for (var i = b.length - 1; i >= 0; i--) {
        if (b[i] === 0) {
            b.splice(i, 1);
            b.push(0);
        }
    }
    return b;
}
console.log(moveZero(a));// [1,2,4,3,3,2,9,0,0,0,0]
/* create html file :
<!DOCTYPE html>
<html lang="en">
<head>
    <title>hello</title>
    <script src="PushZerosToEnd.js"></script>
    </head>
<body>
</body>
</html>


then open the console
*/