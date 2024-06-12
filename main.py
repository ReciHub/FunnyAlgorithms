import random

print("WELCOME TO THE GAME OF STONE, PAPER, SCISSORS!!")

round = int(input("How many rounds you would like to play? "))
user_point = 0
comp_point = 0

rock = '''
    _______
---'   ____)
      (_____)
      (_____)
      (____)
---.__(___)
'''

paper = '''
    _______
---'   ____)____
          ______)
          _______)
         _______)
---.__________)
'''

scissors = '''
    _______
---'   ____)____
          ______)
       __________)
      (____)
---.__(___)
'''

images = [rock,paper,scissors]

for i in range(round):
    
    print("ROUND: ", i+1)
    
    user_choice = int(input("""What is your play?
    Type 0 for Rock
    Type 1 for Paper
    Type 2 for Scissors\n"""))

    if user_choice >= 3 or user_choice < 0:
        print("You should either choose Rock, Paper or Scissor")
    else:
        print(images[user_choice])

        computer_choice = random.randint(0, 2)
        print("Computer chose:")
        print(images[computer_choice])

        if user_choice == 0 and computer_choice == 2:
            print("Yes! You WON")
            user_point+=1

        elif computer_choice == 0 and user_choice == 2:
            print("Oh No! You LOSE")
            comp_point+=1

        elif computer_choice > user_choice:
            print("Oh No! You LOSE")
            comp_point+=1

        elif user_choice > computer_choice:
            print("Yes! You WON")
            user_point+=1

        elif computer_choice == user_choice:
            print("Toit! It's a DRAW")
print("-----------------------------------------------")
print()

if user_point > comp_point:
    print("CONGRATULATIONS!! YOU WON THE GAME ")

elif comp_point > user_point:
    print("SORRY, YOU LOST THE GAME")

elif user_point == comp_point:
    print("GOOD GAME! ITS A DRAW")




