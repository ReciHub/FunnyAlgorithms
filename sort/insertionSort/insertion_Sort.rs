fn insertion_sort(arr: &mut) {
    for i in 1..arr.len() {
        let mut j = i;
        while j > 0 && arr[j] < arr[j - 1] {
            arr.swap(j, j - 1);
            j = j - 1;
        }
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

    insertion_sort(&mut array);

    println!("Sorted array: \n");
    print_array(&mut array);
}