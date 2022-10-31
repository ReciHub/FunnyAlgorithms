Private Sub Command1_Click()
Dim x, g, n, i, sum As Integer
n = Val(Text1.Text)
x = 0
y = 1
Print x
Print y
For i = 3 To n
sum = x + y
Print sum
x = y
y = sum
y = sum
Next i
End Sub
