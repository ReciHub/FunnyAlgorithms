from tkinter import *
from tkinter.ttk import Treeview
import tkinter as Tkinter
import PySimpleGUI as sg
import matplotlib.pyplot as plt
from operator import attrgetter
from Entity import Entity
from Product import Product
import random
import copy

PRODUCTS_LIST = []

def createGraph(bestIndividualsFitness, worstIndividualsFitness, averageIndividualsFitness,generationsList):
    plt.plot(bestIndividualsFitness)
    plt.plot(worstIndividualsFitness)
    plt.plot(averageIndividualsFitness)
    plt.legend((['Best case', 'Worst case', 'Average case']))
    plt.title('Resultados obtenidos')
    plt.xlabel('Generacion')
    plt.ylabel('Fitness')
    plt.show()

def createTable(bestIndividual,goalType,bestIndividualsFitness,worstIndividualsFitness,averageIndividualsFitness,generationsList):
    root = Tk()
    if(goalType == 'C'):
        root.title('Resultados de optimización por calorías: ')
    else:
        root.title('Resultados de optimización por calorías: ')

    table = Treeview(root,columns=("Nombre","Calorías","Proteínas","Cantidad"), selectmode='browse')
    table.heading("#0",text="")
    table.column("#0",minwidth=0, width=20, anchor=N, stretch=NO)
    table.heading("Nombre",text="Nombre")
    table.column("Nombre",minwidth=0, width=180, anchor=N, stretch=NO)
    table.heading("Calorías",text="Calorías")
    table.column("Calorías",minwidth=0, width=120, anchor=N, stretch=NO)
    table.heading("Proteínas",text="Proteínas")
    table.column("Proteínas",minwidth=0, width=120, anchor=N, stretch=NO)
    table.heading("Cantidad",text="Cantidad")
    table.column("Cantidad",minwidth=0, width=120, anchor=N, stretch=NO)

    #Adding data
    counter = 0
    for product in bestIndividual.productsList:
        table.insert(parent='',index='end',iid=counter,values= (product.name,product.calories,product.proteins,product.quantity))
        counter += 1
    table.pack()

    canvas = Canvas(root, width = 400, height = 100)
    canvas.pack()
    textLabel = ''
    if(goalType == 'C'):
        textLabel = "Total calories: "
    else:
        textLabel = "Total proteins: "
    
    canvas.create_text(100,10,text = textLabel + str(bestIndividual.fitness))


    createGraph(bestIndividualsFitness,worstIndividualsFitness,averageIndividualsFitness,generationsList)
    root.mainloop()

def createFirstIndividuals(startingPopulation,goal,goalType):
    totalFitness = 0
    for i in range(startingPopulation):
        #self,productList,goal,goalType
        productsListCopy = copy.deepcopy(PRODUCTS_LIST)
        for product in productsListCopy:
            product.quantity = random.randint(0,1)
        entitiesList.append(Entity(productsListCopy,goal,goalType))
        totalFitness += entitiesList[i].fitness

    updateRoulettePercentages(totalFitness,entitiesList)

    return entitiesList

def updateTotalFitness(entitiesList):
    totalFitness = 0
    for entity in entitiesList:
        totalFitness += entity.fitness
    return totalFitness

def updateRoulettePercentages(totalFitness,entitiesList):
    placeInGraph = 0
    for entity in entitiesList:
        rangeInGraph = []
        rangeInGraph.append(placeInGraph)
        percentage = ((entity.fitness * 100)/totalFitness)
        placeInGraph += percentage
        rangeInGraph.append(placeInGraph)
        entity.updatePercentage(percentage)
        entity.updateRangeInGraph(rangeInGraph)

def createProducts():
    PRODUCTS_LIST.append(Product('Pollo sin piel 3 oz',141,28,0))
    PRODUCTS_LIST.append(Product('Filete de res 3 oz',158,26,0))
    PRODUCTS_LIST.append(Product('Huevo 1 pza',71,6,0))
    PRODUCTS_LIST.append(Product('Puerco 3 oz',122,22,0))
    PRODUCTS_LIST.append(Product('Salmón 3 oz',155,22,0))
    PRODUCTS_LIST.append(Product('Atún 3 oz',99,22,0))
    PRODUCTS_LIST.append(Product('Camarón 3 oz',101,20,0))
    PRODUCTS_LIST.append(Product('Langosta 3 oz',76,16,0))
    PRODUCTS_LIST.append(Product('Lentejas 1/2 taza',101,9,0))
    PRODUCTS_LIST.append(Product('Frijoles negros 1/2 taza',114,8,0))
    PRODUCTS_LIST.append(Product('Edamame 1/2 taza',95,9,0))
    PRODUCTS_LIST.append(Product('Garbanzo 1/2 taza',134,7,0))
    PRODUCTS_LIST.append(Product('Cacahuate 1 oz',166,7,0))
    PRODUCTS_LIST.append(Product('Almendras 1 oz',163,6,0))
    PRODUCTS_LIST.append(Product('Semillas de girasol 1 oz',140,6,0))
    PRODUCTS_LIST.append(Product('Semillas de chía 1 oz',138,5,0))
    PRODUCTS_LIST.append(Product('Yogur griego 6 oz',100,18,0))
    PRODUCTS_LIST.append(Product('Leche descremada 1 taza',86,8,0))
    PRODUCTS_LIST.append(Product('Queso cottage 1% de grasa 4 oz',81,14,0))
    PRODUCTS_LIST.append(Product('Leche de soya 1 taza',132,8,0))


def calculate(entitiesList,generations,maxPopulation,goal,goalType,startingPopulation):
    breedProbabilty = random.randint(60,90)/100
    print("Probabilidad de cruza: " + str(breedProbabilty))
    createdIndividuals = len(entitiesList)

    bestIndividualsFitness = []
    worstIndividualsFitness = []
    averageIndividualsFitness = []
    generationsList = []

    for i in range(generations):
        print("___________________________________GENERATION:___________________________________ " + str(i+1))
        if len(entitiesList) == 0:
            entitiesList = createFirstIndividuals(startingPopulation,goal,goalType)
        totalFitness = updateTotalFitness(entitiesList)
        updateRoulettePercentages(totalFitness,entitiesList)

        #Selecting entities randomly to breed
        population = len(entitiesList)
        probabilities = []
        selectedParents = []
        for i in range(population):
            probabilities.append(random.random() * 100)
        
        for entity in entitiesList:
            for probability in probabilities:
                if probability >= entity.rangeInGraph[0] and probability <= entity.rangeInGraph[1]:
                    selectedParents.append(entity)

        probabilitiesOfMating = []
        numberOfPairs = int(len(selectedParents)/2)
        for i in range(numberOfPairs):
            probabilitiesOfMating.append(random.randint(0,100)/100)

        breedingPoint = random.randint(0,80) #Chromosome size

        counter = 0
        pair = 0
        matingCounter = 0
        matingPartners = []
        children = []
        breed = True
        for parent in selectedParents:
            if counter < len(probabilitiesOfMating)-1:
                if probabilitiesOfMating[counter] <= breedProbabilty or (pair == 1 and breed):
                    matingPartners.append(parent)
                else:
                    breed = False  
                    
                pair += 1

                if pair == 2 and breed:
                    parent1 = matingPartners[matingCounter]
                    parent2 = matingPartners[matingCounter+1]
                    firstDescendant = '' + parent1.chromosome[0:breedingPoint] + parent2.chromosome[breedingPoint:80]
                    secondDescendant = '' + parent2.chromosome[0:breedingPoint] + parent1.chromosome[breedingPoint:80]

                    createdIndividuals += 1
                    child1 = Entity(copy.deepcopy(PRODUCTS_LIST),goal,goalType)
                    child1.updateInformation(firstDescendant)
                    entitiesList.append(child1)
                    children.append(child1)

                    createdIndividuals += 1
                    child2 = Entity(copy.deepcopy(PRODUCTS_LIST),goal,goalType)
                    child2.updateInformation(secondDescendant)
                    entitiesList.append(child2)
                    children.append(child2)
                    matingCounter += 2
                    pair = 0
                    counter += 1
                elif pair == 2:
                    pair = 0
                    counter += 1
                    breed = True

        updateTotalFitness(entitiesList)
        updateRoulettePercentages(totalFitness,entitiesList)

        #END OF BREEDING

        #*****************************************MUTATION*****************************************

        population = len(entitiesList)

        mutationProbability1 = int((1/population)*100)
        mutationProbability2 = int((1/80)*100)
        mutationProbability = 0

        if mutationProbability1 > mutationProbability2:
            mutationProbability = random.randint(mutationProbability2,mutationProbability1)
        else:
            mutationProbability = random.randint(mutationProbability1, mutationProbability2)

        mutationProbability = mutationProbability/100

        print("Probabilidad de mutacion: " + str(mutationProbability))

        for child in children:
            newChromosome = ''
            for chromosome in child.chromosome:
                mutate = (random.randint(0,100))/100
                if mutate <= mutationProbability:
                    if chromosome == '0':
                        chromosome = '1'
                    else:
                        chromosome = '0'  

                newChromosome += str(chromosome)

            child.updateInformation(newChromosome) 

        totalFitness = updateTotalFitness(entitiesList)
        updateRoulettePercentages(totalFitness,entitiesList)
        population = len(entitiesList)

        #END OF MUTATION

        ##CONSISTENCY
        extinctList = []
        for entity in entitiesList:
            if entity.fitness > goal:
                extinctList.append(entity)

        for extinct in extinctList:
            entitiesList.remove(extinct)
        ##END OF CONSISTENCY

        ##PODA
        entitiesList = sorted(entitiesList, key = attrgetter('fitness'))
        population = len(entitiesList)
        while(population > maxPopulation and len(entitiesList) > 0):
            entitiesList.pop(0)
            population -= 1
        ##END OF PODA


        ##START OF GRAPH: 
        if len(entitiesList) > 0:
            totalFitness = updateTotalFitness(entitiesList)
            updateRoulettePercentages(totalFitness,entitiesList)
            population = len(entitiesList)

            bestFitness = entitiesList[len(entitiesList) - 1].fitness
            worstFitness = entitiesList[0].fitness
            averageFitness = totalFitness/population

            bestIndividualsFitness.append(bestFitness)
            worstIndividualsFitness.append(worstFitness)
            averageIndividualsFitness.append(averageFitness)
            generationsList.append(i)
        

    createTable(entitiesList[len(entitiesList)-1],goalType,bestIndividualsFitness,worstIndividualsFitness,averageIndividualsFitness,generationsList)
    


#****************************************************************************
#************************************MAIN************************************
#****************************************************************************

sg.theme('DarkTanBlue')   

layout = [  [sg.Text('Ingrese los valores solicitados.',size=(0,0),auto_size_text=True)],
            [sg.Text('Población inicial:   '), sg.InputText(key='startingPopulation')],
            [sg.Text('Población máxima:'), sg.InputText(key='maxPopulation')],
            [sg.Text('# generaciones:     '), sg.InputText(key='generations')],
            [sg.Radio('Calorías','radioGroup',default= True,key='calories'), sg.Radio('Proteínas','radioGroup',default=False, key='proteins')],
            [sg.Text('Meta diaria:\t'), sg.InputText(key='goal')],
            [sg.Submit("Ok"), sg.Cancel('Cancel')],
            [sg.Text('NOTA: La cantidad máxima de calorías por día es de: 5085, con una cantidad recomendable de 2,500 calorías por día para estar saludable.')],
            [sg.Text('Mientras que la cantidad máxima de proteínas por día es de: 572, con una cantidad recomendable de aproximadamente 65 proteínas.\nEl resultado será mostrado para un período de 7 días.')] ]

window = sg.Window('Algoritmo genético', layout,margins=(100,50))

counter = 0

while True:
    event, values = window.read()
    if event == sg.WIN_CLOSED or event == 'Cancel': # if user closes window or clicks cancel
        break

    if counter == 0:
        createProducts()
        counter = 1

    startingPopulation = values['startingPopulation']
    maxPopulation = values['maxPopulation']
    generations = values['generations']
    caloriesInput = values['calories']
    goal = values['goal']
    entitiesList = []
    if startingPopulation.strip() and maxPopulation.strip() and generations.strip() and goal.strip():
        startingPopulation = int(startingPopulation)
        maxPopulation = int(maxPopulation)
        generations = int(generations)
        goal = int(goal) * 7
        
        if(caloriesInput):
            goalType = 'C'
        else:
            goalType = 'P'

        entitiesList = createFirstIndividuals(startingPopulation,goal,goalType)
        calculate(entitiesList, generations,maxPopulation,goal,goalType,startingPopulation)
        
    else:
        sg.Popup('An error has occured!','Please, fill all the fields.')
    

window.close()
