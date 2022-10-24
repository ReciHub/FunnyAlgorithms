/**
 * Binary Search in JavaScript
 * @param {*} arr array of numbers sorted in ascending order
 * @param {*} searchValue number to search
 * @return {*} index of the search value or -1 if not found
 */
const binarySearch = function (arr, searchValue) {
    let min = 0;
    let max = arr.length - 1;
    let mid;
    while (min <= max) {
        mid = (min + max) >>> 1;
        if (arr[mid] === searchValue) {
            return mid;
        } else if (arr[mid] < searchValue) {
            min = mid + 1;
        } else {
            max = mid - 1;
        }
    }
    return -1;
};
