def binary_search(list, item)
    low = 0
    high = list.length - 1
  
    while low <= high
      mid = (low + high) / 2
      guess = list[mid]
  
      if guess == item
        return mid
      elsif guess > item
        high = mid - 1
      else
        low = mid + 1
      end
    end
  
    return nil
  end
  
  my_list = [1, 3, 5, 7, 9]
  puts binary_search(my_list, 3) # => 1

  puts binary_search(my_list, -1).inspect # => nil