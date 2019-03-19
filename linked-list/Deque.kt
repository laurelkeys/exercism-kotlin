class Deque<T> {

    private var first: Node<T>? = null
    private var last: Node<T>? = null

    private class Node<T>(var value: T, var next: Node<T>?, var prev: Node<T>?) {
        constructor(value: T) : this(value, null, null)
    }

    // insert value at back
    fun push(value: T) {
        last.let { penultimate ->
            last = Node(value).also { it.prev = penultimate }
            penultimate?.next = last
            if (first == null) first = last
        }
    }

    // remove value at back
    fun pop(): T? = last.let { oldLast ->
        if (first == oldLast) first = null
        last = last?.prev
        last?.next = null
        oldLast?.value
    }

    // remove value at front
    fun shift(): T? = first.let { oldFirst ->
        if (last == oldFirst) last = null
        first = first?.next
        first?.prev = null
        oldFirst?.value
    }

    // insert value at front
    fun unshift(value: T) {
        first.let { second ->
            first = Node(value).also { it.next = second }
            second?.prev = first
            if (last == null) last = first
        }
    }
}