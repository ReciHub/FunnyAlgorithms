def bubble_sort(arr)
    arr_len = arr.length
    (0...arr_len - 1).each do |i|
      (0...arr_len - i - 1).each do |j|
        if arr[j] > arr[j + 1]
          arr[j], arr[j + 1] = arr[j + 1], arr[j]
        end
      end
    end
  end
  
  # Example array
  arr = [99, 47, 86, 64, 25, 15, 120,2,67,92,73]
  
  # Call the bubble_sort function to sort the array
  bubble_sort(arr)
  
  # Print the sorted array
  puts "The sorted array is:"
  arr.each do |num|
    puts num
  end
  