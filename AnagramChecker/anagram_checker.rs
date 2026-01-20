fn is_anagram(word1: String, word2: String) {
    let mut word1_vec: Vec<char> = (&word1).chars().collect();
    let mut word2_vec: Vec<char> = (&word2).chars().collect();

    word1_vec.sort();
    word2_vec.sort();

    if word1_vec == word2_vec {
        print!("Anagrams!");
    } else{
        print!("Not Anagrams!");
    }

    println!("");
}

fn main(){
    let mut word1 = String::new();
    println!("Enter word1: ");
    std::io::stdin().read_line(&mut word1).unwrap();

    let mut word2 = String::new();
    println!("Enter word2: ");
    std::io::stdin().read_line(&mut word2).unwrap();
   
    is_anagram(word1, word2);
}