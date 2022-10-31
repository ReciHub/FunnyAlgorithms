//
//  main.swift
//  FunnyAlgorithmsSwift
//
//  Created by Italo Melo on 06/10/20.
//

import Foundation

var a : Double = 0
var b : Double = 0;
var c : Double = 0;
var delta : Double = 0;
var bhaskara : Double = 0;

print("Digite o coeficiente a: ")
a = (readLine()! as NSString).doubleValue

print("Digite o coeficiente b: ")
b = (readLine()! as NSString).doubleValue

print("Digite o coeficiente c: ")
c = (readLine()! as NSString).doubleValue

var deltaCalculada = CalculoDelta(a : a, b : b, c : c);

print("")

print("Delta calculado : " + String(deltaCalculada))

func CalculoDelta (a : Double, b : Double, c : Double) -> Double{
    return (b * b) - (4 * (a * c));
}

func CalculoBhaskaraP(deltaCalculada : Double, bhaskarap : Double, a : Double, b : Double) -> String{
    let baskarapVar : Double = (-b + deltaCalculada.squareRoot()) / (2 * a)
        return String(baskarapVar);
    }

func CalculoBhaskaraN(deltaCalculada : Double,bhaskaran : Double, a : Double, b : Double) -> String{
    let bhaskaranVar : Double = (-b - deltaCalculada.squareRoot()) / (2 * a);
        return String(bhaskaranVar);
    }

print("Positivo: " + CalculoBhaskaraP(deltaCalculada: deltaCalculada, bhaskarap: bhaskara, a: a, b: b) + "  - Negativo: " + CalculoBhaskaraN(deltaCalculada: deltaCalculada, bhaskaran: bhaskara, a: a, b: b));

if(CalculoBhaskaraP(deltaCalculada: deltaCalculada, bhaskarap: bhaskara, a: a, b: b) == "nan"){
    print("Nao possui raizes reais")
}
