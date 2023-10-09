'''
This is a love calculator algorithm based on Name of two person. This is only and only for fun purpsose.

'''


# Enter the name
a = input("Enter your First name: ")
b = input("Enter your partner's First name: ")

if not a.isalpha() or not b.isalpha():
    print("\n\nINVALID INPUT")

a = a.lower()
b = b.lower()

love = {}

for i in a:
    love[i] = love.get(i,0)+1

for i in b:
    love[i] = love.get(i,0)+1

percent = 0

for s,i in love.items():
    if i>1:
        percent += (ord(s)-ord('a'))*i

if percent>=100:
    print(f"\n\n Wow, You two are Soulmates. With perfect 100 % love.")
elif 80<= percent < 100:
    print(f"\n\n That's some serious love right there with {percent} %.")

elif 60<= percent <80:
    print(f"\n\n You have good compatability, with love score of {percent} %.")

else:
    print(f"\n\n You will face challenges but Hey, your story will be an amazing one my friend. Your love score is {percent} %.")
