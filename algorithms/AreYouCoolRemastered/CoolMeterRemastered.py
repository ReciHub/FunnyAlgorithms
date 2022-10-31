#Code by:Caio Cordeiro
#Github: github.com/CaioCordeiro
import pandas as pd
from sklearn.svm import SVC

LETTER_MAP = {
    "a": 0,
    "b": 1,
    "c": 2,
    "d": 3,
    "e": 4,
    "f": 5,
    "g": 6,
    "h": 7,
    "i": 8,
    "j": 9,
    "k": 10,
    "l": 11,
    "m": 12,
    "n": 13,
    "o": 14,
    "p": 15,
    "q": 16,
    "r": 17,
    "s": 18,
    "t": 19,
    "u": 20,
    "v": 21,
    "w": 22,
    "x": 23,
    "y": 24,
    "z": 26,
}

def label_coolness(row):
    if row["rank"] > 8650:
        return 2
    if row["rank"] > 500 :
        return 1
    return 0 

print('''
        ===========================
        How cool you think you are?
        ===========================

    ''')

print("What's your first name?")
usr_letter = input()[0].lower()
print("Year you were born?")
usr_year = int(input())
print("Gender (Number) \n  1 - Male\n  2 - Female\n  3 - Other")
usr_gen = int(input())
print("From 0% to 100%,  how precise you want us to be (bigger numbers will decrease performance):")
data_size = int(2052781 * (int(input())/100))
print(data_size)
print("We are consulting the Coolness gurus, this may take a while")
# FETCHING DATA
df = pd.read_csv('./data.csv').sample(frac=1).reset_index(drop=True).iloc[0: data_size]

# TREATING DATA
df['coolness'] = df.apply (lambda row: label_coolness(row), axis=1)
df['sex'] = df.apply (lambda row: 0 if row["sex"] == "F" else 1, axis=1)
df['name'] = df.apply (lambda row: LETTER_MAP[row["name"][0].lower()], axis=1)
df = df.drop("rank", axis=1)
df = df.drop("count", axis=1)

# SEPARATING LABEL
y = df['coolness']
X = df.drop("coolness", axis=1)

# BUIDING MODEL
clf0 = SVC()
clf0.fit(X, y)


person = {
    "name": [LETTER_MAP[usr_letter]],
    "sex": [usr_gen],
    "year": [usr_year]
}
test_df = pd.DataFrame(person)
res = clf0.predict(test_df)

if res == 2:
    print("Meh, you are not so cool.")
if res == 1:
    print("Congrats! You are in fact cool")
if res == 0:
    print('''
             ============================================
             OMG YOU ARE AWESOME CONGRATULATIONS!!!!!!!!
             ===========================================''')
