import random

def tell_joke():
    jokes = [
        "Why did the computer go to therapy? It had too many bytes of emotional baggage!",
        "What do you call fake spaghetti? An impasta!",
        "Why don't scientists trust atoms? Because they make up everything!",
        "How does a penguin build its house? Igloos it together!",
        "Why did the scarecrow win an award? Because he was outstanding in his field!",
    ]

    joke = random.choice(jokes)
    print("Get ready for a laugh!\n")
    print(joke)

if __name__ == "__main__":
    tell_joke()
