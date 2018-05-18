package io.github.ifanzero.test

import io.github.ifanzero.method.S_13_RomanToInt.RomanToInt
import io.github.ifanzero.method.S_14_longest_common_prefix.longest_common_prefix
import io.github.ifanzero.method.M_15_threeSum.threeSum

class Solution {


    fun romanToInt(s: String): Int {
        return RomanToInt.romanToInt(s)
    }

    /**
     * https://leetcode-cn.com/problems/longest-common-prefix/description/
     * @param strs
     * @return
     */
    fun longestCommonPrefix(strs: Array<String>): String {
        return longest_common_prefix.longestCommonPrefix1(strs)
    }

    fun threeSum(nums: IntArray): List<List<Int>>? {
        return threeSum.threeSum(nums)
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
