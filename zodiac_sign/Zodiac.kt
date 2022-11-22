fun main() {
    print("Please eneter your date of birth in MMDD format : ")
    val mmdd = readln().toIntOrNull()

    val zodiac =
        when (mmdd) {
            in 120..131,
            in 200..218 -> "Aquarius"
            in 219..229,
            in 300..320 -> "Pisces"
            in 321..331,
            in 400..419 -> "Aries"
            in 420..430,
            in 500..520 -> "Taurus"
            in 521..531,
            in 600..621 -> "Gemini"
            in 622..630,
            in 700..722 -> "Cancer"
            in 723..731,
            in 800..822 -> "Leo"
            in 823..831,
            in 900..922 -> "Virgo"
            in 923..930,
            in 1000..1023 -> "Libra"
            in 1024..1031,
            in 1100..1121 -> "Scorpio"
            in 1122..1130,
            in 1200..1221 -> "Sagittarius"
            in 101..119,
            in 1222..1231 -> "Capricorn"
            else -> {
                println("Invalid format of Date of Birth!! 'MMDD' needed.")
                "Not Found!"
            }
        }

    println("Your Zodiac Sign is: $zodiac")
}
