package io.github.ifanzero.test

import io.github.ifanzero.method.RomanToInt_13_S
import io.github.ifanzero.method.longest_common_prefix_14_S
import io.github.ifanzero.method.threeSum_15

class Solution {


    fun romanToInt(s: String): Int {
        return RomanToInt_13_S.romanToInt(s)
    }

    /**
     * https://leetcode-cn.com/problems/longest-common-prefix/description/
     * @param strs
     * @return
     */
    fun longestCommonPrefix(strs: Array<String>): String {
        return longest_common_prefix_14_S.longestCommonPrefix1(strs)
    }

    fun threeSum(nums: IntArray): List<List<Int>>? {
        return threeSum_15.threeSum(nums)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            println(solution.romanToInt("MCMXCIV"))
            println(solution.longestCommonPrefix(arrayOf("flower", "flow", "flight")))
        }
    }
}
