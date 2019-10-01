/*
 * The *fun* thing about Kotlin is that every function starts with "fun"
 *
 * Unlike Java, we Don't need a class scope to declare *fun*ctions!
 */
fun main() {

    // Try/catch statements are basically the same as every other language.
    try {
        // Java's System.out.println is aliased to just println!
        println("Please enter a number:")

        // val means a variable that never gonna change its reference. A constant!
        val num = readLine().orEmpty().toInt()

        // String Templates are one of my favorite features of Kotlin.
        // It allows me to create a complex string without confusing concatenations
        println("The factorial of $num is ${factorial(num)}")
    } catch (ex: NumberFormatException) {
        println("I wanna a number :(")
    } catch (ex: Exception) {
        // Unlikely Java, kotlin does not use getters and setters as an standard
        // When working integrated with Java, Kotlin allows you to directly access getters or setters
        // with just the name of the attribute.
        // E.g ex.getMessage() turns into "ex.message"; foo.setBar("kotlin") turns into foo.bar = "kotlin"
        println(ex.message)
    }
}

// The function type returns in Kotlin are described like this (this one returns a Long)
// and the parameters types are "name: Type, name2: Type2"...
fun factorial(i: Int): Long {

    // Kotlin does't use the "new" keyword to instantiate new Objects.
    if(i <= 0) throw Exception("I wanna a positive one :(")

    // Unlikely "val", var means a variable that can change its value. Actually a *var*iable.
    var ac: Long = 1

    // Kotlin works with number ranges!
    // An alias to create a range is "start .. end"
    // Note that both start and end are included in the range
    for(n in (1..i).reversed())
        ac *= n // Kotlin does not need an semicolon after the statements!
    return ac
}
