//
//  main.swift
//  FunnyAlgorithmsSwift
//
//  Created by Italo Melo on 11/10/20.
//

import Foundation

var dUm : Double;
var dDois : Double;
var tempoUm : Double;
var tempoDois : Double;


print("Posição inicial:")
dUm = (readLine()! as NSString).doubleValue
print("Posição final:")
dDois = (readLine()! as NSString).doubleValue

print()
print("Tempo inicial:")
tempoUm = (readLine()! as NSString).doubleValue
print("Tempo final:")
tempoDois = (readLine()! as NSString).doubleValue

print()

print(velocidade(dUm : dUm, dDois :dDois, tempoUm : tempoUm, tempoDois : tempoDois))

func velocidade(dUm : Double,dDois: Double, tempoUm : Double, tempoDois : Double) -> Double {
    let resultado = (dDois - dUm) / (tempoDois - tempoUm)
    return resultado;
}
