package io.github.ifanzero.method.M_16_threeSumClosest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ifan
 * @url https://leetcode-cn.com/problems/3sum-closest
 */
public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list= new ArrayList<>();
        int mid,right;
        //left只用循环所有的非正数就行了（不是负数是因为还要考虑[0 0 0]的情况所以是非正数）
        int temp=Integer.MAX_VALUE;
        int finalTarget=0;
        for (int left = 0; left < nums.length-2; left++) {
            mid = left+1; right = nums.length-1;
            int tmp = target-nums[left];
            //跳过left重复匹配
            /*if(left > 0 && nums[left] == nums[left-1])
                continue;*/

            while(mid < right)
            {
                if(nums[mid] + nums[right] == tmp)
                {
                   return target;
                }
                else if(nums[mid] + nums[right] < tmp) {
                    int i = tmp-(nums[mid] + nums[right]);
                    if (i<temp){
                        finalTarget = nums[mid] + nums[right]+nums[left];
                        temp =i;
                    }
                    mid++;
                }
                else{
                    int i = nums[mid] + nums[right] - tmp;
                    if (i<temp){
                        finalTarget = nums[mid] + nums[right]+nums[left];
                        temp =i;
                    }
                    right--;
                }
            }
        }
        return finalTarget;

    }

    @Test
    public void test(){
       int i= threeSumClosest(new int[]{-1,2,1,-4},1);
        System.out.println(i);
    }
}
