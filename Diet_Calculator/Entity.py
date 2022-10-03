import math
from Product import Product

class Entity:
    
    def __init__(self,productsList,goal,goalType):
        self.productsList = productsList
        self.goal = goal
        self.goalType = goalType
        self.chromosome = self.createChromosome(productsList)
        self.fitness = self.calculateFitness(productsList, goalType)

    def createChromosome(self, productsList):
        chromosome = ''
        for product in productsList:
            binary = format(product.quantity, 'b')
            while(len(binary) < 4):
                binary = '0' + binary
            chromosome += binary
        return chromosome
    
    def calculateFitness(self, productsList, goalType):
        total = 0
        for product in productsList:
            if(goalType == 'C'):
                total += product.calories * product.quantity
            else:
                total += product.proteins * product.quantity
        return total

    def updateInformation(self,binary):
        self.chromosome = binary
        counter = 0
        for i in range(0,len(binary),4):
            newBinary = str(binary[i:i+4])
            self.productsList[counter].quantity = int(newBinary,2)
            counter += 1
        self.fitness = self.calculateFitness(self.productsList,self.goalType)

    def updatePercentage(self,percentage):
        self.percentage = percentage

    def updateRangeInGraph(self,rangeInGraph):
        self.rangeInGraph = rangeInGraph
        
    
