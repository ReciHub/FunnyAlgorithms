import webbrowser
import time

QUIT_REQUEST_RESPONSES = [
    "quit",
    "exit",
    "leave",
    "stop",
    "cancel",
    "cease",
    "kill",
    "go away"]

VALID_YES_RESPONSES = [
    "y",
    "yes",
    "yeah",
    "yep",
    "ye"
    "yea"
    "yae"
    "mhm"
    'yas'
    'yup'
    'sure']
VALID_NO_RESPONSES = [
    "n",
    "no",
    "nah",
    "nope"]

def printellipsis(time = 2.0):
    interval = time / 3
    for loop in range (3):
        print(".", end = '')
        time.sleep(interval)


def print_ok():
    print(":D")
    print("Well, everything actually seems ok with you")
    time.sleep(1.5)
    print("")

def print_not_ok():
    print(":(")
    print("Hope you get better my friend, help is on it's way...")
    time.sleep(3)
    webbrowser.open('https://www.bing.com/images/search?q=puppy')

def print_definitely_not_ok():

    print("You're definitely not ok.")


def main():
    while True:
        try:
            help()
        except:
            for loop in range (2):
                print("...")
            print("That isn't a valid response, please try again.")
            print()

def help():
    print("Oh, hey there, are u ok buddy?")
    is_okay_response = input(">>> ")
    if is_okay_response in QUIT_REQUEST_RESPONSES:
        print("okay, exiting the program", end='')
        for loop in range(3):
            print(".", end='')
            time.sleep(1)
        print()
        SystemExit()
    elif is_okay_response in VALID_NO_RESPONSES:
        print_not_ok()
    elif is_okay_response in VALID_YES_RESPONSES:
        print("Really? oh that's great")
        print("Hey have you ever searched for 'sea doggos' videos?")
        has_searched_response = input(">>> ")
        if has_searched_response in VALID_NO_RESPONSES:
            print_definitely_not_ok()
            time.sleep(15)
            webbrowser.open("https://www.bing.com/images/search?q=sea+doggos")
        elif has_searched_response in VALID_YES_RESPONSES:
            print_ok()

    else:
        raise Exception("invalid answer")

main()