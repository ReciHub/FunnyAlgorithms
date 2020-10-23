def odd(n: int) -> bool:
    return n % 2 == 1

def is_insoluble(loaves_in_hand: [int]):
    return odd(sum(loaves_in_hand))

def oe(n: int) -> str:
    return 'O' if odd(n) else 'E'

def covert(loaves_in_hand: [int]) -> [str]:
    return ''.join([oe(n) for n in loaves_in_hand])

def rsolve(oeloaves: [str]) -> int:
    if oeloaves.count('O') == 0:
        return 0
    if oeloaves[0] == 'E':
        return rsolve(oeloaves[1:])
    else:
        if oeloaves[1] == 'O':
            return 2 + rsolve(oeloaves[2:])
        if oeloaves[1] == 'E':
            return 2 + rsolve('O' + oeloaves[2:])

# "OO" -> 2, "OEO" -> 4, "OEEO" -> 6 ====> 0 followed by n Es and then a O = 2* n + 2
