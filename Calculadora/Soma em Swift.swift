//
//  main.swift
//  FunnyAlgorithmsSwift
//
//  Created by Italo Melo on 06/10/20.
//

import Foundation

var num : Int;
var numDois : Int;

print("Soma :")
print("Primeiro número:")
num = Int((readLine()! as NSString).intValue)
print("Segundo número número:")
numDois = Int((readLine()! as NSString).intValue)

print()
print(soma(num : num, numDois :numDois))

func soma(num : Int,numDois: Int) -> Int {
    let soma = num + numDois;
    return soma;
}
