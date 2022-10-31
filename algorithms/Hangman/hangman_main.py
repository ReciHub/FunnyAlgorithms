# This is the hangman game
# The user will have to answer 10 different questions
# If they get the wrong answer, they will hang the man
# If they got 6 mistakes, the man dies
# If they got less than 6 mistakes, they win the game


win = 0
loss = 0

def hangman():
    global win
    global loss
    score = 0
    # first question
    first_question = str.lower(input("1. What is always coming, but never arrives?: "))
    if first_question == "tomorrow":
        score += 1
        print("Good answer!")
    else:
        score -= 0
        print("Wrong answer! You just started to hang your man.")
    # second question
    second_question = str.lower(input("2. What can be broken, but is never held?: "))
    if second_question == "promise":
        score += 1
        print("You got it right!")
    else:
        score -= 0
        print("Wrong answer! Your man is in danger... Be careful!")
    # third question
    third_question = str.lower(input("3. What is it that lives if it is fed, and dies if you give it a drink?: "))
    if third_question == "fire":
        score += 1
        print("Very good!")
    else:
        score -= 0
        print("Wrong answer! You can do better...")
    # Fourth question
    fourth_question = str.lower(input("4. What can one catch that is not thrown?: "))
    if fourth_question == "cold":
        score += 1
        print("Are you a genius? You're right!")
    else:
        score -= 0
        print("Wrong answer!")
    # Filth question
    filth_question = str.lower(input("5. What is it that if you have, you want to share me, and if you share, you do not have?: "))
    if filth_question == "secret":
        score += 1
        print("Very good! It's true.")
    else:
        score -= 0
        print("Oh! Wrong answer...")
    # Sixth question
    sixth_question = str.lower(input("6. What goes up and down, but always remains in the same place?: "))
    if sixth_question == "stairs":
        score += 1
        print("Good answer!")
    else:
        if score == 0:
            loss += 1
            print("Sorry, but your man dies!")
            restart = input("Do you wish to restart again? (yes, yeah, y/ no, n): ")
            if restart == "yes" or restart == "yeah" or restart == "y":  # This will ask if the user want to play again
                main()
            else:
                exit("You have made " + str(win) + " win(s) " + "and " + str(loss) + " loss(es).")
        else:
            print("You are wrong!")
    # Seventh question
    seventh_question = str.lower(input("7. What is it that goes up, but never comes down: "))
    if seventh_question == "age":
        score += 1
        print("Correct! Snaps for you!")
    else:
        if score <= 1:
            loss += 1
            print("Sorry, but your man dies! You can do better!")
            restart = input("Do you wish to restart again? (yes, yeah, y/ no, n): ")
            if restart == "yes" or restart == "yeah" or restart == "y":
                main()
            else:
                exit("You have made " + str(win) + " win(s) " + "and " + str(loss) + " loss(es).")
        else:
            print("Oh! Wrong answer...!")
    # Eighth question
    eighth_question = str.lower(input("8. What word starts with IS, ends with AND, and has LA in the middle?: "))
    if eighth_question == "island":
        score += 1
        print("Correct!!")
    else:
        if score <= 2:
            loss += 1
            print("Sorry, but your man dies!")
            restart = input("Do you wish to restart again? (yes, yeah, y/ no, n): ")
            if restart == "yes" or restart == "yeah" or restart == "y":
                main()
            else:
                exit("You have made " + str(win) + " win(s) " + "and " + str(loss) + " loss(es).")
        else:
            print("Oh! Wrong answer...!")
    # Ninth question
    ninth_question = int(input("9. If George’s father has four children – Eenie, Meenie, Miney – what is the name of his fourth child?: "))
    if ninth_question == "george":
        score += 1
        print("Correct! You are right!")
    else:
        if score <= 2:
            loss += 1
            print("Sorry, but your man dies!")
            restart = input("Do you wish to restart again? (yes, yeah, y/ no, n): ")
            if restart == "yes" or restart == "yeah" or restart == "y":
                main()
            else:
                exit("You have made " + str(win) + " win(s) " + "and " + str(loss) + " loss(es).")
        else:
            print("Oh! Wrong answer...!")
    # Tenth question
    tenth_question = str.lower(input("10. Which is the fastest country in the world?: "))
    if tenth_question == "russia":
        score += 1
    else:
        if score <= 4:
            loss += 1
            print("Sorry, but your man dies! You can do better next time!")
            restart = input("Do you wish to restart again? (yes, yeah, y/ no, n): ")
            if restart == "yes" or restart == "yeah" or restart == "y":
                main()
            else:
                exit("You have made " + str(win) + " win(s) " + "and " + str(loss) + " loss(es).")
    print("Your man is alive! Congratulations!")
    mistake = 10 - score
    win += 1
    print("You score is " + str(score) + " and you have made " + str(mistake) + " mistakes.")
    restart = input("Do you wish to restart again? (yes, yeah, y/ no, n): ")
    if restart == "yes" or restart == "yeah" or restart == "y":
        main()
    else:
        exit("You have made " + str(win) + " win(s) " + " and " + str(loss) + " loss(es).")

print("------------------- WELCOME TO HANGMAN BRAVE HUMAN ----------------------" + "\n")
print("Let's start the game: " + "\n")
hangman()