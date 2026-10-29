from TrainedNeuron import TrainedNeuron
import PySimpleGUI as sg
import random
import matplotlib.pyplot as plt
import numpy
from tkinter import *
from tkinter import messagebox
from numpy import linalg as LA

AND_MATRIX = numpy.zeros((4,4))
OR_MATRIX = numpy.zeros((4,4))


def testTrainedNeuron(trainedNeuron,errorEvolutionList,iterations):
    
    window = Tk()

    lbl = Label(window, text="Ingrese la entrada a probar: ", font=("Roboto", 14))
    lbl.grid(column=0, row=0)
    
    txt = Entry(window,width=30)
    txt.grid(column=0, row=1)
    txt.focus()
    
    def evaluate():
        try:
            if len(list(txt.get())) == 2:
                inputData = str(1) + txt.get()
                inputMatrix = numpy.asmatrix(list(map(int, inputData)))
                weightsMatrix = numpy.asmatrix(trainedNeuron.weights)
                result = inputMatrix * weightsMatrix.transpose()
                #Función de activación (para Yc)
                ycList = []
                for u in result:
                    if(u <= 0):
                        ycList.append(0)
                    else:
                        ycList.append(1)
                Yc = numpy.asmatrix(ycList).transpose()
                messagebox.showinfo('Result', 'EL resultado es: ' + str(Yc[0,0]))
            else:
                messagebox.showinfo('ERROR', 'Ha ocurrido un error. La cadena de entrada debe ser de 3 dígitos')
        except:
            messagebox.showinfo('ERROR', 'Ha ocurrido un error. Verifique los datos ingresados')

        
    btn = Button(window, text="Evaluar entrada", command = evaluate)

    btn.grid(column=0, row=2)

    lbl2 = Label(window, text="El resultado de los pesos es: [" + str(trainedNeuron.weights[0,0]) + ', ' + str(trainedNeuron.weights[0,1]) + ', ' + str(trainedNeuron.weights[0,2]) + '].', font=("Roboto", 10))
    lbl2.grid(column=0, row=3)
    

    window.title("Test trained Neuron")
    window.geometry('400x200')
    createGraph(errorEvolutionList,iterations)
    window.mainloop()
    print('WIP')


def createGraph(errorEvolutionList,iterations):
    plt.plot(errorEvolutionList)
    plt.legend((['Error']))
    plt.title('Resultados obtenidos')
    plt.xlabel('Iteración')
    plt.ylabel('Error')
    plt.show()


def fillOrAndMatrixes():
    for i in range(4):
        binaryValue = format(i,'b')
        while(len(binaryValue) < 2 ):
            binaryValue = '0' + binaryValue
            
        #Filling AND:
        binary = list(binaryValue)

        AND_MATRIX[i][0] = 1
        AND_MATRIX[i][1] = int(binary[0])
        AND_MATRIX[i][2] = int(binary[1])

        if int(binary[0]) and int(binary[1]):
            AND_MATRIX[i][3] = 1
        else:
            AND_MATRIX[i][3] = 0

        #FILLING OR:
        OR_MATRIX[i][0] = 1
        OR_MATRIX[i][1] = int(binary[0])
        OR_MATRIX[i][2] = int(binary[1])

        if int(binary[0]) or int(binary[1]):
            OR_MATRIX[i][3] = 1
        else:
            OR_MATRIX[i][3] = 0
        


def calculate(isAnd):
    if isAnd:
        X = numpy.delete(AND_MATRIX,3,1)
        Y = numpy.delete(AND_MATRIX,(0,1,2),1)
    else:
        X = numpy.delete(OR_MATRIX,3,1)
        Y = numpy.delete(OR_MATRIX,(0,1,2),1)
    graphicList = []
    iterationsList = []
    eta = 0.5
    exitCondition = 0.01
    counter = 0
    exit = False
    wList = []

    #Creating first random weights
    for i in range(3):
        wList.append(random.randint(0,100)/100)

    W = numpy.asmatrix(wList)
    print("RANDOMLY GENERATED Weights: ")
    print(W)

    while not exit:
        #Cálculo de U
        print('********************************* ITERATION ' + str(counter))
        print("Weights: ")
        print(W)
        U = X * W.transpose()

        #Función de activación (para Yc)
        ycList = []
        for u in U:
            if(u <= 0):
                ycList.append(0)
            else:
                ycList.append(1)
        
        Yc = numpy.asmatrix(ycList).transpose()

        #Cálculo de la matriz de error
        E = Y - Yc

        #Cálculo de los nuevos pesos ( W(k+1) )
        W = W + (eta * (E.transpose() * X))

        #Cálculo de la norma euclidiana
        e = LA.norm(E)
        graphicList.append(e)

        if(e < exitCondition):
            exit = True
        

        print('U: ')
        print(U)

        print('Yc: ')
        print(Yc)

        print('E: ')
        print(E)

        print('e: ' + str(e))
        iterationsList.append(counter)
        counter += 1

    print("FINAL Weights: ")
    print(W)
    trainedNeuron = TrainedNeuron(W)

    testTrainedNeuron(trainedNeuron,graphicList,iterationsList)
    








#**************************************
#*****************MAIN*****************
#**************************************


sg.theme('DarkTanBlue')   

layout = [  [sg.Text('Seleccione el tipo de compuerta para entrenar')],
            [sg.Radio('Compuerta AND','radioGroup',default= True,key='andGate'), sg.Radio('Compuerta OR','radioGroup',default=False, key='orGate')],
            [sg.Submit("Ok"), sg.Cancel('Cancel')] ]

window = sg.Window('Algoritmo genético', layout,margins=(100,50))

fillOrAndMatrixes()

while True:
    event, values = window.read()
    if event == sg.WIN_CLOSED or event == 'Cancel': # if user closes window or clicks cancel
        break

    andGate = values['andGate']
    orGate = values['orGate']

    calculate(andGate) 
    

window.close()