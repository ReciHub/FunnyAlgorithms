// This method was used for problem like ->
//   uniqueInOrder('MMMMBBBCCDAABBB') == ['M', 'B', 'C', 'D', 'A', 'B']
//   uniqueInOrder('ABBCcAD')         == ['A', 'B', 'C', 'c', 'A', 'D']
//   uniqueInOrder([1,2,2,3,3])       == [1,2,3]

var uniqueInOrder = function (iterable)
{
  return [].filter.call(iterable, (function (a, i) { return iterable[i - 1] !== a }));
}

console.log(uniqueInOrder('CCCEEEEEEBBBBBBBBBBBB'));
