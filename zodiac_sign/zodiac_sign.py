# Python Program to Find Zodiac Sign using DOB

mmdd = int(input("Please eneter your date of birth in MMDD format : "))

if  (120 <= mmdd and mmdd <= 218):
    Zodiac_sign = "Aquarius"
elif(219 <= mmdd and mmdd <= 320):
    Zodiac_sign = "Pisces"
elif(321 <= mmdd and mmdd <= 419):
    Zodiac_sign = "Aries"
elif(420 <= mmdd and mmdd <= 520):
    Zodiac_sign = "Taurus"
elif(521 <= mmdd and mmdd <= 621):
    Zodiac_sign = "Gemini"
elif(622 <= mmdd and mmdd <= 722):
    Zodiac_sign = "Cancer"
elif(723 <= mmdd and mmdd <= 822):
    Zodiac_sign = "Leo"
elif(823 <= mmdd and mmdd <= 922):
    Zodiac_sign = "Virgo"
elif(923 <= mmdd and mmdd <= 1023):
    Zodiac_sign = "Libra"
elif(1024 <= mmdd and mmdd <= 1121):
    Zodiac_sign = "Scorpio"
elif(1122 <= mmdd and mmdd <= 1221):
    Zodiac_sign = "Sagittarius"
elif((1222 <= mmdd and mmdd <= 1230) or ((101 <= mmdd and mmdd <= 119))):
    Zodiac_sign = "Capricorn"
else:
    print("Invalid format of Date of Birth!!")
    Zodiac_sign = "Not available for this input"
print("Your Zodiac Sign is: ",Zodiac_sign)
