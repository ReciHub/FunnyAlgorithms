/* Name: BozoSort
Description: Swaps two elements at random until the sequence is sorted. Much more difficult to analyse than Bogo or BogoBogo, but supposedly 𝑂(𝑛!) on average.
Functionality: Takes in an array of numbers and provides a sorted array
Usage: console.log(sorter([4, 8, 2, 7, 1, 6, 10]))
Output: ​​​​​[ 1, 2, 4, 6, 7, 8, 10 ]​​​​​ */

const sorter = (list) => {
    if (!Array.isArray(list)) {
        throw new TypeError('Expected an array');
    }

    var slot1 = 0, slot2 = 0;
    var temp;

    while (!isSorted(list)) {
        slot1 = Math.floor(Math.random() * list.length);
        slot2 = Math.floor(Math.random() * list.length);

        temp = list[slot1];
        list[slot1] = list[slot2];
        list[slot2] = temp;
    }

    return list;
};

const isSorted = (list) => {
    for (var i = 0, ii = list.length; i < ii; i++) {
        if (list[i] > list[i + 1]) {
            return false;
        }
    }
    return true;
}
