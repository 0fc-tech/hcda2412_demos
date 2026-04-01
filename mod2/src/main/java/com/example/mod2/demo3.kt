package com.example.mod2

import kotlin.random.Random

fun main11() {
    val listClient = listOf("John Doe", "Peter Parker","Harry Potter", "Tony Stark")
    for(client in listClient){
        println("Bienvenu $client,\n Notre solution de paiement est conçue pour vous")
    }
}
fun main22(){
    val secretNumber = Random.nextInt(1, 11)
    var guess: Int
    var attempts = 0

    println("Devinez le nombre entre 1 et 10!")

    while (true) {
        print("Entrez votre nombre: ")
        guess = readLine()!!.toInt()
        attempts++

        if (guess == secretNumber) {
            println("Bravo! vous avez trouvé $secretNumber en $attempts tentatives.")
                break
        } else {
            println("Essayez encore.")
        }
    }
}


fun main() {
    //déclaration d'un tableau
    val pays = arrayOf("France", "Belgique", "Espagne")

    for(p in pays){
        println(p)
    }
    for(i in 1..10){
        println(i)
    }

    for(j in 10 downTo 1 step 2){
        println(j)
    }


    //boucle foreach avec index
    for ((key, p) in pays.withIndex()){
        println(key)
        println(p)
    }
}

val list = List(30) {id ->
    "Item $id"
}
val list2 = List(30,{id ->
    "Item $id"
})
