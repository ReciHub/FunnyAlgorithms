//
//  main.swift
//  FunnyAlgorithmsSwift
//
//  Created by Italo Melo on 11/10/20.
//

import Foundation

var massa : Double;
var vel : Double;

print("Massa :")
massa = (readLine()! as NSString).doubleValue
print("Velocidade:")
vel = (readLine()! as NSString).doubleValue

print()
print(energiaCinetica(massa : massa, velocidade :vel))

func energiaCinetica(massa : Double,velocidade: Double) -> Double {
    let resultado = (massa * pow(vel,2)) / 2
    return resultado;
}
