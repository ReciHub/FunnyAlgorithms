use std::io;

fn count_coins(money: &mut u32, coins: &mut [u32]) -> Vec<u32>{
    let mut result_vec: Vec<u32> = Vec::new();
    for i in 0..(coins.len()){
        while money >= &mut coins[i] {
            if money < &mut coins[i] {
                break;
            }
            result_vec.push(coins[i]);
            *money = *money - coins[i];
        }
        
    }
    return result_vec;
}

fn main(){
    println!("How much money is to be converted into coins?");
    let mut money = String::new();
    io::stdin().read_line(&mut money).expect("Failed to read line");
    let mut money: u32 = money.trim().parse().expect("Please type a number!");
    let mut coins:[u32; 5] = [25, 10, 5, 2, 1];

    let counted_vec = count_coins(&mut money, &mut coins);

    for counted in &counted_vec {
        print!("{} ", counted);
    }
}