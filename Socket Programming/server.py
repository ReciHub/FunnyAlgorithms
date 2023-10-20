import time, socket, sys


print('Setting Up Server')
for i in range(3):
    time.sleep(0.7)
    print('.')


#Get the Hostname, IP Address from socket and set Port
server_socket = socket.socket()
host_name = socket.gethostname()
ip = socket.gethostbyname(host_name)
port = 1234
server_socket.bind((host_name, port))
print(host_name, '({})'.format(ip))
name = input('Enter name: ')


#Try to locate using socket
server_socket.listen(1) 
print('\nWaiting for connections...')
connection, addr = server_socket.accept()
print('Connection Established.\nConnected From {}:{}\n'.format(addr[0], addr[1]))


#Get a connection from client side
client_name = connection.recv(1024)
client_name = client_name.decode()
print(client_name, 'has connected.')
print('Press "bye" to leave the chat room\n')
connection.send(name.encode())


while True:
    message = input('you >> ')
    if message == 'bye':
        message = 'Nice to meet you!'
        connection.send(message.encode())
        print("\n")
        break
    connection.send(message.encode())
    message = connection.recv(1024)
    message = message.decode()
    print(client_name, '>>', message)
