package com.lyh.jdk.sourse.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author liyanhai
 * @date 2020/7/30 5:08 下午
 */
public class ArrList {

    public static void main(String[] args) {

//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        ArrayList list1 = new ArrayList(list);
//        list.add(0,10);
//
//        Integer [] arr = {1,2,3,4,5,6};
//        Integer[] arr1 = Arrays.copyOf(arr, 3);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr1));
        String str = "我是中国人";
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));

        ArrayList<String> list = new ArrayList<>();
        list.add("12345");

        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.add(1);
        hashSet.add(2);

        for(Integer i : hashSet){
            System.out.println(i);
        }


    }

}
