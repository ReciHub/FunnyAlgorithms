def sum_of_numbers(number)
  sum = 0
  for number in 0..number do
    sum = number + sum
    number += 1
  end
  return sum
end

puts "Enter a number: "
number = gets.to_i
result = sum_of_numbers(number)

puts "\nThe sum of numbers is: #{result}"