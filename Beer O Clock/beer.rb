def beer
  puts "> Should I check if it is time to have Beer ? (Y / N) "
  print "> "
  response = gets.strip

  case response.downcase
  when "y"
    puts "> It always is beer of clock. Cheers !!!"
  when "n"
    puts "> We check later"
  else
    puts "> Invalid input, try again."
    beer
  end
end