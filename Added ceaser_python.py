def caesar_cipher(text, shift, decrypt=False):
    result = ""

    for char in text:
        if char.isalpha():
            shift_amount = shift
            if decrypt:
                shift_amount = -shift  # Reverse the shift for decryption

            char_code = ord(char)
            if char.islower():
                result += chr(((char_code - 97 + shift_amount) % 26) + 97)
            else:
                result += chr(((char_code - 65 + shift_amount) % 26) + 65)
        else:
            result += char

    return result

def main():
    text = input("Enter the text: ")
    shift = int(input("Enter the shift value: "))
    is_decrypt = input("Decrypt? (yes/no): ").lower() == "yes"

    if is_decrypt:
        decrypted_text = caesar_cipher(text, shift, decrypt=True)
        print("Decrypted text:", decrypted_text)
    else:
        encrypted_text = caesar_cipher(text, shift)
        print("Encrypted text:", encrypted_text)

if __name__ == "__main__":
    main()
