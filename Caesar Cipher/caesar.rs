fn caesar(input_str: String, num: u8) -> String {
    let mut result = String::from("시저 암호: ");

    let char_vec: Vec<char> = (&input_str).chars().collect();
    
    for c in char_vec {
        let mut c_ascii = c as u8;
        if num >= 1 && num <= 25 {
            if c_ascii >= 65 && c_ascii <= 90 {
                c_ascii += num;
                if c_ascii > 90 {
                    c_ascii -= 26;
                }
                result.push_str(&(c_ascii as char).to_string());
            } else if c_ascii >= 97 && c_ascii <= 122 {
                c_ascii += num;
                if c_ascii > 122 {
                    c_ascii -= 26;
                }
                result.push_str(&(c_ascii as char).to_string());

            } else if c_ascii == 32 {
                result.push_str(" ");
            } else{
                result.push_str("알파벳 소문자, 대문자, 공백으로만 이루어진 암호만 입력 가능합니다.");
                result = "".to_string();
                break;
            }
        } else {
            result.push_str("num은 1 이상, 25 이하인 자연수만 가능합니다.");
            break;
        }
    }
    return result;
}

fn main(){
    let cipher = String::from("My name is Peter");
    let num: u8 = 20;

    println!("문자열: {}", &cipher);

    let caesar_cipher = caesar(cipher, num);

    println!("{}", &caesar_cipher);
}