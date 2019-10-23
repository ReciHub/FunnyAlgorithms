use std::io;

fn main() {
    println!("Should I check if it is time to have Beer ? (Y / N)");
    let mut input = String::new();
    io::stdin().read_line(&mut input).ok().expect("failed to read line");
    let val: String = input.trim().parse().expect("Invalid input");
    if val == "Y" || val == "y"{
        println!("It's beer o'clock! Cheers!")
    } else if val == "N" || val == "n" {
        println!("Ok, see you later!")
    } else {
        println!("Invalid input")
    }
}
