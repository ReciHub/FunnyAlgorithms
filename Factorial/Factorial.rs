fn factorial(n: usize) -> usize {
    (2..=n).product()
}

fn main() {
    let mut input_text = String::new();
    println!("Enter a positive integer: ");
    std::io::stdin()
        .read_line(&mut input_text)
        .expect("failed to read from stdin");

    let trimmed = input_text.trim();
    match trimmed.parse::<usize>() {
        Ok(i) => println!("Factorial of {} is {}", i, factorial(i)),
        Err(..) => println!("this was not an integer: {}", trimmed),
    };
}
