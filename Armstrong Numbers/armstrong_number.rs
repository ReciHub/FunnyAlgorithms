// armstrong number : abc = a*a*a + b*b*b + c*c*c
// finding armstrong numbers in 100~999
// written in rust-lang by Youjeong

fn is_armstrong(num: i32) -> bool {
    let mut sum = 0;
    let mut num2 = num;

    loop {
        sum += (num2 % 10) * (num2 % 10) * (num2 % 10);
        num2 = num2 / 10;

        if num2 <= 0 {
            break;
        }
    }
    return sum == num;
}

fn main() {
    let mut _num: i32;
    println!("armstrong num abc = a*a*a + b*b*b + c*c*c\n");

    for _num in 100..1000 {
        if is_armstrong(_num) {
            println!("{} ", _num);
        }
    }
    println!("\n");
}
