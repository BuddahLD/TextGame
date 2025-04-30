package com.danylo.oliinyk

import java.awt.Color
import java.awt.Font
import java.awt.Graphics
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.JFrame
import javax.swing.JPanel
import kotlin.system.exitProcess

enum class AllowedKey {
    W, A, S, D, Q, SPACE,
    UNKNOWN
}

class GamePanel : JPanel() {
    val widthSquares = 10
    val heightSquares = 10
    val cellSize = 40
    var posX = 0
    var posY = 0
    var statusMessage = "Position: X = 0, Y = 0"
    var isEdgeReached = false
    
    init {
        isFocusable = true
        addKeyListener(
            object : KeyAdapter() {
                override fun keyPressed(e: KeyEvent) {
                    when (e.keyChar) {
                        'w' -> movePlayer(0, -1)
                        'a' -> movePlayer(-1, 0)
                        's' -> movePlayer(0, 1)
                        'd' -> movePlayer(1, 0)
                        'q' -> exitProcess(0)
                    }
                    repaint()
                }
            }
        )
    }
    
    private fun movePlayer(dx: Int, dy: Int) {
        val newX = posX + dx
        val newY = posY + dy
        
        if (newX in 0 until widthSquares && newY in 0 until heightSquares) {
            posX = newX
            posY = newY
            statusMessage = "Position: X = $posX, Y = $posY"
            isEdgeReached = false
        } else {
            statusMessage = "Map edge reached"
            isEdgeReached = true
        }
    }
    
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        
        // Draw grid of blue squares
        g.color = Color.BLUE
        for (y in 0 until heightSquares) {
            for (x in 0 until widthSquares) {
                g.fillRect(x * cellSize, y * cellSize, cellSize - 2, cellSize - 2)
            }
        }
        
        // Draw red circle at player position
        g.color = Color.RED
        g.fillOval(posX * cellSize + 5, posY * cellSize + 5, cellSize - 10, cellSize - 10)
        
        // Draw status message
        g.font = Font("Arial", Font.BOLD, 14)
        if (isEdgeReached) {
            g.color = Color.RED
        } else {
            g.color = Color.BLACK
        }
        g.drawString(statusMessage, 10, heightSquares * cellSize + 30)
    }
}

fun drawSampleUi() {
    val frame = JFrame("Grid Game")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    
    val gamePanel = GamePanel()
    frame.contentPane = gamePanel
    frame.setSize(gamePanel.widthSquares * gamePanel.cellSize + 50, gamePanel.heightSquares * gamePanel.cellSize + 80)
    frame.isVisible = true
    
    gamePanel.requestFocus()
}

fun main() {
    drawSampleUi()
}
