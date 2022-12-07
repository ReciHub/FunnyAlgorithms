fn check_prime_number(n: String) {
    let my_number = &n.trim();
    let my_number_int = n.trim().parse::<i32>().unwrap();

    let mut is_prime_number = true;

    for i in 2..my_number_int {
        if my_number_int % i == 0 {
            is_prime_number = false;
            break;
        }
    }

    let mut result = String::from("");
    if is_prime_number {
        result.push_str(my_number);
        result.push_str(" is a prime number");
    } else{
        result.push_str(my_number);
        result.push_str(" is not a prime number");
    }
    return println!("{}", result);
}

fn main(){
    let mut num = String::new();
    println!("Enter number: ");
    std::io::stdin().read_line(&mut num).unwrap();

    check_prime_number(num);
}