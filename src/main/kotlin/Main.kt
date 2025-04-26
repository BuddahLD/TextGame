package com.danylo.oliinyk

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val width = 10
    val height = 10

    val map = Array(height) { Array(width) { "[ ]" } }
    var posX = 0
    var posY = 0
    map[posY][posX] = "[x]"
    printMap(map)

    var isAppRun = true
    while(isAppRun) {
        val pressedKey = readAllowedKey()
        if (pressedKey == AllowedKey.Q) {
            isAppRun = false
        } else {
            println(pressedKey.name.lowercase())
        }

    }
}

fun printMap(map: Array<Array<String>>) {
    for (row in map) {
        println(row.joinToString(""))
    }
}

enum class AllowedKey {
    W, A, S, D, Q, SPACE, UNKNOWN
}

fun readAllowedKey(): AllowedKey {
    print("Press a key (W/A/S/D/SPACE): ")
    val input = readLine()

    return when (input) {
        "w" -> AllowedKey.W
        "a" -> AllowedKey.A
        "s" -> AllowedKey.S
        "d" -> AllowedKey.D
        "q" -> AllowedKey.Q
        " "  -> AllowedKey.SPACE  // handle Enter as space (simplification)
        else -> AllowedKey.UNKNOWN
    }
}
