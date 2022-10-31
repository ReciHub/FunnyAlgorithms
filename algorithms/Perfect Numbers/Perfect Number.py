def is_perfect_number(num: int) -> bool:
    """Function that checks if a given integer is a perfect number

    Args:
        num (int): integer to be tested

    Returns:
        bool: True if a perfect number, False if not
    """
    count = 0
    for i in range(1,num):
        if num % i == 0:
            count += i  
    
    if num != count:
        return False
    return True

def run() -> None:
    """Run function, provides a menu to the user to either print perfect numbers or test if a number is perfect.
    Since the task of printing perfect numbers by using the test function is heavy, a choice is given to either
    perform the task or give the user information and a link that contains the current list of found perfect 
    numbers.
    """
    print("Menu - Perfect Numbers Program \nTest a given number   - press 0 \nPrint perfect numbers - press 1")
    user_choice = int(input())

    if user_choice == 0:
        user_num = int(input("Which number would you like to test? "))
        if is_perfect_number(user_num):
            print(f"The number {user_num} is a perfect number")
            return
        print(f"The number {user_num} is NOT a perfect number") 

    elif user_choice == 1:
        print("How many perfect numbers would you like to print?")
        x = int(input("(4 is the largest reccommended): "))
        a = 1
        count = 0

        if x >= 5:
            print("Since this is a heavy computational task, \nPress 0 to get more info about perfect\nPress 1 to keep going")
            user_choice_sec = int(input())
            if user_choice_sec == 0:
                print("The 5 firstmost perfect numbers are:\n6, 28, 496, 8128, 33550336;\nthe list with all found as at the moment is\navailable at: https://oeis.org/A000396")
                return
            elif user_choice_sec == 1:
                pass
            else:
                print("Not a valid choice, exiting program...")
                return

        print("Printing perfect numbers:")  

        while count < x:

            if is_perfect_number(a):
                count += 1
                print(a) 
            a += 1   

    else:
        print("Please select a valid option\n")        
        run()

if __name__ == "__main__":
    run()
    