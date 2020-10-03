/**
 * @created October 2, 2019
 * Kotlin Program that solves Rat in a maze problem using backtracking.
 */
class RatMaze {

    // Size of the maze.
    private var n: Int = 0 // Just in case. Primitive types cannot be lateinit.
    private lateinit var solution: Array<IntArray>
    private lateinit var maze: Array<IntArray>

    /**
     * This function solves the Maze problem using
     * Backtracking. It mainly uses solveMazeUtil()
     * to solve the problem. It returns false if no
     * path is possible, otherwise return true and
     * prints the path in the form of 1s. Please note
     * that there may be more than one solutions, this
     * function prints one of the feasible solutions.
     */
    fun solve(maze: Array<IntArray>): Boolean {
        n = maze.size
        this.maze = maze
        solution = Array(n) { IntArray(n) }
        if (!solveMazeUtil(0, 0)) {
            println("Solution does not exist.")
            return false
        }
        printSolution()
        return true
    }

    /**
     * A recursive utility function to solve Maze problem.
     */
    private fun solveMazeUtil(row: Int, column: Int): Boolean {
        // if (row ; column) is the goal then return true
        if (row == n - 1 && column == n - 1) {
            solution[row][column] = 1
            return true
        }
        // Check if maze[row][column] is valid.
        if (isSafe(row, column)) {
            solution[row][column] = 1
            // Move horizontally
            if (solveMazeUtil(row, column + 1)) {
                return true
            }
            // Move vertically
            if (solveMazeUtil(row + 1, column)) {
                return true
            }
            // If none of the above movements works then
            // BACKTRACK: remove mark on row, column as part of solution path
            solution[row][column] = 0
            return false
        }
        return false
    }

    /**
     * Checks that the coordinates "row" and "column" are valid.
     */
    private fun isSafe(row: Int, column: Int): Boolean {
        return row in 0..(n - 1) &&
                column in 0..(n - 1) &&
                maze[row][column] == 1
    }

    /**
     * A utility function to print solution matrix.
     * solution[n][n]
     */
    private fun printSolution() {
        (0..(n - 1)).forEach { row ->
            (0..(n - 1)).forEach { column ->
                print(" ${solution[row][column]}")
            }
            println()
        }
    }

}

fun main() {
    // Valid Maze
    val maze01 = arrayOf(
        intArrayOf(1, 0, 0, 0),
        intArrayOf(1, 1, 0, 1),
        intArrayOf(0, 1, 0, 0),
        intArrayOf(1, 1, 1, 1)
    )

    // Valid Maze
    val maze02 = arrayOf(
        intArrayOf(1, 0, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 1, 1)
    )

    // Invalid Maze
    val maze03 = arrayOf(
        intArrayOf(1, 0, 0),
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 1)
    )

    val mazes = arrayListOf<Array<IntArray>>()
    mazes.add(maze01)
    mazes.add(maze02)
    mazes.add(maze03)

    val ratMaze = RatMaze()
    for (i in 0 until mazes.size) {
        println("Solving Maze ${i + 1}")
        println()
        ratMaze.solve(mazes[i])
        println()
    }
}