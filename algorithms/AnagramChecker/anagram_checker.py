def to_counts(s):
    counts = {}
    for c in s:
        if c in counts:
            counts[c] += 1
        else:
            counts[c] = 1
    return counts


def is_anagram(s1, s2):
    return to_counts(s1) == to_counts(s2)


if __name__ == "__main__":
    s1 = input("Enter a word: ")
    s2 = input("Enter another word: ")

    if is_anagram(s1, s2):
        print(s1 + " and " + s2 + " are anagrams")
    else:
        print(s1 + " and " + s2 + " are not anagrams")
