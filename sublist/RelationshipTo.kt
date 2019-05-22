import Relationship.EQUAL
import Relationship.SUBLIST
import Relationship.SUPERLIST
import Relationship.UNEQUAL

fun <E> List<E>.relationshipTo(other: List<E>): Relationship {
    return when {
        size > other.size -> if (other.isSublist(this)) SUPERLIST else UNEQUAL
        size < other.size -> if (this.isSublist(other)) SUBLIST else UNEQUAL
        else -> if (this == other) EQUAL else UNEQUAL
    }
}

private fun <E> List<E>.isSublist(other: List<E>): Boolean {
    return size < other.size && (this.isEmpty() || other.windowed(size, step = 1).any { it == this })
}
