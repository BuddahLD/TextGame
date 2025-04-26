package com.danylo.oliinyk

enum class AllowedKey {
    W, A, S, D, Q, SPACE,
    UNKNOWN
}

fun main() {
    val width = 10
    val height = 10
    val map = MutableList(height) { MutableList(width) { "[ ]" } }
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

            }

            AllowedKey.A -> {

            }

            AllowedKey.S -> {

            }

            AllowedKey.D -> {
                val newPositionX = posX + 1
                if (newPositionX <= 9) {
                    map[posY][posX] = "[ ]"
                    map[posY][newPositionX] = "[x]"
                    posX = newPositionX
                    printMap(map)
                } else {
                    println("Map edge reached")
                }
            }

            AllowedKey.Q -> {

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
