import requests
from bs4 import BeautifulSoup as bs

links = []
with open("links", "r") as file:
    for line in file:
        links.append(line[:-1])

for link in links:
    print(link)

exit()

page = requests.get("https://sauveteurdudunkerquois.fr/tableau-d-honneur/").content

soup = bs(page, "html.parser")

for res in soup.select("a"):
    print(res.get_text())
