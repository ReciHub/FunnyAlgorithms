def probability_of_event(nodes, name):
    probability = 0

    def node_probability(node, name):
        if node.name == name:
            return [node.probability]

        if len(node.childrens) == 0:
            return []

        probabilities = []
        for children in node.childrens:
            for probability in node_probability(children, name):
                probabilities.append(node.probability * probability)

        return probabilities

    for node in nodes:
        probability += sum(node_probability(node, name))

    return probability

class Node:
    def __init__(self, name, probability, childrens=[]):
        self.name = name
        self.probability = probability
        self.childrens = childrens


'''
Lets say we want to calculate the TPL of event A1 where,
P(A1) = P(H1)P(A1|H1) + P(H2)P(A1|H2) + P(H3)P(A1|H3)

We will enter the probability of each type of event
'''

a1_h1 = Node('A1', 0.5)
a2_h1 = Node('A2', 0.5)
h1 = Node('H1', 0.3, [ a1_h1, a2_h1 ])

a1_h2 = Node('A1', 0.7)
a2_h2 = Node('A2', 0.3)
h2 = Node('H2', 0.5, [ a1_h2, a2_h2 ])

a1_h3 = Node('A1', 1)
a2_h3 = Node('A2', 0)
h3 = Node('H2', 0.2, [ a1_h3, a2_h3 ])

a1_probability = probability_of_event([ h1, h2, h3 ], 'A1')
print(a1_probability) # 0.7
