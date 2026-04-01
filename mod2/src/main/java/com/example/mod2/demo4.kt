package com.example.mod2

fun main() {

    //ajout de la méthode sayHello à la class String
    fun String.sayHello() {
        println("Salut " + this)
    }

    "Michel".sayHello()
}
fun main2() {

    var name : String?= null

    //si la longueur est null, renvoie -1
    val taille = name?.length?:-1

    println(taille)
}

fun main3() {

    //liste de string
    val couleurs = mutableListOf<String>()
    couleurs.add("bleu")
    couleurs += "jaune"
    couleurs += "jaune"
    couleurs += "jaune"


    //lambda, it nom du paramètre par défaut
    //on compte ici le nombre d'itréation de "jaune"
    var nbBleu = couleurs.filter { it == "jaune" }.count()
    //même chose en nommant le paramètre
    var nbBleu2 = couleurs.filter { color -> color == "jaune" }.count()
    println(nbBleu2)
}
