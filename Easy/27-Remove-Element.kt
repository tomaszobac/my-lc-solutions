// Name: 27. Remove Element
// Difficulty: Easy
// Acceptance rate: 54.3%
// Runtime: Beats 53.88%
// Memory usage: Beats 33.97%
// Not proud of this one

fun removeElement(nums: IntArray, `val`: Int): Int {
    var elements = 0
    var index = 0

    nums.forEach{if (it != `val`) elements++}

    for (num in nums.indices) {
        if (nums[num] == `val`) {
            while (nums[index] == `val`) {
                if (index >= nums.size - 1) break
                index++
            }
            nums[num] = nums[index]
            nums[index] = `val`
            continue
        }
        index++
    }
    return elements
}
