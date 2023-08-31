// Name: 1. Two Sum
// Difficulty: Easy
// Acceptance rate: 50.5%
// Runtime: Beats 43.03%
// Memory usage: Beats 39.17%

fun twoSum(nums: IntArray, target: Int): IntArray {
    for (i in 0 until nums.size) {
        for (n in i until nums.size) {
            if (nums[i]+nums[n] == target && i != n) return intArrayOf(i,n)
        }
    }
    return intArrayOf()
}