// Name: 169. Majority Element
// Difficulty: Easy
// Acceptance rate: 63.8%
// Runtime: Beats 93.19%
// Memory usage: Beats 38.36%

fun majorityElement(nums: IntArray): Int {
    var max = nums[0]
    var maxCount = 1

    for (i in 1 until nums.size) {
        if (nums[i] == max) {
            maxCount++
        } else {
            maxCount--
        }

        if (maxCount == 0) {
            max = nums[i]
            maxCount = 1
        }
    }

    return max
}