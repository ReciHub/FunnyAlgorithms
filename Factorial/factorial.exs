defmodule Factorial do

def factorial(0), do: 0
def factorial(1), do: 1

def factorial(n) do
   n * factorial(n-1)
end

end
