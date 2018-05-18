package io.github.ifanzero.method.S_136_singleNumber;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Ifan
 * @url https://leetcode-cn.com/problems/single-number
 */
public class singleNumber {
    public int singleNumber(int[] nums) {
        int length = nums.length;
        if (length==1){
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0; i < length - 1; i++) {
            if (i == 0 && nums[i] != nums[i + 1]) {
                return nums[i];
            } else if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                return nums[i];
            } else if (i+1==length-1&&nums[i+1]!=nums[i]){
                return nums[i+1];
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int i = singleNumber(new int[]{4, 1, 2, 1, 2});
        System.out.println(i);
    }
}
