fn quicksort_recursive<T: std::cmp::PartialOrd + Clone>(mut vector: Vec<T>) -> Vec<T> {
    match vector.len() {
        0|1 => vector,
        _ => {
            let pivot = vector.pop().unwrap();
            let lesser: Vec<T> = vector.clone().into_iter().filter(|i| i.lt(&pivot)).collect();
            let greater: Vec<T> = vector.clone().into_iter().filter(|i| i.ge(&pivot)).collect();
            let mut lesser = quicksort_recursive(lesser);
            lesser.push(pivot);
            lesser.extend(quicksort_recursive(greater).into_iter());
            lesser
        },
    }
}


fn main() {
    let unsorted = vec![9.1,1.4,5.7,3.5,6.3,2.1,5.1];
    println!("unsorted: {:?}", unsorted);
    let sorted = quicksort_recursive(unsorted);
    println!("sorted: {:?}", sorted);
}
