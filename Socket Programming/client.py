import time, socket, sys


print('Running Client Server')
for i in range(3):
    time.sleep(0.7)
    print('.')


#Get the hostname, IP Address from socket and set Port
client_socket = socket.socket()
shost = socket.gethostname()
ip = socket.gethostbyname(shost)


#get information to connect with the server
print(shost, '({})'.format(ip))
server_host = input('Enter server\'s IP address: ')
name = input('Enter Client\'s name: ')
port = 1234
print('\nTrying to connect to the server {}:{}'.format(server_host, port))
time.sleep(1)


#Get a connection from server side
client_socket.connect((server_host, port))
print('Connected.\n')
client_socket.send(name.encode())
server_name = client_socket.recv(1024)
server_name = server_name.decode()
print('{} has joined...'.format(server_name))
print('Enter "bye" to exit.\n')


while True:
    message = client_socket.recv(1024)
    message = message.decode()
    print(server_name, '>>', message)
    message = input(str('you >> '))
    if message == 'bye':
        message = 'Leaving... Have a nice day!'
        client_socket.send(message.encode())
        print('\n')
        break
    client_socket.send(message.encode())
