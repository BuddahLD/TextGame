package com.danylo.oliinyk

enum class AllowedKey {
    W, A, S, D, Q, SPACE,
    UNKNOWN
}

fun main() {
    val width = 10
    val height = 10
    val map = MutableList(height) { MutableList(width) { "[ ]" } }
    val reset = "\u001B[0m"
    val red = "\u001B[31m"
    val yellow = "\u001B[33m"
    val green = "\u001B[32m"
    val cyan = "\u001B[36m"
    val blue = "\u001B[34m"
    val purple = "\u001B[35m"
//    println(map)

    var posX = 0
    var posY = 0

    map[posY][posX] = "[x]" // map.get(posX).set(posY, "x")
    printMap(map)

    var isAppRun = true
    while (isAppRun) {
        val pressedKey = readAllowedKey()
        if (pressedKey == AllowedKey.Q) {
            isAppRun = false
        }

        when (pressedKey) {
            AllowedKey.W -> {
                val newPositionY = posY - 1
                if (newPositionY >= 0) {
                    map[posY][posX] = "[ ]"
                    map[newPositionY][posX] = "[x]"
                    posY = newPositionY
                    printMap(map)
                    println("Позиція: X = $posY, Y = $posX")
                } else {
                    println("${red}Map edge reached$reset")
                }
            }

            AllowedKey.A -> {
                val newPositionX = posX - 1
                if (newPositionX >= 0) {
                    map[posY][posX] = "[ ]"
                    map[posY][newPositionX] = "[x]"
                    posX = newPositionX
                    printMap(map)
                    println("Позиція: X = $posY, Y = $posX")
                } else {
                    println("${red}Map edge reached$reset")
                }

            }

            AllowedKey.S -> {
                val newPositionY = posY + 1
                if (newPositionY <= 9) {
                    map[posY][posX] = "[ ]"
                    map[newPositionY][posX] = "[x]"
                    posY = newPositionY
                    printMap(map)
                    println("Позиція: X = $posY, Y = $posX")
                } else {
                    println("${red}Map edge reached$reset")
                }
            }

            AllowedKey.D -> {
                val newPositionX = posX + 1
                if (newPositionX <= 9) {
                    map[posY][posX] = "[ ]"
                    map[posY][newPositionX] = "[x]"
                    posX = newPositionX
                    printMap(map)
                    println("Позиція: X = $posY, Y = $posX")
                } else {
                    println("${red}Map edge reached$reset")
                }
            }

            AllowedKey.Q -> {
                println("${red}B${yellow}Y${green}E${cyan}B${blue}Y${purple}E${red}E$reset")

            }

            AllowedKey.SPACE -> {

            }

            AllowedKey.UNKNOWN -> {



            }
        }
    }
}

private fun printMap(map: List<List<String>>) {
    map.forEach { row ->
        println(row.joinToString(""))
    }
}

private fun readAllowedKey(): AllowedKey {
    print("Press a key (w/a/s/d/space): ")
    val input = readLine()

    return when (input) {
        "w" -> AllowedKey.W
        "a" -> AllowedKey.A
        "s" -> AllowedKey.S
        "d" -> AllowedKey.D
        "q" -> AllowedKey.Q
        " " -> AllowedKey.SPACE  // handle Enter as space (simplification)
        else -> AllowedKey.UNKNOWN
    }
}

