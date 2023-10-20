use std::io;

fn main() {
    println!("Enter your text :");

    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Failed to read the line");

    let words: Vec<&str> = input.trim().split_whitespace().collect();
    println!("Your text contains {} words.", words.len());
}