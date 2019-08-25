package com.yao.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 描述： 求众数 : 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * @author pengjie_yao
 * @date 2019/7/28 17:19
 */
public class MajorityElement {

    public static void main(String[] args) {

        int[] nums = new int[]{1};

        System.out.println(majorityElement(nums));
    }

    // 1 hashmap进行统计每个数字出现的次数，每次加入的数据大于n/2则的数据，则返回

    /**
     * Map解法
     *   时间复杂度：O(n)  空间复杂度为O(n)
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return nums[0];
        }
        int result = 0;
        // 1. 定义hashmap，key为每个数字，val为出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        // 2. 遍历数组元素，加入hashmap并判断
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            // 3. map中如果有该元素，进行次数相加
            if(map.get(nums[i])!=null) {
                count = map.get(nums[i]);
                 count++;
                map.put(nums[i], count);
                // 如果次数大于n/2,则返回结果
                if (count > (nums.length>>1)) {
                    result =  nums[i];
                }
            }else {
                // 元素放入map中
                count++;
                map.put(nums[i], count);
            }
        }
        return result;
    }

    /**
     *  选举人算法实现
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {


        // 1 设置一个为候选人,一个为计数器
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            // 如果投票次数为0，则换人投票
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (candidate == nums[i]) {
                // 如果找到自己，则投票器加1
                count++;
            }else {
                // 不是自己人，则投票数-1
                count--;
            }
        }

        return candidate;
    }

   /* public static int majorityElement(int[] nums) {


        // 1. 排序
        Arrays.sort(nums);

        // 2.
        return  1;
    }*/
}
