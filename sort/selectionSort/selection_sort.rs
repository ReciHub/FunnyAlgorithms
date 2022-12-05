fn selection_sort (arr: & mut[i32]) {
    let len = arr.len();

    for left in 0..len {
        let mut smallest = left;
        for right in (left + 1)..len {
            if arr[right] < arr[smallest] {
                smallest = right;
            }
        }
        arr.swap(smallest, left);
    }
}

fn print_array(arr: &mut[i32]) {
    let size = arr.len();

    for i in 0..size {
        println!("{} ", arr[i]);
    }
    println!("\n");
}

fn main() {
    let mut array= [64, 34, 25, 12, 22, 11, 90];

    println!("Unsorted array: \n");
    print_array(&mut array);

    selection_sort(&mut array);

    println!("Sorted array: \n");
    print_array(&mut array);
}