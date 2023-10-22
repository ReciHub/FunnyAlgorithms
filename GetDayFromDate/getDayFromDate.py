# This program determines the day for any given date on the calendar



# collect day, month and year from the user
day = int(input("Enter the day: "))
month = int(input("Enter the month: "))
year = int(input("Enter the year: "))

def get_day(day, month, year):
    '''determine the day of a given date'''
    # create an array containing all the days of the week
    days_of_the_week = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]

    # create a dictionary containing all the months of the year and their respective number of days
    months_of_the_year = {
        "January": 31,
        "February": 28,
        "March": 31,
        "April": 30,
        "May": 31,
        "June": 30,
        "July": 31,
        "August": 31,
        "September": 30,
        "October": 31,
        "November": 30,
        "December": 31
    }
    
    # using January 1st, 2023 (Sunday) as a point of reference
    ref_day = 1
    ref_month = 1
    ref_year = 2023

    days_count = 0  # initiate a variable to count the days
    direction = 0  # initiate a variable to indicate the direction (to the past or to the future)
    ans = (f"{days_of_the_week[days_count % 7]}, {ref_day} {list(months_of_the_year.keys())[ref_month-1]} {ref_year}") # initialize the answer to "1 January 2023 is a Sunday"
    
    # determine if the given date is in the past(-1), present(0) or future(1)
    if year > ref_year:
        position = 1
    elif year < ref_year:
        position = -1
    elif month > ref_month:
        position = 1
    elif day > ref_day:
        position = 1
    else:
        position = 0


    # if we're going to the past
    if (position < 0):
        direction = -1
        while ((ref_day != day) or (ref_month != month) or (ref_year != year)): 
            # while we've not reached the inputed date
            if ref_day == 1:
                # if we're at the beginning of a month
                if ref_month == 1:
                    # if we're in January 1st
                    ref_year -= 1 # goto previous year
                    if ((ref_year % 4) == 0):
                        # if the new year is divisible by 4, the it MAY be a leap year
                        if ((ref_year % 100) != 0):
                            # if the new year is divisible by 4 but not a centurial year, then it is a leap year
                            months_of_the_year["February"] = 29
                        else:
                            # if the new year is a centurial year
                            if ((ref_year % 400) == 0):
                                # if the new year is a centurial year and divisible by 400, then it is a leap year
                                months_of_the_year["February"] = 29
                            else:
                                 # if the new year is a centurial year and not divisible by 400, then it is not a leap year
                                months_of_the_year["February"] = 28
                    else:
                        # if the new year is not divisible by 4, then it is not a leap year
                        months_of_the_year["February"] = 28

                    ref_month = 12 # change month to December
                else:
                    # if we're in 1st of any other month apart from January, just go to the previous month
                    ref_month -= 1
                ref_day = list(months_of_the_year.values())[ref_month-1]

            else:
                ref_day -= 1 # go to the previous day
            
            days_count += direction # increase the total number of days
            ans = (f"{days_of_the_week[days_count % 7]}, {ref_day} {list(months_of_the_year.keys())[ref_month-1]} {ref_year}")
            
            if abs(days_count) == 500000:
                print("Calculating...")

    # if we're going to the future
    elif (position > 0): 
        direction = 1
        month_str = "January"
        while ((ref_day != day) or (ref_month != month) or (ref_year != year)):
            if ref_day == months_of_the_year[month_str]:
                 # if we're at the end of the month
                if ref_month == 12:
                    # if we're in December 31st
                    ref_year += 1 # goto next year

                    if ((ref_year % 4) == 0):
                        # if the new year is divisible by 4, the it MAY be a leap year
                        if ((ref_year % 100) != 0):
                            # if the new year is divisible by 4 but not a centurial year, then it is a leap year
                            months_of_the_year["February"] = 29
                        else:
                            # if the new year is a centurial year
                            if ((ref_year % 400) == 0):
                                # if the new year is a centurial year and divisible by 400, then it is a leap year
                                months_of_the_year["February"] = 29
                            else:
                                 # if the new year is a centurial year and not divisible by 400, then it is not a leap year
                                months_of_the_year["February"] = 28
                    else:
                        # if the new year is not divisible by 4, then it is not a leap year
                        months_of_the_year["February"] = 28

                    ref_month = 1
                    month_str = list(months_of_the_year.keys())[ref_month-1]
                else:
                    ref_month += 1
                    month_str = list(months_of_the_year.keys())[ref_month-1]
                ref_day = 1

            else:
                ref_day += 1 # go to the next day
                
            days_count += direction # increase the total number of days
            ans = (f"{days_of_the_week[days_count % 7]}, {ref_day} {list(months_of_the_year.keys())[ref_month-1]} {ref_year}")

            if abs(days_count) == 500000:
                print("Calculating...")

    return ans

print(get_day(day, month, year))


# Enter the day: 3
# Enter the month: 12
# Enter the year: 2005
# Saturday, 3 December 2005