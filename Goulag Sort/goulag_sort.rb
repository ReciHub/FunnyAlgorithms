def goulag_sort(array)
  array.delete_if.each_with_index { |e, i| e < array[i - 1] if i > 0 }
end
