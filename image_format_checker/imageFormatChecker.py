#python program to check image formats used in a webpage

import requests
from bs4 import BeautifulSoup
from urllib.parse import urlparse
import os

def get_image_extensions(url):
    extension_counts = {}

    # Send a request to the URL
    response = requests.get(url)
    soup = BeautifulSoup(response.content, 'html.parser')

    # Find all image tags
    img_tags = soup.find_all('img')

    for img_tag in img_tags:
        src = img_tag['src']
        parsed_url = urlparse(src)
        # Get the extension from the URL
        extension = os.path.splitext(parsed_url.path)[1]

        # Count the extension
        extension_counts[extension] = extension_counts.get(extension, 0) + 1

    return extension_counts

if __name__ == "__main__":
    url = input("Enter the URL of the website: ")
    image_extensions_counts = get_image_extensions(url)

    if image_extensions_counts:
        print("Image extensions and their counts:")
        for extension, count in image_extensions_counts.items():
            print(f"{extension}: {count}")
    else:
        print("No image extensions found.")
