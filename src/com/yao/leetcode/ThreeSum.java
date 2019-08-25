package com.yao.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 描述： 三数之和
 * 题目：
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author pengjie_yao
 * @date 2019/7/23 19:21
 */
public class ThreeSum {


    public static void main(String[] args) {

        int[] array = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] array = new int[]{0, 0, 0, 0};

        List<List<Integer>> lists = threeSum(array);
        System.out.println(lists.toString());
    }

    /**
     * 思路：
     *      1 先排序
     *      2 对数组进行排序O(nlogn)
     *      3 遍历，用map来保留a+b的值，然后查找对应c值，时间复制度为O(n^2)
     * 整体时间复杂度为：O(n^2)
     * 空间复杂度为： O(n)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        // 1 判空
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        // 2 对数组进行排序,为了进行判断是否重复
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 重复元素的判断
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 3. 用map：key存储要找的-c,val存储数组
            HashMap<Integer, ArrayList> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(nums[j])) {
                    // 找到a+b+c=0
                    ArrayList arrayList = map.get(nums[j]);
                    // 4. 判断结果集合中是否有相同的数组，没有才放入结果集
                    if (!resultList.contains(arrayList)) {
                        arrayList.add(nums[j]);
                        resultList.add(arrayList);
                    }
                } else {
                    // 放入map
                    ArrayList arrayList = new ArrayList();
                    int c = nums[i] + nums[j];
                    arrayList.add(nums[i]);
                    arrayList.add(nums[j]);
                    // a+b+c = 0 等价于 a+b = -c,则我们把-c放入，比如a+b=1+2=3，则c应该是-3
                    map.put(-c, arrayList);
                }
            }
        }
        return resultList;
    }

    /**
     * 使用左右指针方式
     * 步骤：
     * 1 先排序
     * 2 遍历，设置左右指针进行夹逼准则往中间靠拢
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {

        final int ZERO = 0;
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        // 1 先排序
        Arrays.sort(nums);
        // 2 遍历
        for (int i = 0; i < nums.length; i++) {
            // 3 设置左右指针，以第一个元素为c，然后左指针为a，右指针为b
            int left = i + 1;
            int right = nums.length - 1;
            // 去重复的元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                // 保留总数
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == ZERO) {
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 进行重复的判断
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 指针移动
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    // 如果c + a + b > 0，则表示加的数大了，则b要往左靠拢
                    right--;
                } else {
                    // 如果c + a + b < 0,则表示减的数大了，则a要往左边靠拢
                    left++;
                }
            }
        }
        return resultList;
    }
}
