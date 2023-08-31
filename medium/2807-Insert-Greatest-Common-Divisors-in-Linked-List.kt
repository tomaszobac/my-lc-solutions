// Name: 2807. Insert Greatest Common Divisors in Linked List
// Difficulty: Medium
// Acceptance rate: 89.9%
// Runtime: Beats 7.32%
// Memory usage: Beats 6.10%

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
    var current = head

    while (current != null && current.next != null) {
        val next = current.next
        current.next = ListNode(findGCD(current.`val`, current.next!!.`val`))
        current.next!!.next = next

        current = current.next!!.next
    }

    return head
}

fun findGCD(first: Int, second: Int): Int {
    var smaller = 0
    var gcd = 1
    if (first > second) smaller = second else smaller = first
    for (i in 2..smaller) {
        if (first % i == 0 && second % i == 0) {
            gcd = i
        }
    }
    return gcd
}