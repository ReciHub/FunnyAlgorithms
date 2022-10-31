import kotlin.math.PI

fun main() {
    fun areaDaCircunferencia(raio: Double): Double = raio * raio * PI

    println("Informe o raio da circunferência")
    val raio: Double? = readLine()?.toDouble()
    raio?.let {
        println("A Área da circunferência é : ${areaDaCircunferencia(it)}")
    }
}
