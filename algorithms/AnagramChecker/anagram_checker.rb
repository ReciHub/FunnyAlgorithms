def to_counts(str)
  letter_counts = Hash.new(0)

  str.chars.each { |char| letter_counts[char] += 1 }

  letter_counts
end

def is_anagram?(str1, str2)
  to_counts(str1) == to_counts(str2)
end

if __FILE__ == $PROGRAM_NAME
  puts 'Enter a word:'
  print '>> '
  s1 = gets.strip
  puts 'Enter another word:'
  print '>> '
  s2 = gets.strip

  puts is_anagram?(s1, s2) ? "#{s1} and #{s2} are anagrams!" : "#{s1} and #{s2} are not anagrams!"
end