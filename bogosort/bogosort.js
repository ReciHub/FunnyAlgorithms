/**
 * Implements the Bogo Sort algorithm to sort an array in ascending order.
 * Bogo Sort is an inefficient sorting algorithm that randomly shuffles the array until it is sorted.
 * This algorithm has an average-case time complexity of O((n+1)!), making it highly impractical for large arrays.
 *
 * @param {number[]} array - The array to be sorted.
 */
function bogosort(array) {
    let flag = false;
    let count = 0;

    while (!flag) {
        count++;
        for (let i = 0; i < array.length; i++) {
        if (i == array.length - 1) {
            flag = true;
            console.log("success: ", count);
            console.table(array);
            break;
        }
        if (array[i] > array[i + 1]) {
            array.sort((a, b) => 0.5 - Math.random());
            console.log("failure: ", count);
            break;
        }
        }
    }
}

let array = [1, 3, 5, 2, 4, 8, 9, 7, 6];
bogosort(array);
