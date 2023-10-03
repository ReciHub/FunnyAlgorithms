use std::io::stdin;

fn main() {
    println!("Enter the number: ");
    let mut input = String::new();

    stdin().read_line(&mut input);
    let trim_input = input.trim();
    match trim_input.parse::<u32>() {
        Ok(val) => {
            let nums = sieve_of_erastothenes(val);
            for num in nums {
                println!("{num}");
            }
        },
        _ => println!("Invalid input: must be a integer"),
    }

    println!("{input}");
}

fn sieve_of_erastothenes(n: u32) -> Vec<u32> {
    let mut primes = vec![true; n as usize + 1];
    primes[0] = false;
    primes[1] = false;

    for i in 2..=n {
        if primes[i as usize] {
            let mut j = 2;
            while i*j <= n {
                primes[(i*j) as usize] = false;
                j += 1;
            }
        }
    }
    return primes.into_iter().enumerate().filter(|&(_, is_prime)| is_prime).map(|(n, _)| n as u32).collect();
}
