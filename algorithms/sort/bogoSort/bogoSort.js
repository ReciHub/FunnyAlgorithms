function isSorted(a) {
    for(let i=1; i<a.length; i++) {
        if(a[i] < a[i-1]) {
            return false;
        }
    }
    return true;
}

function shuffle(a) {
    for(let i=1; i<a.length; i++) {
        let t = a[i];
        let j = Math.floor(Math.random()*i);
        a[i] = a[j];
        a[j] = t;
    }
}

function bogoSort(a) {
    while(!isSorted(a)) {
        shuffle(a);
    }
}

let a = [3, 45, -2, 6, -9, 10, 1, 0];
bogoSort(a);
console.log(a.join(' '));
