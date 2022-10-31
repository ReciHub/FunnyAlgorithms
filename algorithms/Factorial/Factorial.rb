#Factorial function, Ruby version
def Factorial(num)
    if num == 1
        return 1
    else
        return num * Factorial(num - 1)
    end
end

puts Factorial(1)
puts Factorial(5)