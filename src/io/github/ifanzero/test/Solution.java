package io.github.ifanzero.test;

import io.github.ifanzero.method.RomanToInt_13_S;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }


    public int romanToInt(String s) {
        return RomanToInt_13_S.romanToInt(s);
    }
}
