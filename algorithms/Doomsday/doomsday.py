#!/bin/python3

"""
Originally contributed by XVR147 in Haskell functional programming language. 

"The Doomsday algorithm is a simple algorithm used to determine the day of the week for a given date,
Besides being really simple to use mentally, making it a cool party trick, it's really interesting.
For more info https://en.wikipedia.org/wiki/Doomsday_rule"
"""

doomsday_leap = [4,1,7,4,2,6,4,1,5,3,7,5]
doomsday_not_leap = [3,7,7,4,2,6,4,1,5,3,7,5]

_week_day_names = {  
               0 : "Sunday",
               1 : "Monday",
               2 : "Tuesday",
               3 : "Wednesday",
               4 : "Thursday",
               5 : "Friday",
               6 : "Saturday"
} 
    

def get_week_day(year: int, month: int, day: int) -> str:
    # minimal input check:
    assert len(str(year)) > 2, 'Please supply year in YYYY format'
    assert 1 <= month <= 12, 'Invalid month value, please give a number between 1 to 12'
    assert 1 <= day <= 31, 'Invalid day value, please give a number between 1 to 31' 

    # conway's doomsday algorithm
    century = year // 100
    century_anchor = (5 * (century % 4) + 2) % 7
    centurian = year % 100
    centurian_m = centurian % 12
    dooms_day = ((centurian // 12) + centurian_m + (centurian_m // 4) + century_anchor) % 7
    day_anchor = doomsday_not_leap[month - 1] if (year % 4 != 0) or (centurian == 0 and (year % 400) == 0) else doomsday_leap[month - 1]
    week_day = (dooms_day + day - day_anchor) % 7
    return _week_day_names[week_day]


if __name__ == '__main__':  
    # unit-test
    assert get_week_day(2020, 10, 24) == 'Saturday'
