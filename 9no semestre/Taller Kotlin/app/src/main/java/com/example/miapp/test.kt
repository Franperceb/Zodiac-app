package com.example.miapp

fun main(){
    println("Hola mundo")
    var a = 10 //var mutables
    var inter = 0
    var b = 5
    val dec: Float = 8.7f //val = constantes , no mutables.
    val c = 9.7
    val d = true

    a = 5
    println(a)

    var cadena1 = "Paco"
    var cadena2 = "Nombre: " + cadena1
    cadena2 += "Universidad:  FI: UNAM" //no concatenar , usar interplacion

    inter = a + b


    println(cadena2)
    println("La suma de a +b = ${inter}")
}

