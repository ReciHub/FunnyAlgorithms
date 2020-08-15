

def fizzBuzz(arr: list) -> list:
    for num in arr:
        if num % 3 ==0 and num % 5 == 0:
            print(f"{num}: FizzBuzz")
        elif num % 3 == 0:
            print(f"{num}: Fizz")
        elif num % 5 == 0:
            print(f"{num}: Buzz")

def main():
    fizzBuzz(list(range(1,21)))

if __name__ == '__main__':
    main()