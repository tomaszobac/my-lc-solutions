// Name: 338. Counting Bits
// Difficulty: Easy
// Acceptance rate: 76.9%
// Runtime: Beats 5.07%
// Memory usage: Beats 5.07%

fun countBits(n: Int): IntArray {
    var arr = intArrayOf(0)

    for (i in 1..n) {
        arr += getBinaryOnes(i)
    }

    return arr
}

fun getBinaryOnes(number: Int): Int {
    var count = 0
    var result = number

    while (result != 0) {
        count += result % 2
        result /= 2
    }

    return count
}
