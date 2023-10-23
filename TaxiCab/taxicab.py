taxicab_dict = {}
def find_taxicab_numbers(limit):  
    for i in range(1, limit):
        for j in range(i + 1, limit):
            cab_number = i**3 + j**3
            
            if cab_number in taxicab_dict:
                taxicab_dict[cab_number].append((i, j))
            else:
                taxicab_dict[cab_number] = [(i, j)]
    
    taxicabs = [key for key in taxicab_dict if len(taxicab_dict[key]) >= 2]
    
    return taxicabs

limit = 1000  # Adjust the limit as needed
taxicabs = find_taxicab_numbers(limit)

if len(taxicabs) > 0:
    print("Taxicab numbers up to", limit, "are:")
    for cab in taxicabs:
        pairs = taxicab_dict[cab]
        print(cab, " with pairs: ", pairs)
else:
    print("No taxicab numbers found up to", limit)
