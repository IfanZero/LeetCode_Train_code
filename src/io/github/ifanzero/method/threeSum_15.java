package io.github.ifanzero.method;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum_15 {

    @Test
    public void test(){
        List<List<Integer>> lists = threeSum_15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list= new ArrayList<>();
        int mid,right;
        //left只用循环所有的非正数就行了（不是负数是因为还要考虑[0 0 0]的情况所以是非正数）
        for (int left = 0; left < nums.length && nums[left] <= 0; left++) {
            mid = left+1; right = nums.length-1;
            int tmp = 0-nums[left];
            //跳过left重复匹配
            if(left > 0 && nums[left] == nums[left-1])
                continue;
            while(mid < right)
            {
                if(nums[mid] + nums[right] == tmp)
                {
                    int tmp_mid = nums[mid],tmp_right= nums[right];
                    list.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    //跳过right和mid的重复匹配
                    while(mid < right && nums[++mid] == tmp_mid);
                    while(mid < right && nums[--right] == tmp_right);
                }
                else if(nums[mid] + nums[right] < tmp)
                    mid++;
                else
                    right--;
            }
        }
        return list;
    }

}