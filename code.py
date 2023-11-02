import random

# Lists of argument components
subjects = ["Your cat", "Your neighbor", "Your pet rock", "Your breakfast cereal", "Your left shoe"]
verbs = ["stole", "ate", "hid", "destroyed", "worshipped"]
objects = ["your favorite book", "the TV remote", "your homework", "the last cookie", "your smartphone"]

# Generate a random argument
def generate_random_argument():
    subject = random.choice(subjects)
    verb = random.choice(verbs)
    obj = random.choice(objects)
    return f"{subject} {verb} {obj}!"

# Main loop to generate arguments
while True:
    print(generate_random_argument())
    user_input = input("Generate another argument? (yes/no): ")
    if user_input.lower() != "yes":
        break
