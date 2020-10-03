def PalindromeCheck2(s):
	if(s==s[::-1]):
		return True
	return False
s=input()
if(PalindromeCheck(s)):
	print("It is a palindrome!")
else:
	print("It is not a palindrome..")
