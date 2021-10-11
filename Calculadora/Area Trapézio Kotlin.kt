fun main() {
    fun areaDoTrapezio(baseMenor: Double, baseMaior: Double, altura: Double): Double {
        return baseMenor.plus(baseMaior).times(altura).div(2)
    }

    var baseMenor = 0.0
    var baseMaior = 0.0
    var altura = 0.0

    println("Informe a base menor")

    readLine()?.toDouble()?.let {
        baseMenor = it
    }

    println("Informe a base maior")

    readLine()?.toDouble()?.let {
        baseMaior = it
    }

    println("Informe a altura do trapézio")

    readLine()?.toDouble()?.let {
        altura = it
    }

    println("Area do trapézio é : ${areaDoTrapezio(baseMenor, baseMaior, altura)}")

}
