package com.demo.precision;

import java.math.BigDecimal;

/**
 * @author Jeanne 2023/9/5
 * https://mp.weixin.qq.com/s/UyYDt3HB8IO_AoSDLndhxA
 * https://zhuanlan.zhihu.com/p/137616403
 **/
public class FloatingPointPrecision {
    public static void main(String[] args) {
//        testDivide2();
        test2();
//        test1();
    }

    public static void testDivide2() {
        BigDecimal[] nums = new BigDecimal[52];
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 1; i < 53; i++) {
            nums[i-1] = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(Math.pow(2, i)));
            total = total.add( nums[i-1]);
            System.out.println(
                    String.format("total: %s, current: %s",total, nums[i-1] ));
        }


    }

    public static void test2() {
        /**
         * 0011111111100000000000000000000000000000000000000000000000000000
         * +|   511  |  0                                                  |
         * 1*(1+0)*2^(511-512) = 0.5
         */
//        printDoubleBinary(0.5);
        /**
         * 1011111111100000000000000000000000000000000000000000000000000000
         * -|   511  |  0                                                  |
         * -1*(1+0)*2^(511-512) = -0.5
         */
//        printDoubleBinary(-0.5);
        /**
         * 0000000000000000000000000000000000000000000000000000000000000000
         * +|    0   |  0                                                  |
         * 1*(1+0)*2^(0-512) = -0.5
         */
//        printDoubleBinary(0);

        /**
         * 0011111111101100000000000000000000000000000000000000000000000000
         * +|   511  |  0                                                  |
         * 1*(1+1/2+1/4)*2^(511-512) =7/4*1/2=7/8=0.875
         */
//        printDoubleBinary(0.875);
        /**
         * 00100000000011001011100001010001111010111000010100011110101110001
         * +|   256  |  0                                                  |
         * 1*(1+1/4+1/8+1/64+...)*2^(256-512) = 算不过来了
         */
        printDoubleBinary(6.36);

    }

    public static void printDoubleBinary(double number) {
        long bits = Double.doubleToLongBits(number);
        String binary = Long.toBinaryString(bits);
        System.out.println(binary);
    }

    public static void test1() {
        double num1 = 0.1;
        double num2 = 0.2;
        double sum = num1 + num2;

        System.out.println("Sum: " + sum);

        if (sum == 0.3) {
            System.out.println("The sum is equal to 0.3");
        } else {
            System.out.println("The sum is not equal to 0.3");
        }
    }

}