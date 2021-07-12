game_in_progress = True

while game_in_progress:
    print("Do you eat kitkats in one big bite or in pieces?")
    print("(Type in '1' for one big bite or '2' for pieces)")
    kitkat_choice = int(input())

    if kitkat_choice == 1:
        print("You are weird.")
        game_in_progress = False

    elif kitkat_choice == 2:
        print("You are normal... so far.")
        print("Do you pour the milk first or the cereal?")
        print("(Type in '1' for milk or '2' for cereal)")

        breakfast_choice = int(input())

        if breakfast_choice == 1:
            print("You are weird")
            game_in_progress = False 

        elif breakfast_choice == 2:
            print("OK... you are still normal...")
            print("Do you chomp out a whole bite of a string cheese stick or do you peel individual strings off and eat them?")
            print("(Type in '1' for the first option or '2' for the second one)")

            cheese_choice = int(input())

            if cheese_choice == 1:
                print("Nope. You're weird.")
            elif cheese_choice == 2:
                print("OK... you are still normal...")
                print("Do you do you scrunch or fold your toilet paper?")
                print("(Type in '1' for the first option or '2' for the second one)")

                toilet_paper_choice = int(input())
                
                if toilet_paper_choice == 1:
                print("Nope. You're weird.")

                elif toilet_paper_choice == 2:
                    print("You made it! Congratulations, you're not weird.")
                game_in_progress = False

    else:
        print("Invalid Input. Restart")
