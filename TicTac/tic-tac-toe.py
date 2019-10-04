#!/bin/python3

import math
import os
import random
import re
import sys
import copy

 
E='_'
O='O'
X='X'

reqDepth = 6


winningStates = [[0,1,2],[3,4,5],[6,7,8],[0,4,8],[2,4,6],[0,3,6],[1,4,7],[2,5,8]]

heuristicArray = [[0,-10,-100,-1000],[10,0,0,0],[100,0,0,0],[1000,0,0,0]]

class gameState(object):
    def __init__(self, board,player):
      self.board=board
      self.player=player

    def isWin(self):
        for locations in winningStates:
            if self.board[locations[0]] == startState.player and self.board[locations[1]] == startState.player and self.board[locations[2]] == startState.player:
                return True
        return False

    def isLose(self):
        if startState.player == X:
            opponent = O
        else:
            opponent = X
        for locations in winningStates:
            if self.board[locations[0]] == opponent and self.board[locations[1]] == opponent and self.board[locations[2]] == opponent:
                return True
        return False

    def isDraw(self):
        if self.isWin() or self.isLose():
            return False
        for pos in range(9):
            if self.board[pos] == E:
                return False
        return True

    def getLegalActions(self):
        legal = []
        for pos in range(9):
            if self.board[pos] == E:
                legal.append(pos)
        return legal

    def generateSuccessor(self,action):
        newState = copy.deepcopy(self)
        newState.board[action]=newState.player
        if newState.player == X:
            newState.player = O
        else:
            newState.player = X
        return newState




startState = gameState([],X)



def getAction(gameState):
        maxValue = float("-inf")
        alpha = float("-inf")
        beta = float("inf")
        maxAction = 0
        possibleActions = gameState.getLegalActions()
        # print(possibleActions)
        for action in possibleActions:
            nextState = gameState.generateSuccessor(action)
            # print(nextState.board)
            # print(nextState.player)
            value = getValue(nextState,0,alpha,beta)
            # print(value)
            if value > maxValue:
                maxValue = value
                maxAction = action
            alpha = max(alpha,maxValue)

        return maxAction


def getValue(gameState,currentDepth,alpha,beta):
    if currentDepth == reqDepth or gameState.isWin() or gameState.isLose() or gameState.isDraw():
        return evaluationFunction(gameState)
    # if gameState.isWin() or gameState.isLose() or gameState.isDraw():
    #     return evaluationFunction(gameState)
    elif gameState.player == startState.player:
        return getMaxValue(gameState,currentDepth,alpha,beta)
    else:
        return getMinValue(gameState,currentDepth,alpha,beta)


def getMaxValue(gameState,currentDepth,alpha,beta):
    maxValue = float("-inf")
    legalActions = gameState.getLegalActions()
    for action in legalActions:
        nextState = gameState.generateSuccessor(action)
        value = getValue(nextState,currentDepth,alpha,beta)
        if value > maxValue:
            maxValue = value
        if maxValue >= beta:
            return maxValue
        alpha = max(alpha, maxValue)

    return maxValue


def getMinValue(gameState,currentDepth,alpha,beta):
    minValue = float("inf")
    legalActions = gameState.getLegalActions()
    # if currentDepth == 0: print(legalActions)
    for action in legalActions:
        nextState = gameState.generateSuccessor(action)
        value = getValue(nextState,currentDepth+1,alpha,beta)
        # if currentDepth == 0: print(value)
        if value < minValue:
            minValue = value
        if minValue <= alpha:
            return minValue
        beta = min(beta, minValue)

    return minValue

def evaluationFunction(gameState):
    if gameState.isDraw(): return float(0)
    if gameState.isWin(): return float("inf")
    if gameState.isLose(): return float("-inf")
    heuristic = 0
    for wins in winningStates:
        me,opponent = 0,0
        empty = 0
        for i in range(3):
            if gameState.board[wins[i]] == startState.player:
                me += 1
            if gameState.board[wins[i]] == E:
                empty += 1
        # print((me,3-me-empty))
        # print(heuristicArray[me][3-me-empty])
        heuristic += heuristicArray[me][3-me-empty]

    return heuristic


# dummystate = gameState([X,O,E,E,E,X,E,E,E],X)
# print(dummystate.isLose)

if __name__ == '__main__':

    # print(player)
    board = list(input()+input()+input())
        # print(type(player))
    # print(board)
    player = input()

    startState.board=board
    startState.player=player
    # print(startState.board)
    # print(startState.player)
    # print(startState.isLose())

    action = getAction(startState)
    # print(action)
    print(str(int(action/3))+" "+str(int(action%3)))
    # print(len(board))
