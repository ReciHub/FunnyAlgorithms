// bubble sort in rust

fn main() {
    let mut num = [4, 65, 2, -31, 0, 99, 2, 83, 782, 1];
    println!("Original list: {:?}", num);
    bubble_sort(&mut num);
    println!("Soretd list (ascending):  {:?}\n", num);

}

pub fn bubble_sort<T: Ord>(arr: &mut [T]) {
    for i in 0..arr.len() {
        for j in 0..arr.len() - 1 - i {
            if arr[j] > arr[j + 1] {
                arr.swap(j, j + 1);
            }
        }
    }
}
