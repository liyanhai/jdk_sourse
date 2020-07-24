package com.lyh.jdk.sourse;

/**
 * @author liyanhai
 * @date 2020/7/23 6:14 下午
 */
public class MainTest {

    public static void main(String[] args) {

        for (int count = 0; ; count++) {

            System.out.println(count);


        }

    }

    public static int hash(String key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
