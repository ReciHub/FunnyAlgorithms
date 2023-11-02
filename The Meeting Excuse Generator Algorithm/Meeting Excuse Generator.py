import random

def generate_meeting_excuse():
    excuses = [
        "I'm attending a top-secret astronaut training session.",
        "I'm busy perfecting my interpretive dance routine.",
        "I'm in the middle of a high-stakes rock-paper-scissors tournament.",
        "I've been recruited as a taste tester for a chocolate factory.",
        "I'm participating in the annual International Thumb-Wrestling Championship.",
        "I'm engaged in an epic battle of wits with a crossword puzzle.",
        "I'm trapped in a heated debate about the best flavor of ice cream.",
        "I have an emergency appointment with my imaginary friend.",
        "I'm attending a crucial meeting with my pet goldfish.",
        "I'm practicing my mind-reading skills in preparation for a psychic convention.",
    ]

    return random.choice(excuses)

# To generate an excuse, call the function
excuse = generate_meeting_excuse()
print("Excuse: " + excuse)
