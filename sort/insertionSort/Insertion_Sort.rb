def insertion_sort(array)
    final = []
    final << array.shift 
      for i in array
        final_index = 0
        while final_index < final.length 
          if i <= final[final_index] 
            final.insert(final_index,i) 
            break  
          elsif final_index == final.length-1 
            final.insert(final_index+1,i) 
            break
          end
          final_index+=1   
        end
      end
    final
  end
  array = [6, 5, 3, 1, 8, 7, 2, 4]
  p insertion_sort(array)