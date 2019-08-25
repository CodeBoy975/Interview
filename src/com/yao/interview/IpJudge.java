package com.yao.interview;

/**
 * 描述： 判断输入的字符串是否是ip地址
 *  *
 * @author pengjie_yao
 * @date 2019/8/22 8:44
 */
public class IpJudge {

    public static void main(String[] args) {
        String ips = "192.169.0.251";
        System.out.printf(isIp(ips).toString());

    }


    /**
     * 判断是否是ip地址
     *
     * @return
     */
    public static Boolean isIp(String ip) {
        // 1.判断长度是否符合0.0.0.0 - 000.000.000.000
        if (ip.length() < 7 || ip.length() > 15) {
            return false;
        }
        // 2.将长度拆分为数组，并判断是否数组长度为4，不是则返回
        String[] ips = ip.split("\\.");
        if (ips.length != 4) {
            return false;
        }
        // 3.判断每个字符串是否是数字，不是则返回
        for (int i = 0; i < ips.length; i++) {
            // 拆分出每个数字
            char[] numbers = ips[i].toCharArray();
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] < '0' || numbers[j] > '9') {
                    return false;
                }
            }
        }
        // 4.将数组的字符串转为数字，判断范围是否是0-255

        for (int i = 0; i < ips.length; i++) {
            int temp = Integer.parseInt(ips[i]);
            if (temp < 0 || temp > 255) {
                return  false;
            }
        }
        return true;
    }

}
