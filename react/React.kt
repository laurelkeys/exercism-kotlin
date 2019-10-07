class Reactor<T>() {
    // Your compute cell's addCallback method must return an object
    // that implements the Subscription interface.
    interface Subscription {
        fun cancel()
    }

    open inner class InputCell(private var initialValue: T) {
        var value: T = initialValue
            set(newValue) {
                if (newValue != value) {
                    field = newValue
                    subscribedCallbacks.forEach { callback ->
                        callback(newValue)
                    }
                }
            }
        private val subscribedCallbacks = mutableListOf<(T) -> Unit>()

        fun addCallback(callback: (T) -> Unit): Subscription {
            subscribedCallbacks.add(callback)
            return object : Subscription {
                override fun cancel() {
                    subscribedCallbacks.remove(callback)
                }
            }
        }
    }

    inner class ComputeCell(vararg val inputs: InputCell, val compute: (List<T>) -> T)
        : InputCell(compute(inputs.values())) {

        init {
            addCallbacks(*inputs)
        }

        private fun addCallbacks(vararg cells: InputCell) {
            cells.forEach { cell ->
                when (cell) {
                    is ComputeCell -> addCallbacks(*cell.inputs)
                    else -> cell.addCallback {
                        value = compute(inputs.values())
                    }
                }
            }
        }
    }
}

private fun <T> Array<out Reactor<T>.InputCell>.values(): List<T> = this.map { it.value }
