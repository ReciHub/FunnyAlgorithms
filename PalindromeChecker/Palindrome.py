def checkPalindrome(s):
	if(s==s[::-1]):
		return True
	return False
s=input()
if(checkPalindrome(s)):
	print("This is a palindrome!!!")
else:
	print("This is not a palindrome...")