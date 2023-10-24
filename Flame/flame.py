def calculate_flames(name1, name2):
    name1 = name1.lower()
    name2 = name2.lower()

    # Remove spaces from the names
    name1 = name1.replace(" ", "")
    name2 = name2.replace(" ", "")

    # Create a dictionary to count the frequency of each letter in the names
    name1_count = {}
    name2_count = {}

    for letter in name1:
        if letter in name1_count:
            name1_count[letter] += 1
        else:
            name1_count[letter] = 1

    for letter in name2:
        if letter in name2_count:
            name2_count[letter] += 1
        else:
            name2_count[letter] = 1

    # Calculate the total count of letters in both names
    total_count = 0

    for letter in name1_count:
        if letter in name2_count:
            total_count += min(name1_count[letter], name2_count[letter])

    # Define the FLAMES acronym
    flames = "FLAMES"

    # Determine the relationship
    while len(flames) > 1:
        remove_index = (total_count % len(flames)) - 1
        if remove_index == -1:
            remove_index = len(flames) - 1
        flames = flames[:remove_index] + flames[remove_index + 1:]

    # Map the final letter to the corresponding relationship
    relationship = {
        'F': "Friends",
        'L': "Lovers",
        'A': "Affection",
        'M': "Marriage",
        'E': "Enemies",
        'S': "Siblings",
    }

    return relationship[flames]

# Input the names of the two people
name1 = input("Enter the first name: ")
name2 = input("Enter the second name: ")

result = calculate_flames(name1, name2)
print(f"The relationship between {name1} and {name2} is {result}.")
