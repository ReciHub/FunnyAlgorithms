'this is the fizzbuzz programe in visual basic
   
   Function fb(num)
        If num Mod 15 = 0 Then
            Console.WriteLine("fizzbuzz")
        ElseIf num Mod 3 = 0 Then
            Console.WriteLine("fizz")
        ElseIf num Mod 5 = 0 Then
            Console.WriteLine("buzz")
        Else
            Console.WriteLine(num)
        End If
    End Function
    Sub Main()
        Dim num As Integer
        num = Console.ReadLine()
        fb(num)
        Console.ReadKey()
    End Sub
