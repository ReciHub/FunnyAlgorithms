"""
The algorithm below calculates the closest planet to Earth 
on a given birthdate and estimates the time to walk there. 
It uses the ephem library for astronomical calculations.

The complexity of the code is primarily in the loop that 
iterates through the planets and computes their positions,
making it O(n) where n is the number of planets (7 in this case).

How to Run?
1) python install -r requirements.txt
2) python app.py

"""


import ephem
import datetime

def find_closest_planet_and_time_to_walk(birthdate):
    # Initialize an observer for Earth
    observer = ephem.Observer()
    observer.lat = '0'  # Latitude of the observer (equator)
    observer.long = '0'  # Longitude of the observer (Greenwich)

    # Create an Ephemeris object for the birthdate
    birthdate_ephem = ephem.Date(birthdate)

    # Initialize variables for the closest planet and its distance (in kilometers)
    closest_planet = None
    min_distance = float('inf')

    # Define the planets in the solar system
    planets = ['Mercury', 'Venus', 'Mars', 'Jupiter', 'Saturn', 'Uranus', 'Neptune']

    # Calculate the closest planet and its distance on the given date
    for planet_name in planets:
        planet = getattr(ephem, planet_name)()
        
        # Calculate the planet's position relative to Earth
        planet.compute(birthdate_ephem)
        
        # Calculate the distance from Earth to the planet
        distance_km = ephem.separation(planet, observer) * 149597870.7  # Convert to kilometers (average Earth-Sun distance)

        if distance_km < min_distance:
            min_distance = distance_km
            closest_planet = planet_name

    # Calculate the time it would take to walk to the closest planet at a typical walking speed
    walking_speed_kph = 5  # Average walking speed in kilometers per hour
    walking_speed_kmps = walking_speed_kph / 3600  # Convert to kilometers per second

    # Calculate the time (in seconds) and distance (in kilometers)
    time_seconds = min_distance / walking_speed_kmps

    # Convert the time to years, months, weeks, days, hours, minutes, and seconds
    time_years = time_seconds / (365.25 * 24 * 3600)
    time_months = time_years * 12
    time_weeks = time_seconds / (7 * 24 * 3600)
    time_days = time_seconds / (24 * 3600)
    time_hours = time_seconds / 3600
    time_minutes = time_seconds / 60

    return closest_planet, min_distance, time_years, time_months, time_weeks, time_days, time_hours, time_minutes, time_seconds

if __name__ == "__main__":
    # Prompt the user to enter their birthdate
    while True:
        try:
            birthdate_str = input("Enter your birthdate (DD-MM-YYYY): ")
            birthdate = datetime.datetime.strptime(birthdate_str, '%d-%m-%Y').date()
            break
        except ValueError:
            print("Invalid date format. Please enter your birthdate in the format DD-MM-YYYY.")

    closest_planet, min_distance, time_years, time_months, time_weeks, time_days, time_hours, time_minutes, time_seconds = find_closest_planet_and_time_to_walk(birthdate)

    print(f"Closest planet to Earth on your birthdate: {closest_planet}")
    print(f"Distance to {closest_planet}: {min_distance:.2f} kilometers")
    print("Time to walk there:")
    print(f"Years: {int(time_years)}")
    print(f"Months: {int(time_months)}")
    print(f"Weeks: {int(time_weeks)}")
    print(f"Days: {int(time_days)}")
    print(f"Hours: {int(time_hours)}")
    print(f"Minutes: {int(time_minutes)}")
    print(f"Seconds: {int(time_seconds)}")
