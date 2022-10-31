def get_next_term(n):
    next_term, term = [], str(n)
    previous_digit, count = term[0], 0

    for digit in term:
        if digit == previous_digit:
            count += 1
        else:
            next_term.append(f'{count}{previous_digit}')
            count = 1

        previous_digit = digit

    next_term.append(f'{count}{previous_digit}')

    return ''.join(next_term)


def print_look_and_say(seed, n):
    print(seed)
    next_term = get_next_term(seed)
    for i in range(n-1):
        print(next_term)
        next_term = get_next_term(next_term)


seed = input('What is the first term? ')
n = int(input('How many terms to display? '))
print_look_and_say(seed, n)
