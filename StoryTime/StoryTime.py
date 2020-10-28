#Made by Zwolfy on Github

import time
import random
karma = 0

#Story begins...
print('Hey there! Lets tell a story together.')

person_1 = input('Give me your name: ')
person_2 = input('Give me your friend\'s name: ')
place_1 = input('Are you going to heaven or hell? ')

print('It all started when ' + person_1 + ' woke up and realized they were in ' + place_1 +
      '. After stumbling around, ' + person_1 + ' found their best friend ' + person_2 +
      ' lying out in the open with an object in their hands.')

object_1 = input('What was your friend holding? ')
adj_1 =  input('Give me an adjective: ')

print('...upon closer inspection, your friend seems to be holding a ' + adj_1 + ' '+ object_1 + '. How strange...')


# Function to check for correct response
def answer_checker(response, question):
    while response[0] != 'Y' and response[0] != 'N':
        print('Didn\'t quite catch that. try again...\n\n')
        response = input(question).upper().strip()
    return response

print('Let\'s wake your friend up.\n')
time.sleep(2)

#Are you a good friend?
resp_1 = input('Poke your friend? (Y/N) ').upper().strip()
resp_1 = answer_checker(resp_1, 'Poke your friend? (Y/N) ')

time.sleep(2)

if resp_1 == 'Y':
    print('You poke your friend in hopes of reviving them. Nothing. You grab their foot and start dragging.')
    karma += 1
elif resp_1 == 'N':
    print('You continue walking on without trying to wake your friend. ' + person_2 + ' was a jerk anyway...')
    karma -= 1

print('\nContinuing on...\n')
time.sleep(3)

place_2 = input('What\'s your favorite place to hangout? ')
verb_1 = input('Finally, give me your favorite verb + ing: ')
    
print('You sigh and reminisce about your home. You\'d rather be ' + verb_1 + ' at the local ' + place_2 +
      '. ' + person_1 + ' never thought they would miss their high-paying, low stress, full benefits, no overtime developer job (hah...). ' + 
      'Just as you start wondering when this nightmare will end, a door appears in front of you...\n')

#You you like doors?
resp_2 = input('Go through the door? (Y/N) ').upper().strip()
resp_2 = answer_checker(resp_2, 'Go through the door? (Y/N) ')

if resp_2 == 'Y':
    print('It\'s locked...Who locks a door in ' + place_1 + '?!')    
elif resp_2 == 'N':
    print('You don\'t quite trust mysterious doors in unknown lands...')
    karma += 1

time.sleep(3)
print('\nNow what?\n\n....')
time.sleep(2)
print('...')
time.sleep(2)
print('..')
time.sleep(2)
print('.')
time.sleep(2)
print('Perhaps I\'ll help (I\'m awesome like that)')
time.sleep(3)

#Lucky arc
resp_3 = input('Let\'s test your luck...(Y/N) ').upper().strip()
resp_3 = answer_checker(resp_3, 'Let\'s test your luck...(Y/N) ')

if resp_3 == 'Y':
    print('\nThe universe will now give you a number...')
    karma += 1
elif resp_3 == 'N':
    print('\nYou must not be fun at parties...You are still getting tested. The universe will now give you a number...')
    karma -= 1

time.sleep(3)
print('\nHope it\'s above a 50...\n\n')

time.sleep(5)
print('*******\nDRUMROLL\n*******\n\n')
time.sleep(5)
uni_num = random.randint(0,100)
print('You got: ', uni_num, '\n')

time.sleep(3)

if uni_num >= 50:
    print('It\'s yout lucky day punk. The universe will now enchant your friend\'s ' + object_1 + '. You may use it to unlock the door.......\nYou DO have your friend right?\n')
    resp_4 = input('(Y/N): ')
    resp_4 = answer_checker(resp_4, '(Y/N): ')
    if resp_4 == 'Y':
        print('Well then, you are all set to go adventure through that mysterious door')
        karma += 1
    elif resp_4 == 'N':
        print('You know you have to go back right? Get a move on')
        karma -= 1
elif uni_num < 50:
    print('Well, we tried... Maybe don\'t party so hard that you end up in the afterlife with your best bud knocked unconcious.')


print('\nTo be continued...\n')
print('\nYour current karma is ', karma)


#This was just a quick silly story for humor. If you can make it better, feel free to add, delete or improve any part of the story or code.













