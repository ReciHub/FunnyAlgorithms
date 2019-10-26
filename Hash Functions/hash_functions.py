class HashTable(object):
    def __init__(self):
        self.table = [None]*10000

    def store(self, string):
        hash_value = self.calculate_hash_value(string)
        if hash_value != -1:
            if self.table[hash_value] != None:
                self.table[hash_value].append(string)
            else:
                self.table[hash_value] = [string]


    def lookup(self, string):
        hash_value = self.calculate_hash_value(string)
        try:
            if self.table[hash_value] is not None:
                return hash_value
        except:
            return -1
        return -1

    def calculate_hash_value(self, string):
        if string is not None:
            return (ord(string[0]) * 100) + ord(string[1])
        return -1
    
# Setup
hash_table = HashTable()
print hash_table.calculate_hash_value('foo')
print hash_table.lookup('foo')
hash_table.store('foo')
print hash_table.lookup('foo')
hash_table.store('foobar')
print hash_table.lookup('foobar')