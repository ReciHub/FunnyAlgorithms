def findLongest(string)
    longest = string.split(" ")
    longest.sort_by!(&:length)
    longest.reverse!
    longest[0]
end

puts "Enter string: "
puts "Longest word is: " + findLongest(gets.chomp)

