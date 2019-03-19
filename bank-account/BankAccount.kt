class BankAccount {

    private var closed = false

    var balance: Int = 0
        private set
        get() {
            check(!closed)
            return field
        }

    fun adjustBalance(value: Int) {
        synchronized(this) {
            check(!closed)
            balance += value
        }
    }

    fun close() {
        closed = true
    }
}