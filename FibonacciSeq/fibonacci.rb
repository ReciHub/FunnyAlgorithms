def fib(n)
    if n <= 2
        return 1
    else
        return fib(n-1) + fib(n-2)
    end
end

puts "Enter limit : "
limit = gets.to_i

result = fib(limit)

puts "Fib(#{limit}) = #{result}"