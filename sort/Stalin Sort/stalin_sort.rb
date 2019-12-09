def stalin_sort(array)
  return [] if array.empty?

  array.delete_if.each_with_index { |e, i| e < array[i - 1] if i > 0 }
end
