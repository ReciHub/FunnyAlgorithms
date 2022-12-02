use std::io;
use std::collections::HashSet;

fn main() {
    let mut input_number = String::new();
    println!("Let see if your number is happy... : ");

    io::stdin().read_line(&mut input_number).expect("Fail to read line");

    let test_number: i32 = input_number.trim().parse().expect("Please type a number!");
    
    println!("Your Number is {}", test_number);

    is_happy(test_number);

    if is_happy(test_number){
        println!("Your number said 'I am happy ~~ 😊😊😊 ~~~'");
    }else {
        println!("Your number said 'I am not happy ... 🥲🥲🥲 ...'");
    }

}

fn is_happy(num: i32) -> bool {
    let mut _numbers: HashSet<i32> = HashSet::new();

    let mut sum = 0;
    let mut number = num;

    while sum != 1 {
        sum = 0;
        while number != 0 {
            let value = number % 10;
            sum += value * value;
            number = number / 10;
        }

        if _numbers.contains(&sum) {
            return false;
        }

        _numbers.insert(sum);
        number = sum;
    }
    true
}