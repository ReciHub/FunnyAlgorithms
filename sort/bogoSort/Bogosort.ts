function isSorted(arr: number[]) {
    for(let i=1; i<arr.length; i++) {
        if(arr[i] < arr[i-1]) {
            return false;
        }
    }
    return true;
}

function shuffle(arr: number[]) {
    for(let i=1; i < arr.length; i++) {
        let t = arr[i];
        let j = Math.floor(Math.random()*i);
        arr[i] = arr[j];
        arr[j] = t;
    }
}

function bogoSort(arr: number[]) {
    while(!isSorted(arr)) {
        shuffle(arr);
    }
}

let arr = [3, 45, -2, 6, -9, 10, 1, 0];
bogoSort(arr);
console.log('Sorted: ', arr.join(' '));
