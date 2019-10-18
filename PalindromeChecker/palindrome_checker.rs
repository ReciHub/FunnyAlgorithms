fn is_palindrome(s: &str) -> bool {
    let half_len = s.len() / 2;
    s.bytes().take(half_len).eq(s.bytes().rev().take(half_len))
}

fn main() {
    println!("Is `hello` a palindrome?\n {}", is_palindrome("hello"));
    println!(
        "Is `tomato otamot` a palindrome?\n {}",
        is_palindrome("tomato otamot")
    );
}
