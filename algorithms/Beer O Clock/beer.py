# A funny simple question to check is it time to
# drink beer yet.
def beer():
    while True:
        ip = str(input("> Should I check if it is time to have Beer ? (Y / N) "))
        if ip.lower() == 'n':
            print("> We check later")
            return
        if ip.lower() == 'y':
            print("> It always is beer of clock. Cheers !!!")
            return
        print("> Invalid input, try again.")

if __name__ == "__main__":
    beer()