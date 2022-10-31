alphabet = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]

alphabet_dictionary = {"a" : 0 ,"b" : 1,"c" : 2,"d" : 3,"e" : 4,"f" : 5,"g" : 6,"h" : 7,"i" : 8,"j" : 9,"k" : 10,"l" : 11,"m" : 12,"n" : 13,"o" : 14,"p" : 15,"q" : 16,"r" : 17,"s" : 18,"t" : 19,"u" : 20,"v" : 21,"w" : 22,"x" : 23,"y" : 24,"z" : 25}

timeslot1 = [6, 8, 3, 9, 9, 4, 6,	2, 4,	8, 1,	9, 7,	3, 1,	6, 5, 3, 7, 1]
timeslot2 = [3, 7, 1,	5, 2,	9, 1,	3, 9,	4, 7,	1, 2,	1, 2,	5, 1, 9, 5,	2]
timeslot3 = [1, 1, 4, 4, 5,	7, 8,	5, 3, 1, 6,	4, 8,	7, 1,	6, 3,	6, 4, 6]

timeslot_index = -1

new_word = []

print("Would you like to decode or encrpyt your message dude? (D or E)\n")
user_option = input()

if user_option == "D":
  print("What timeslot would you like to pick?\n")
  print("Timeslot: ")
  user_timeslot = input()
  print("What word would you like to decode dude?\n")
  print("Word: ")
  user_word = input()

  for letter in user_word:
    timeslot_index = timeslot_index + 1
    print("\n",letter, timeslot_index)
    if user_timeslot == "1":
      offset = alphabet_dictionary[letter] - timeslot1[timeslot_index]
      print(timeslot1[timeslot_index])
      print(alphabet_dictionary[letter])
      encrypted_letter = alphabet[offset]
      new_word.append(encrypted_letter)
    elif user_timeslot == "2":
      offset = alphabet_dictionary[letter] - timeslot2[timeslot_index]
      encrypted_letter = alphabet[offset]
      new_word.append(encrypted_letter)
    else:
      offset = alphabet_dictionary[letter] - timeslot3[timeslot_index]
      while offset < 0:
        offset = offset + 26
      encrypted_letter = alphabet[offset]
      new_word.append(encrypted_letter)

elif user_option == "E":
  print("What timeslot would you like to pick?\n")
  print("Timeslot: ")
  user_timeslot = input()
  print("What word would you like to encrypt dude?\n")
  print("Word: ")
  user_word = input()
  
  for letter in user_word:
    timeslot_index = timeslot_index + 1
    print("\n",letter, timeslot_index)
    if user_timeslot == "1":
      offset = timeslot1[timeslot_index] + alphabet_dictionary[letter]
      print(timeslot1[timeslot_index])
      print(alphabet_dictionary[letter])
      while offset > 26:
        offset = offset - 26
      encrypted_letter = alphabet[offset]
      new_word.append(encrypted_letter)
    elif user_timeslot == "2":
      offset = timeslot2[timeslot_index] + alphabet_dictionary[letter]
      while offset > 26:
        offset = offset - 26
      encrypted_letter = alphabet[offset]
      new_word.append(encrypted_letter)
    else:
      offset = timeslot3[timeslot_index] + alphabet_dictionary[letter]
      while offset > 26:
        offset = offset - 26
      encrypted_letter = alphabet[offset]
      new_word.append(encrypted_letter)

complete_new_word = "".join(new_word)
print("\nYour new word is " + complete_new_word)
