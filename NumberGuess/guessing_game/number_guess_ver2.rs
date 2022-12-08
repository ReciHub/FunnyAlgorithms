// we have to guess the number that lies between 1 and 100.
// If you guess right...you win, else you loose. You have 5 tries.
// If you guess wrong... it will tell you whether your guess is big or small

// written in rust-lang by Youjeong

use rand::Rng;
use std::cmp::Ordering;
use std::io;

fn guess_num() {
    let random_num = rand::thread_rng().gen_range(1, 101);
    // println!("{}", random_num);

    let mut success = false;
    for i in 0..5 {
        let mut guess = String::new();
        println!("Guess The Number !");
        io::stdin()
            .read_line(&mut guess)
            .expect("Failed to read line");

        let guess: u32 = guess.trim().parse().expect("Please type a number!");

        match guess.cmp(&random_num) {
            Ordering::Less => println!("Too small"),
            Ordering::Greater => println!("Too big"),
            Ordering::Equal => success = true,
        }
        if success == true {
            println!("You Win");
            return;
        }
    }
    println!("You Lose");
}

fn main() {
    let mut game_play = String::from("y");
    loop {
        // assert_eq!(game_play, "y");

        if &game_play == "Y" || &game_play == "y" {
            guess_num();

            println!("\nDo You Wanna Play Again? ");
            game_play.clear();
            io::stdin()
                .read_line(&mut game_play)
                .expect("Failed to read line");

            let new_game_play = game_play.trim_end().to_string();
            game_play = new_game_play.to_string();
        } else {
            break;
        }
    }
}
