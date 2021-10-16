import Foundation

func readNumber() -> Float {
    if let typed = readLine() {
        if let num = Float(typed) {
            return num
        } else { return 0 }
    } else { return 0 }
}

func areaDoTrapezio(baseMenor: Float, baseMaior: Float, altura : Float) -> Float {
    let area = ((baseMenor + baseMaior) * altura) / 2
    return area;
}

print("Area do trapezio")
print("Informe a base menor:")
var baseMenor = readNumber()

print("Informe a base maior:")
var baseMaior = readNumber()

print("Informe a altura do trapezio:")
var altura = readNumber()

print("Resultado : \(areaDoTrapezio(baseMenor : baseMenor , baseMaior : baseMaior, altura : altura))")
