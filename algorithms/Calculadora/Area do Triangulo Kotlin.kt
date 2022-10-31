fun main() {
    fun areaDoTriangulo(base: Double, altura: Double): Double = base.times(altura).div(2)

    var base = 0.0
    var altura = 0.0

    println("Informe a base do triângulo")

    readLine()?.toDouble()?.let {
        base = it
    }

    println("Informe a altura do triângulo")

    readLine()?.toDouble()?.let {
        altura = it
    }

    println("Area do triângulo é : ${areaDoTriangulo(base, altura)}")

}
