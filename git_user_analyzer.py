import requests

baseUrl = 'https://api.github.com'

print(f'{"-"*40}')
print(f'{" "*12}GitUser Analyzer')
print(f'{"-"*40}')

option = int(input(
'''Select an option:
1 - Search username
2 - Show user info
'''))

if option == 1:
    query = input('Write the user to search: ')
    
    results = requests.get(f'{baseUrl}/search/users?q={query}').json()['items']
    
    for user in results:
        print(f'{"-"*40}')
        print(user['login'])
elif option == 2:
    username = input('Write username: ')
    
    user = requests.get(f'{baseUrl}/users/{username}').json()
    
    print(f'{"-"*40}')
    print(f'''login: {user['login']}
name: {user['name']}
picture: {user['avatar_url']}
profile: {user['html_url']}
company: {user['company']}
location: {user['location']}
followers: {user['followers']}
following: {user['following']}
''')
    print(f'{"-"*40}')
else:
    print('Please select one of the options above')
