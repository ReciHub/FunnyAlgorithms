"""
The XOR gate gives an output of 1 if either of the inputs is different, it gives 0 if they are the same. 
Following is the truth table of an XOR Gate:
    ------------------------------
    | Input 1 | Input 2 | Output |
    ------------------------------
    |    0    |    0    |    0   |
    |    0    |    1    |    1   |
    |    1    |    0    |    1   |
    |    1    |    1    |    0   |
    ------------------------------
Refer - https://www.geeksforgeeks.org/logic-gates-in-python/
"""


def xor_gate(input_1: int, input_2: int) -> int:
    """
    Calculate logical AND of the input values
    >>> xor_gate(0, 0)
    0
    >>> xor_gate(0, 1)
    1
    >>> xor_gate(1, 0)
    1
    >>> xor_gate(1, 1)
    0
    """
    return int(input_1 != input_2)


def test_xor_gate() -> None:
    """
    Tests the xor_gate function
    """
    assert xor_gate(0, 0) == 0
    assert xor_gate(0, 1) == 1
    assert xor_gate(1, 0) == 1
    assert xor_gate(1, 1) == 0


if __name__ == "__main__":
    print(xor_gate(0, 0))
    print(xor_gate(0, 1))
    print(xor_gate(1, 0))
    print(xor_gate(1, 1))
