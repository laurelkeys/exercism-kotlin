import java.util.Random

class Robot {

    var name = generateName()

    fun reset() {
        val newName = generateName()
        namesInUse.remove(name)
        name = newName
    }

    private companion object {
        val numbers = "1234567890".toList()
        val letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toList()
        val namesInUse = mutableSetOf<String>()

        private tailrec fun generateName(): String {
            val newName = (letters.pick(2) + numbers.pick(3)).joinToString("")
            return when {
                namesInUse.add(newName) -> newName
                else -> generateName() // the generated name is already in use
            }
        }
    }
}

private fun List<*>.pick(n: Int) = (1..n).map { this[Random().nextInt(this.size)] }
