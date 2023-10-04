"""
An NOR Gate is a logic gate in boolean algebra which results to 0 (False) if any of the
inputs is 1, and 0 (False) otherwise.

Following is the truth table of an NOR Gate:
    ------------------------------
    | Input 1 | Input 2 | Output |
    ------------------------------
    |    0    |    0    |    1   |
    |    0    |    1    |    0   |
    |    1    |    0    |    0   |
    |    1    |    1    |    0   |
    ------------------------------

Refer - https://www.geeksforgeeks.org/logic-gates-in-python/
"""


def nor_gate(input_1: int, input_2: int) -> int:
    """
    Calculate logical OR of the input values

    >>> nor_gate(0, 0)
    1
    >>> nor_gate(0, 1)
    0
    >>> nor_gate(1, 0)
    0
    >>> nor_gate(1, 1)
    0
    """
    return int((input_1, input_2).count(1) == 0)


def test_nor_gate() -> None:
    """
    Tests the nor_gate function
    """
    assert nor_gate(0, 0) == 1
    assert nor_gate(0, 1) == 0
    assert nor_gate(1, 0) == 0
    assert nor_gate(1, 1) == 0


if __name__ == "__main__":
    print(nor_gate(0, 0))
    print(nor_gate(0, 1))
    print(nor_gate(1, 0))
    print(nor_gate(1, 1))
