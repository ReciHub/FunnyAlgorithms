// we have to guess the number that lies between 1 and 100.
// If you guess right...you win, else you loose. You have 5 tries.

// written in rust-lang by Youjeong

use rand::Rng;
use std::cmp::Ordering;
use std::io;

fn guess_num() {
    let random_num = rand::thread_rng().gen_range(1, 101);
    println!("{}", random_num);

    let mut chance = 1;
    loop {
        let mut guess = String::new();
        println!("Guess The Number !");
        io::stdin()
            .read_line(&mut guess)
            .expect("Failed to read line");

        let guess: u32 = guess.trim().parse().expect("Please type a number!");

        if random_num == guess {
            println!("You Win");
            return;
        } else {
            chance += 1;
            if chance > 5 {
                println!("You Lose");
                return;
            }
            println!("Try Again");
        }
    }
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
