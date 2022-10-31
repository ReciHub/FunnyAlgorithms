use std::io;

fn main() {
    println!("-------------------");
    println!("Fibonacci Printer!");
    println!("-------------------");

   let count: u32 = get_count();

   println!("----------------------------------------------");
   println!("Fibonacci printer will go brrrrrrr {} times!", count);
   println!("----------------------------------------------");

   print_fibo(count);

   println!("--------------------------------");
   println!("Fibonacci printer has finished!");
   println!("--------------------------------");

   let mut exit_code = String::new();
   println!("Press Return to exit.");
   io::stdin()
            .read_line(&mut exit_code)
            .expect("Cant Exit :(");
}//end main

fn get_count() -> u32 {
    let final_count: u32 = loop {
        let mut count = String::new();
        println!("How many Fibonacci's do you want to print?");
        io::stdin()
            .read_line(&mut count)
            .expect("Invalid amount of Fibonacci's :(");
        
        let count: u32 = match count.trim().parse() {
            Ok(num) => num,
            Err(_) => {
                continue 
            },
        };
        break count;
    };
    final_count
}

fn print_fibo(count: u32) {
    let mut i: u32 = 1;
    
    let mut x: u64 = 0;
    let mut y: u64 = 1;
    let mut z: u64 = 0;
    
    while i <= count {
        println!("{}", x);
        z = x + y;
        x = y;
        y = z;
        i += 1;
    }
}
