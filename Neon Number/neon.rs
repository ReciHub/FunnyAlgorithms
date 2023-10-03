use std::io;
fn main(){
    let mut num = String::new();
    io::stdin().read_line(&mut num).expect("Failed to read line");
    let num: u32 = num.trim().parse().expect("Please type a number!");
    
    let mut sum: u32 = 0;
    let mut squared: u32 = num.pow(2);
    while squared > 0 {
        let sum = sum + squared % 10;
        let squared = squared / 10;
    }
    if sum == num {
        println!("{} is a neon number", num);
    }
    else {
        println!("{} is not a neon number", num);
    }
}