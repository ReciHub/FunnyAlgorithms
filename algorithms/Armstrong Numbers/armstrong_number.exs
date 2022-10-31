defmodule ArmstrongNumber do
  @moduledoc """
  Provides a way to validate whether or not a number is an Armstrong number
  """

  @spec is_valid?(integer) :: boolean
  def is_valid?(number) do
    armstrong = number 
    |> to_string
    |> String.codepoints
    |> decompose

    number == armstrong
  end

  defp decompose(list, acc \\ 0) do
    decompose(list, acc, length(list))
  end

  defp decompose([number | tail], acc, length) do
    decompose(tail, acc + :math.pow(String.to_integer(number), length), length)
  end

  defp decompose([], acc, _) do
    acc
  end

end
