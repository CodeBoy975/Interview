package com.yao.interview;

/**
 * 描述： 最小台阶数
 *
 * 题目：
 *     如果每次走2步，最后剩下1步
 *     如果每次走3步，最后剩下2步
 *     如果每次走4步，最后剩下3步
 *     如果每次走5步，最后剩下4步
 *     如果每次走6步，最后剩下5步
 *  如果每次走7步，刚好走完
 * @author pengjie_yao
 * @date 2019/8/20 22:11
 */
public class StepMinLength {


    /**
     *  最小的台阶数
     * @return
     */
    public static String stepMinLength(){
        int i=1;
        int sum = 7;
        while (true) {
            sum = sum+7;
            if ((1 == sum % 2) && (2 == sum % 3) && (3 == sum % 4) && (4 == sum % 5)  && (5 == sum%6) && (0 == sum%7)) {
                System.out.println(sum);
                break;
            }
        }

        return sum+"步";
    }

    public static void main(String[] args) {
        stepMinLength();
    }

}
