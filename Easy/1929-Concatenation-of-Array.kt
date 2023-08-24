// Name: 1929. Concatenation of Array
// Difficulty: Easy
// Acceptance rate: 89.7%
// Runtime: Beats 71.36%
// Memory usage: Beats 6.57%

class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        var ans = nums
        ans += nums
        return ans
    }
}
