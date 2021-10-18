import Foundation

func readNumber() -> Float {
    if let typed = readLine() {
        if let num = Float(typed) {
            return num
        } else { return 0 }
    } else { return 0 }
}

func velocidadeMedia(d1: Float, d2: Float, t1 : Float, t2 : Float) -> Float {
    let velocidade = (d2 - d1) / (t2 - t1)
    return velocidade;
}

print("Velocidade média")
print("Informe a posição inicial")
var d1 = readNumber()

print("Informe a posicao final:")
var d2 = readNumber()

print("Informe o tempo inicial:")
var t1 = readNumber()

print("Informe o tempo final:")
var t2 = readNumber()

print("Resultado : \(velocidadeMedia(d1 : d1 , d2 : d2, t1 : t1, t2 : t2))")
