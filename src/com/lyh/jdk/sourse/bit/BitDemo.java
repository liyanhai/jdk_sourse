package com.lyh.jdk.sourse.bit;

/**
 * @author liyanhai
 * @date 2020/7/23 6:30 下午
 */
public class BitDemo {

    public static void main(String[] args) {
        yuOperate();
        huoOperate();
        feiOperate();
        yhOperate();
        leftMove();
        rightMove();
    }

    /**
     * & 与运算
     * 两个操作数中位都为1，结果才为1，否则结果为0
     */
    public static void yuOperate(){
        //01
        int a = 1;
        //111
        int b = 7;
        System.out.println(a & b);
    }

    /**
     * | 或运算
     * 两个位只要有一个为1，那么结果就是1，否则就为0
     */
    public static void huoOperate(){
        //001
        int a = 1;
        //111
        int b = 7;
        System.out.println(a | b);
    }

    /**
     * ~ 非运算 todo....
     */
    public static void feiOperate(){
        //110
        int a = 6;
        System.out.println(~(a));
    }

    /**
     * ^ 异或运算
     */
    public static void yhOperate(){
        //001
        int a = 1;
        //111
        int b = 7;
        System.out.println(a ^ b);
    }

    public static void leftMove(){
        //11 -> 11000 = 24
        //11 -> 110
        int a = 3;
        System.out.println(a << 3);
    }

    public static void rightMove(){
        //11 00011
        int a = 3;
        System.out.println(a >> 3);
        System.out.println(a >>> 3);
    }
}
