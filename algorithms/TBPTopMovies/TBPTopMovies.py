import requests
import urllib.request
import time
from bs4 import BeautifulSoup

url = 'https://thepiratebay10.org/top/201'

response = requests.get(url)
soup = BeautifulSoup(response.text, "html.parser")

links = soup.select('a.detLink')

for link in links:
  print(link.getText())
  print(link['href'])
  print()