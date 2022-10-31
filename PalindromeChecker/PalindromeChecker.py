def check_palin(string):
    n = len(string)
    for i in range(int(n/2)):
        if(string[i]!=string[n-i-1]):
            return False
    
    return True

def main():
    print("Input the String: ")
    string = input()

    if(check_palin(string)):
        print("String is a Palindrome")
    else:
        print("String is not a Palindrome")
        
if __name__ == '__main__':
    main()
    
