VALID_YES_RESPONSES = [
    "y",
    "yes",
    "yeah",
    "yep",
    "ye"
]

VALID_NO_RESPONSES = [
    "n",
    "no",
    "nah",
    "nope"
]

def print_ok():
    print(":D")
    print("Well, everything actually seems ok with you")

def print_not_ok():
    print(":(")
    print("Hope you get better my friend")

def print_definitely_not_ok():
    print("You're definitely not ok.")

print("Oh, hey there, are u ok buddy?")
is_okay_response = input()
if is_okay_response in VALID_NO_RESPONSES:
    print_not_ok()
elif is_okay_response in VALID_YES_RESPONSES:
    print("Really? oh that's great")
    print("Hey have you ever searched for 'sea doggos' videos?")
    has_searched_response = input()
    if has_searched_response in VALID_NO_RESPONSES:
        print_definitely_not_ok()
    elif has_searched_response in VALID_YES_RESPONSES:
        print_ok()
