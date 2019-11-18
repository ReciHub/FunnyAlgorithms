use std::io;


fn main() {
    let mut beer = String::new();
    println!("Should I check if it time for beer? Y/n");

    io::stdin().read_line(&mut beer).expect("Failed to read line");
    if beer.trim()=="y" || beer.trim()=="Y" {
        println!("It is always time for beer!!!!");
    }
    else if beer.trim()=="n" || beer.trim()=="N" {
        println!("Guess I'll check out later");
    }
    else {
        println!("Invalid input");
    }
}
