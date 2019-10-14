class Fibonacci
  def series
    puts "Enter the Fibonacci value"
    n=gets.to_i
    f1=0
    f2=1
    f3=0
        while f3<n do 
          f3=f1+f2
          puts f3
          f1=f2
          f2=f3  
       end
    end
end
obj1=Fibonacci.new
obj1.series
