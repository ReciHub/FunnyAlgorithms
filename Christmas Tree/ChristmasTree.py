def christmas_tree(size):
    # Generates a christmas tree (string)
    
    # Size 3:
    # /\
    #/  \
    # |

    # Size 4:
    #  /\
    # /  \
    #/    \
    #  |

    if size < 3:
        return ""
    
    tree = ""
    for i in range(size - 1):
        tree += "{0}/{1}\\".format(" " * (size - i - 2), " " * (i * 2)) + "\n"
    tree += " " * (size - 2) + "|"
    return tree

print(christmas_tree(5))
