package com.lyh.jdk.sourse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author liyanhai
 * @date 2020/7/23 6:14 下午
 */
public class MainTest {

    public static void main(String[] args) {

    }

    public static int hash(String key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
