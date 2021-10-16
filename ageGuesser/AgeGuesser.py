import datetime
print("Hello welcome! I'm the Birthday Guesser! ")
print("Now I'm going to ask you a few questions to know your birthday!")
yearBirth = int(input("What year were you born? "))
age = int(datetime.datetime.now().date().strftime("%Y")) - yearBirth;
print("Your age is 1,110 years old! Just kidding, your real age is " + str(age) + ".")
