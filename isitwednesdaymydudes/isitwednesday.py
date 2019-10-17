import datetime as day

myDay = day.datetime.today().weekday()



if (myDay == "2"):

    print("It is Wednesday, my dudes\n")

else: 
    if (myDay < 2):
        Daysleft = 2 - myDay
    else:
        Daysleft = 9 - myDay
    print("It is",Daysleft,"days until Wednesday, my dudes\n")
