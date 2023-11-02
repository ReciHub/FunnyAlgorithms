import random

excuses = [
    "I got stuck in traffic.",
    "My dog ate my homework.",
    "I forgot my password.",
    "I had a family emergency.",
    "My computer crashed.",
    "I overslept.",
    "I had a doctor's appointment.",
    "I had a power outage.",
    "I had a last-minute meeting.",
    "I lost track of time."
]

def generate_random_excuse():
    return random.choice(excuses)

# Generate and print a random excuse
random_excuse = generate_random_excuse()
print("Excuse: " + random_excuse)
