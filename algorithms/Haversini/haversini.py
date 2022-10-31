from math import pi, sin, cos, asin, sqrt

def harvesini_distance(lat_origin, lon_origin, lat_final, lon_final, earth_radius: int = 6371000)-> float:
    distance_lat = (lat_final - lat_origin) * pi / 180.0
    distance_lon = (lon_final - lon_origin) * pi / 180.0

    lat_origin = lat_origin * pi / 180.0
    lat_final = lat_final * pi / 180.0

    result = sin(distance_lat / 2)**2 + sin(distance_lon / 2)**2* cos(lat_origin) * cos(lat_final)
    angle = 2 * asin(sqrt(result))
    return earth_radius * angle

def run() -> None:
    """Run function, asks the user for the longitude and latitude of the origin and the destination
    to calculate the distance considering the earth radius as 6371000 meters, using haversini's formula.
    """
    print("Please digit the latitude and longitude from your origin")
    lat_origin, lon_origin = input().split()
    lat_origin = float(lat_origin)
    lon_origin = float(lon_origin)
    print("Please digit the latitude and longitude from your destination")
    lat_final, lon_final = input().split()
    lat_final = float(lat_final)
    lon_final = float(lon_final)
    final_distance = harvesini_distance(lat_origin, lon_origin, lat_final, lon_final)
    print(f"The distance is {final_distance}m.")

if __name__ == "__main__":
    run()