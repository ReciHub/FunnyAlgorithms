![](assets/banner%20gif.gif)

![](https://img.shields.io/badge/Python-%20OOP-%23E60023.svg)
![GitHub stars](https://img.shields.io/github/stars/khalid586/Object-Oriented-Programming-Python) 
 

## [<img src = "https://cdn.dribbble.com/users/1138721/screenshots/10809828/media/478d32b2e65c8c3194b7f2154e179231.gif" align = "center" width = "50px" height = "30px">]() Introduction

**Object Oriented Programming in one of the most important concepts in terms of building scalable softwares.As python is also a object oriented programming language we should get fimiliar to the OOP terminologies by building programs.**

<br>

> **In this repository we will build basic programs using Object oriented programming in Python which will mainly focus on implementing 
Object oriented programming concepts.**

<br>

## [<img src = "https://cdn.dribbble.com/users/1299339/screenshots/3079111/presentation_d.gif" align = "center" width = "50px" height = "30px">]() Concepts

- [**Magic method**](#magic-method)
- **Constructor** (Will be added soon)
- **Self object** (Will be added soon)


### Magic Method
- Dunder or Magic methods in Python are the methods having two prefixes and suffix underscores in the method name.
- Dunder here means “Double Under (Underscores)”. These are commonly used for operator overloading.
- You will get to know more [here](https://www.google.com/amp/s/www.geeksforgeeks.org/dunder-magic-methods-python/amp/)

<br>

## [<img src = "https://cdn.dribbble.com/users/1708950/screenshots/4188877/media/6b06a38e84212c55eac1ef33dbd3d318.gif" align = "center" width = "50px" height = "30px">]() Programs
We will be building following programs
- ### Atm Banking System
    - Our Atm Banking System will have the following features
        - [Select Bank](#select-bank)
            - User will be able to select bank
        - [Select option from Menu](#select-from-menu)
            - User will be able to select operations from the menu
        - [Create Pin](#create-pin)
            - User has to create pin in order to operate
        - [Check Pin](#check-pin)
            - Entered pin will be checked after creating pin 
        - [Deposit Money](#deposit-money)
            - User will be able to deposit money
        - [Withdraw Money](#withdraw-money)
            - User will be able to withdraw money
        - [Check Balance](#check-balance)
            - User will be able to check balance

- ### Custom Datatype (It will be added soon)
    - We will create a custom datatype named **fraction** which will have the following functionalities
        - [Addition]()
            - Add two fractions
        - [Subtraction]()
             - Subtract two fractions
        - [Multiplication]()
             - Multiply two fractions
        - [Division]()
             - Divide two fractions
 


All the features mentioned above will be implemented using OOP as said before.

### Usage of OOP
- User will be able to transit between multiple banks at the same time which will have **different** pin codes, balance  etc.

## [<img src = "https://cdn.dribbble.com/users/2493316/screenshots/14030448/media/8b87a18633c28586e4a315bcdaab031b.gif" align = "center" width = "50px" height = "30px">]() Atm Banking System
**Atm is a very widely used banking system in today's world which has basic features like depositing money, withdrawing money, Checking balance etc. Our Atm will also have features like these.**

- The features are mentioned below

### Select Bank
- User will have to select a bank from the given options and then the menu method will be called by the object.

- **The options will be:**

     0 . Exit

     1 . Asia Bank

     2 . Prime Bank


<details><summary>Code</summary> 

```
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
```
</details>
<br>


[Back to top](#atm-banking-system)

### Select from Menu
- **User will have to select an operation from the menu.**

- **The options will be similiar to the following:**
    -  Enter 0 to exit
    -  Enter 1 to create pin
    -  Enter 2 to deposit
    -  Enter 3 to withdraw
    -  Enter 4 to check balance


<details><summary>Code</summary> 

```
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
```
</details>
<br>

[Back to top](#atm-banking-system)

### Create Pin
- **We will be creating pins for every object and pin is required to perform all other operations.**
- **Without a pin no one can perform any other operation.**
- **If pin is created then every time someone is going to perform any operation pin will be checked.**

<details><summary>Code</summary> 

```
def __init__(self):
        self.pin = ""
        self.balance = 0

def create_pin(self):
        if self.pin == "":
            self.pin = input("Create you pin please: ")
            print("Your pin has been set successfully")
        else:
            print("There is already a pin")
```
</details>
<br>


[Back to top](#atm-banking-system)

### Check Pin
- **If there is a pin already existing in the program then we will check the pin everytime before performing any operation.**
<details><summary>Code</summary> 

```
    def check_pin(self):
        pin = input("Enter your pin please: ")
        if pin == self.pin:
            return 1
        else:
            return 0
```
</details>
<br>


[Back to top](#atm-banking-system)


### Deposit Money
- **In order to deposit money user has to have a pin.**
- **If he doesn't have a pin he has to create one and if he has then we will check the pin he has entered.**
- **After entering the right pin his entered amount will be added to the balance.**

<details><summary>Code</summary> 

```
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
```
</details>
<br>


[Back to top](#atm-banking-system)


### Withdraw Money
- **Just like deposit method, withdraw method will also be performed after entering the right pin.**
- **In this case user has to enter a valid amount as well.** 
- **If the entered amount is sufficient then he can withdraw money otherwise he will be again asked to enter a sufficient amount.**

<details><summary>Code</summary> 

```
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
```
</details>
<br>


[Back to top](#atm-banking-system)


### Check Balance
- **User must create a pin and enter the correct pin in order to check balance.**
- **User will be shown balance when he enters the correct pin just like all the above-mentioned methods.**

<details><summary>Code</summary> 

```
    def check_balance(self):
        if self.pin == "":
            self.create_pin()
        if self.check_pin():
            print(f"Your current balance is : {self.balance}")
        else:
            print("You have entered wrong pin")
            self.check_balance()
```
</details>
<br>

[Back to top](#atm-banking-system)

<!-- # Custom Datatype

## Addition

## Sub

## Mul

## Division -->
