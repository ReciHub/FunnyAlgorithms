class Atm:


    # Constructor
    def __init__(self):
        self.pin = ""
        self.balance = 0

    def menu(self):
        user_input = int(input("""
                        0. Enter 0 to exit
                        1. Enter 1 to create pin
                        2. Enter 2 to deposit
                        3. Enter 3 to withdraw
                        4. Enter 4 to check balance
        """))

        if user_input == 1:
            self.create_pin()
        elif user_input == 2:
            self.deposit()
        elif user_input == 3:
            self.withdraw()
        elif user_input == 4:
            self.check_balance()
        elif user_input < 0 or user_input > 4:
            print("Please Enter a valid input")

        return user_input

    def create_pin(self):
        if self.pin == "":
            self.pin = input("Create you pin please: ")
            print("Your pin has been set successfully")
        else:
            print("There is already a pin")

    def check_pin(self):
        pin = input("Enter your pin please: ")
        if pin == self.pin:
            return 1
        else:
            return 0

    def deposit(self):
        if self.pin == "":
            self.create_pin()

        if self.check_pin():
            amount = input("Please enter your deposit amount: ")
            self.balance += int(amount)
            print("Amount has been deposited successfully")
        else:
            print("You have entered wrong pin, please re-enter your pin")
            self.deposit()

    def withdraw(self):
        if self.pin == "":
            self.create_pin()
        if self.check_pin():
            amount = int(input("Please enter your withdrawal amount or press 0 to return to menu: "))
            if amount == 0:
                pass
            elif amount < 0:
                print("Invalid amount")
            elif self.balance >= amount:
                self.balance -= amount
                print("Amount has been withdrawn successfully")
            else:
                print("Insufficient balance")
                self.withdraw()
        else:
            print("You have entered wrong pin")
            self.withdraw()

    def check_balance(self):
        if self.pin == "":
            self.create_pin()
        if self.check_pin():
            print(f"Your current balance is : {self.balance}")
        else:
            print("You have entered wrong pin")
            self.check_balance()


def main():
    asiaBank = Atm()
    primeBank = Atm()

    while 1:
        choice = int(input("""Please Select your bank
        0. Exit
        
        1. Asia Bank: 
        2. Prime Bank
        """))

        if choice == 1:
            print(f"Thanks for choosing Asia Bank")
            while 1:
                stay = asiaBank.menu()
                if not stay:
                    break
        elif choice == 2:
            print(f"Thanks for choosing Prime Bank")
            while 1:
                stay = primeBank.menu()
                if not stay:
                    break
        elif choice == 0:
            break
        else:
            print("Please enter a valid choice")


main()
