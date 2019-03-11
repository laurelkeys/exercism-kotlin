import Signal.*

object HandshakeCalculator {

    fun calculateHandshake(flags: Int): List<Signal> = mutableListOf<Signal>()
            .apply {
                mapOf<Int, (MutableList<Signal>) -> Unit>(
                        0b00001 to { l -> l.add(WINK) },
                        0b00010 to { l -> l.add(DOUBLE_BLINK) },
                        0b00100 to { l -> l.add(CLOSE_YOUR_EYES) },
                        0b01000 to { l -> l.add(JUMP) },
                        0b10000 to { l -> l.reverse() }
                ).forEach {
                    if (flags.isSet(flag = it.key)) it.value(this)
                }
            }

    private fun Int.isSet(flag: Int) = (this and flag) == flag
}