p=int(input("Enter p :"))
q=int(input("Enter q :"))
n=p*q
t=(p-1)*(q-1)
print(t)

#e=int(input("Enter public key which should not be factor of t :"))
# For Calculate public key which should not be factor of t
for i in range(1,50):
    e=t%i
    if(e!=0):
        e1=i
        print(e1)
        break
# Calculating private key using RSA Algorithm
for i in range(1,20) :
    summ=(t)*i
    result=summ+1
    result1=int(result)%e1
    if(result1==0.00):
        result2=int(result)/e1
        print("Private key is : ",int(result2))
        break
pt=int(input("Enter message : "))
ct=pt**e
print("Encryption : ")
print(ct)
print("Decryption : ")
pt=ct**d
print(pt)
