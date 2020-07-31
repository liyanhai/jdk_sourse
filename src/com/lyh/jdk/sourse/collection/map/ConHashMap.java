package com.lyh.jdk.sourse.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyanhai
 * @date 2020/7/30 6:34 下午
 */
public class ConHashMap {

    public static void main(String[] args) {

        ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<Integer, Integer>(10);

        map.put(1,1);

        System.out.println(map);

        HashMap<Integer,Integer> map1 = new HashMap<>();
        map1.put(1,1);
    }

}
