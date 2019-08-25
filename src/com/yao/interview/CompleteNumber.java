package com.yao.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述： 找出1000以内的完数
 *
 * @author pengjie_yao
 * @date 2019/8/16 9:56
 */
public class CompleteNumber {

    public static void main(String[] args) {

        // 1.遍历
        for (int i = 1; i < 1000; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                // 2.如果该数是它的因子，则取余会等于0,
                if (i % j == 0) {
                    sum = sum + j;
                }
            }
            // 3.判断相加之后是否等于该整数，是的话，输出符合的数字
            if (sum == i) {
                System.out.print(sum+" ");
            }
        }
    }



}
