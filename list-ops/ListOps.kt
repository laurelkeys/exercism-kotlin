fun <E, R> List<E>.customFoldRight(res: R, f: (E, R) -> R): R =
        if (isEmpty()) res
        else f(first(), drop(1).customFoldRight(res = res, f = f))

tailrec fun <E, R> List<E>.customFoldLeft(acc: R, f: (R, E) -> R): R =
        if (isEmpty()) acc
        else drop(1).customFoldLeft(acc = f(acc, first()), f = f)

val <E> List<E>.customSize: Int
    get() = this.customFoldLeft(acc = 0, f = { acc, _ -> acc + 1 })

fun <E> List<E>.customAppend(other: List<E>): List<E> =
        other.customFoldLeft(acc = this, f = { acc, elem -> acc + elem })

fun <E> List<List<E>>.customConcat(): List<E> =
        this.customFoldLeft(acc = emptyList(), f = { acc, elem -> acc.customAppend(elem) })

fun <E> List<E>.customFilter(f: (E) -> Boolean): List<E> =
        this.customFoldLeft(acc = emptyList(), f = { acc, elem -> if (f(elem)) acc + elem else acc })

fun <E, R> List<E>.customMap(f: (E) -> R): List<R> =
        this.customFoldLeft(acc = emptyList(), f = { acc, elem -> acc + f(elem) })

fun <E> List<E>.customReverse(): List<E> =
        this.customFoldRight(res = emptyList(), f = { elem, res -> res + elem })
