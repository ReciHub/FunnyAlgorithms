puts "Enter the radius of the cylinder: "
r = gets.chomp.to_f
puts "Enter the height of the cylinder: "
h = gets.chomp.to_f

puts "The volume of the cylinder is: " + (Math::PI * h * r ** 2).round(4).to_s

