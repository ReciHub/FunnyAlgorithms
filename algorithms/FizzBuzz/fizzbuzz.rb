1.upto(100) do |i|
    out = ""
    if i % 5 == 0
        out += "Buzz"
    end
    if i % 3 == 0
        out += "Fizz"
    end
    puts(out.empty? ? i : out)
end
