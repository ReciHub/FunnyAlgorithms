fn main() {
    let mut array= [64, 34, 25, 12, 22, 11, 90];
    let size = array.len();

    println!("Unsorted array: \n");
    print_array(&mut array, size);

    bubble_sort(&mut array, size);

    println!("Sorted array: \n");
    print_array(&mut array, size);
}

fn bubble_sort(arr: & mut[i32], size: usize) {
    for i in 0..size-1 {
        for j in 0..size -i -1 {
            if arr[j] > arr[j + 1] {
                arr.swap(j , j+1);
            }
        }
    }
}

fn print_array(arr: &mut[i32], size: usize) {

    for i in 0..size {
        println!("{} ", arr[i]);
    }
    println!("\n");
}
