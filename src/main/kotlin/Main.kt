package com.danylo.oliinyk

enum class AllowedKey {
    W, A, S, D, Q, SPACE,
    UNKNOWN
}

object Colors {
    val RESET = "\u001B[0m"
    val RED = "\u001B[31m"
    val YELLOW = "\u001B[33m"
    val GREEN = "\u001B[32m"
    val CYAN = "\u001B[36m"
    val BLUE = "\u001B[34m"
    val PURPLE = "\u001B[35m"
}

var posX = 0
var posY = 0
val width = 10
val height = 10
val map = MutableList(height) { MutableList(width) { "[ ]" } }

fun main() {


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
                moveCharacter(dx = 0, dy = -1)
                printMap(map)
            }

            AllowedKey.A -> {
                moveCharacter(dx = -1, dy = 0)
                printMap(map)
            }

            AllowedKey.S -> {
                moveCharacter(dx = 0, dy = 1)
                printMap(map)
            }

            AllowedKey.D -> {
                moveCharacter(dx = 1, dy = 0)
                printMap(map)
            }

            AllowedKey.Q -> {
                println("${Colors.RED}B${Colors.YELLOW}Y${Colors.GREEN}E${Colors.CYAN}B${Colors.BLUE}Y${Colors.PURPLE}E${Colors.RED}E${Colors.RESET}")

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

fun moveCharacter(dx: Int, dy: Int) {
    val currentPositionX = posX
    val currentPositionY = posY
    val newPositionX = currentPositionX + dx
    val newPositionY = currentPositionY + dy

    if ((newPositionX in 0 until width) and (newPositionY in 0 until height)) {
        map[currentPositionY][currentPositionX] = "[ ]"
        map[newPositionY][newPositionX] = "[x]"
        posX = newPositionX
        posY = newPositionY
        println("Позиція: X = $newPositionX, Y = $newPositionY")
    } else {
        println("${Colors.RED}Ти не можеш туди потрапити${Colors.RESET}")
    }
}