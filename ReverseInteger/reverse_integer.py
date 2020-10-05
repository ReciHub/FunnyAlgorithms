def reverse_integer(integer):
    def split(word): 
        return [char for char in word] 

    reversed = ""
    return reversed.join(split(str(integer))[::-1])

# Tests
print(reverse_integer(43455))