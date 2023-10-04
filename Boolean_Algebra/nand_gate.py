"""
The NAND gate (negated AND) gives an output of 0 if both inputs are 1, it gives 1 otherwise. 
Following is the truth table of an nAND Gate:
    ------------------------------
    | Input 1 | Input 2 | Output |
    ------------------------------
    |    0    |    0    |    1   |
    |    0    |    1    |    1   |
    |    1    |    0    |    1   |
    |    1    |    1    |    0   |
    ------------------------------
Refer - https://www.geeksforgeeks.org/logic-gates-in-python/
"""


def nand_gate(input_1: int, input_2: int) -> int:
    """
    Calculate logical nAND of the input values
    >>> nand_gate(0, 0)
    1
    >>> nand_gate(0, 1)
    1
    >>> nand_gate(1, 0)
    1
    >>> nand_gate(1, 1)
    0
    """
    return int((input_1, input_2).count(0) != 0)


def test_nand_gate() -> None:
    """
    Tests the nand_gate function
    """
    assert nand_gate(0, 0) == 0
    assert nand_gate(0, 1) == 0
    assert nand_gate(1, 0) == 0
    assert nand_gate(1, 1) == 1


if __name__ == "__main__":
    print(nand_gate(0, 0))
    print(nand_gate(0, 1))
    print(nand_gate(1, 0))
    print(nand_gate(1, 1))
