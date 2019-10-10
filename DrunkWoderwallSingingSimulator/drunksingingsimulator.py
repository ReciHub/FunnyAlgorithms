import math
print(''' 
    ==================================
    DRUNK WONDERWALL SINGING SIMULATOR
    ==================================
''')
print("Sing Wonderwall with me pal")
print('\n\n')
print('''Today is gonna be the day
That they're gonna throw it back to you''')

lyrics = '''By now you should've somehow
Realized what you gotta do
I don't believe that anybody
Feels the way I do, about you now
Backbeat, the word was on the street
That the fire in your heart is out
I'm sure you've heard it all before
But you never really had a doubt
I don't believe that anybody
Feels the way I do about you now
And all the roads we have to walk are winding
And all the lights that lead us there are blinding
There are many things that I
Would like to say to you but I don't know how
Because maybe, you're gonna be the one that saves me
And after all, you're my wonderwall'''.replace('\n',' ').lower().split(' ')
# print(lyrics)
a=''
print_list =[]
while(a!='wonderwall'):
    x = (input()).replace('\n',' ').lower()
    word = x.split(' ')
    try:
        index = lyrics.index(word[len(word)-1])
    except:
        print("\nYou are drunk, go home!\n")
    a = lyrics[index]   
    for i in range(index,len(lyrics)-1):
        if(i%5==0):
            print_list.append('\n==>')
        print_list.append(lyrics[i])
    print('==> ',end='')
    print(' '.join(print_list))
    lyrics = lyrics[math.ceil(len(lyrics)/2):]
    print_list.clear()
print("\nYou are drunk, go home!\n")