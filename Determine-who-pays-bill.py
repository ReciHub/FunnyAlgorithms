def split_bill(total_amount, num_people):
    if num_people <= 0:
        return "Invalid number of people"

    # Calculate the amount each person should pay
    per_person_amount = total_amount / num_people

    return per_person_amount

# Example usage:
total_bill = 120.50
number_of_people = 4

amount_per_person = split_bill(total_bill, number_of_people)

if amount_per_person != "Invalid number of people":
    print(f"Total bill: ${total_bill:.2f}")
    print(f"Each person should pay: ${amount_per_person:.2f}")
else:
    print("Please provide a valid number of people.")
