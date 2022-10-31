puts "Enter the first number: "
numbers = []
number1 = gets.to_i
numbers << number1

puts "\nEnter the second number: "
number2 = gets.to_i
numbers << number2

number1 = numbers[1]
number2 = numbers[0]

puts "\n\n\nSwaping numbers..."
sleep(1)
puts "\n\n\nFirst number = #{number1}!"
sleep(1)
puts "\nSecond number = #{number2}!"