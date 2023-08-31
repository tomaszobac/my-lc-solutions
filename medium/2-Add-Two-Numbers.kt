// Name: 2. Add Two Numbers
// Difficulty: Medium
// Acceptance rate: 41.1%
// Runtime: Beats 35.39%
// Memory usage: Beats 5.18%

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var current1 = l1
    var current2 = l2
    var number1: String = ""
    var number2: String = ""

    while (current1 != null || current2 != null) {
        if (current1 != null) {
            number1 += current1.`val`
            current1 = current1.next
        }
        if (current2 != null) {
            number2 += current2.`val`
            current2 = current2.next
        }
    }

    val sum = (number1.reversed().toBigInteger() + number2.reversed().toBigInteger()).toString()

    val result = ListNode(sum.reversed()[0].digitToInt())
    var current = result

    for (i in 1..<sum.length) {
        current.next = ListNode(sum.reversed()[i].digitToInt())
        current = current.next!!
    }

    return result
}