// Name: 88. Merge Sorted Array
// Difficulty: Easy
// Acceptance rate: 47.7%
// Runtime: Beats 75.26%
// Memory usage: Beats 5.47%

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var place = m
        for(i in nums2) {
            nums1[place] = i
            place++
        }
        return nums1.sort()
    }
}
