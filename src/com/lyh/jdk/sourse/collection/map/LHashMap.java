package com.lyh.jdk.sourse.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author liyanhai
 * @date 2020/7/29 2:36 下午
 */
public class LHashMap {

    public static void main(String[] args) {

        /**
         * 源码分析参考
         * https://segmentfault.com/a/1190000012964859
         */

//        LinkedHashMap<Integer,Integer> hashMap = new LinkedHashMap<>();
//        hashMap.put(1,1);
//        hashMap.put(2,2);
//        hashMap.put(3,3);
//
//        hashMap.remove(1);
//        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
//        for(Map.Entry<Integer, Integer> entry : entries){
//            System.out.println(entry.getKey());
//        }
        LinkedHashMap<Integer,Integer> hashMap = new LinkedHashMap<Integer, Integer>(3,0.75f,true);

        hashMap.put(1,1);
        hashMap.put(2,2);
        hashMap.put(3,3);
        hashMap.put(4,4);
//        Set<Integer> set = hashMap.keySet();
//        System.out.println(set);
//        Integer integer = hashMap.get(3);
//        System.out.println(set);

    }

}
