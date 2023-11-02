import random
import time

heckles = [
    "You call that a joke?",
    "Boo! Get off the stage!",
    "I've heard better jokes from my pet parrot!",
    "You're funnier when you're silent.",
    "Is this a comedy show or a nightmare?",
    "You should try another career.",
]

def stand_up_comedy():
    print("Welcome to the comedy show!")
    time.sleep(2)
    
    for _ in range(5):  # Simulating a short stand-up routine
        joke = input("Comedian: ")  # Comedian's joke
        print("AI Heckler:", random.choice(heckles))
    
    print("Thanks for the laughs!")

if __name__ == "__main__":
    stand_up_comedy()
