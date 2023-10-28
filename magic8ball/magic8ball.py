import random

def magic_8_ball():
    responses = [
        "Yes, definitely.",
        "No, not a chance.",
        "I'm not sure, try again later.",
        "Ask again later.",
        "Yes, but proceed with caution.",
        "No, it's not advisable.",
        "Absolutely!",
        "I wouldn't count on it."
    ]

    print("Welcome to the Magic 8-Ball!")
    while True:
        question = input("Ask a yes or no question (or type 'quit' to exit): ")
        if question.lower() == 'quit':
            print("Goodbye!")
            break
        else:
            print(random.choice(responses))

if __name__ == "__main__":
    magic_8_ball()
