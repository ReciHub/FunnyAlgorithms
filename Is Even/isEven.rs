use std::io;
fn main(){
    let mut new_input = String::new();
    io::stdin().read_line(&mut new_input).expect("Failed to read line");
    let new_input: u32 = new_input.trim().parse().expect("Please type a number!");
    
    if new_input % 2 == 1 {
        println!("{} is Odd", new_input);
    }
    else {
        println!("{} is Even", new_input);
    }
}