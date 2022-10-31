puts "Enter a string to reverse: "
str_to_reverse = gets.delete("\n")

str_reversed = str_to_reverse .reverse()

puts "\n#{str_to_reverse} <=> #{str_reversed}"