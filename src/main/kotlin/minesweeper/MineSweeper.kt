package minesweeper

import minesweeper.domain.BoardGenerator
import minesweeper.domain.Cells
import minesweeper.domain.Location

fun main() {
    val width = inputWidth().parseInt()
    val height = inputHeight().parseInt()
    val mineCount = inputMineCount().parseInt()

    val boardGenerator = BoardGenerator(width, height, mineCount)
    val cells = Cells(boardGenerator.generateRandomCell(), width, height)

    printStart()
    while (!cells.isAllOpen()) {
        if (!cells.enterCell(Location.of(inputPosition()))) {
            printLose()
            return
        }

        printCells(cells)
    }
    printWin()
}
