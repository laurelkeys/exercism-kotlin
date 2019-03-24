class PhoneNumber(phoneNumber: String) {

    val number = phoneNumber
            .takeIf { it.all { d -> validDigit(d) } }
            ?.filter { it.isDigit() }
            ?.takeIf { validCountryCode(it) }
            ?.withoutCountryCode
            ?.takeIf {
                it.length == 10
                        && validAreaCode(it.slice(0..2))
                        && validExchangeCode(it.slice(3..5))
            }

    private val String.withoutCountryCode
        get() = let {
            if (it.length == 11 && it[0] == '1') it.drop(1) else it
        }

    private fun validDigit(digit: Char) =
            digit.isDigit() || digit in "+()-. "

    private fun validCountryCode(phoneNumber: String) =
            if (phoneNumber.length == 11) phoneNumber[0] == '1' else true

    private fun validAreaCode(areaCode: String) =
            areaCode.length == 3 && areaCode[0] !in "01"

    private fun validExchangeCode(exchangeCode: String) =
            exchangeCode.length == 3 && exchangeCode[0] !in "01"
}