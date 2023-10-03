def letter_shift(letter: str, shift: int) -> str:
    """Function that shifts a given letter by a certain
    shift that is also given, then returns the shifted 
    letter from the brazilian portuguese character set

    Args:
        letter (str): letter to be encrypted
        shift (int): shift from the character set

    Returns:
        str: letter that was shifted
    """
    # Caesar cipher implemented over brazilian portuguese character set
    alphabet = 'abcdefghijklmnopqrstuvwyzàáãâéêóôõíúçABCDEFGHIJKLMNOPQRSTUVWYZÀÁÃÂÉÊÓÕÍÚÇ'
    index_shifted = alphabet.find(letter) + shift

    if index_shifted > len(alphabet) - 1:
        index_shifted = index_shifted % len(alphabet)

    letter_shifted = alphabet[index_shifted]    
    return letter_shifted


def caesar_cypher(str_user : str, shift: int = 3) -> str:  
    """Function that shifts a string by a certain
    shift that is also given, then returns the shifted 
    string from the brazilian portuguese character set

    Args:
        letter (str): letter to be encrypted
        shift (int): shift from the character set

    Returns:
        str: letter that was shifted
    """  
    converted_str = ''
    for letter in str_user:
        if letter == ' ':
            converted_str+= ' '
            pass
        else:
            converted_str+=letter_shift(letter, shift)
    return converted_str        

def run() -> None:
    """Run function, provides a menu to the user to either encrypt a message with the default shift or
    gives the option of encrypting the message with a custom shift, this application of the caesar cypher
    utilizes the brazilian portuguese character set.
    """
    print("Menu - Perfect Numbers Program \nTo Encrypt a message with the default shift  - press 0\nTo Encrypt a message with a custom shift     - press 1")
    user_choice = int(input())
    if user_choice == 0:
        user_input = input("Please provide the message that will be cyphered: ")
        cyphered_msg = caesar_cypher(user_input)
        print(f'Your message cyphered by the caeser cypher is: {cyphered_msg}')
    elif user_choice == 1:
        user_input = input("Please provide the message that will be cyphered: ")
        user_shift = int(input("Please provide the shift for cypher: "))
        cyphered_msg = caesar_cypher(user_input, user_shift)
        print(f'Your message cyphered by the caeser cypher is: {cyphered_msg}')
    else:
        print("Please select a valid option")        
        run()    
    

if __name__ == "__main__":
    run()
    