// Name: 26. Remove Duplicates from Sorted Array
// Difficulty: Easy
// Acceptance rate: 52.8%
// Runtime: Beats 87.71%
// Memory usage: Beats 65.63%

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var position = 0
        var contained = emptyArray<Int>()
        
        nums.forEach{ 
            if (it !in contained) {
                nums[position++] = it
                contained += it
            }
        }

        return position
    }
}
