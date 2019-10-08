
Module Program
    Sub Main()
        Dim start_number, next_number As Integer
        Console.WriteLine("What number do you want to start with? ")
        start_number = Console.ReadLine()
        For i = 1 To 5
            Console.WriteLine((start_number + next_number))
            start_number = next_number
            next_number = next_number + 1
        Next

        Console.ReadKey()
    End Sub
End Module
