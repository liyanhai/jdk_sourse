package com.lyh.jdk.sourse.collection.map;

import java.util.*;

/**
 * @author liyanhai
 * @date 2020/7/23 1:02 下午
 */
public class HashMapDemo {

    public static void main(String[] args) {

        //1、创建HashMap时，默认容量16，默认的加载因子0.75,###只初始化了 loadFactor，初始容量
        HashMap<Integer,Integer> map = new HashMap<>();

        HashMap<Integer,Integer> map1 = new HashMap<>(10);

        /**
         * 1、对key进行hash(高低16位做一个异或)，得到hash值
         * 2、若table位null,则进行resize，初始容量 16，初始阈值12，resize方法返回一个新数组
         * 3、hash & (table.length - 1) 得到该key在数组中的index 即 Node node = table[hash & (table.length - 1)];
         * 4、若node为null,则说明key在数组中index位置还没有值，则直接将value放到index位置处 即 tab[index] = newNode(hash, key, value, null);
         * 5、若node不为null，则说明 key在数组中index位置已经有值了
         *      获取到table数组 key对应的桶 e ，这个桶可能是一个链表，也可能是一个树
         *      5.1、先判断e.key是否和要添加的值相等，hash值一致且（要么是同一个key（同一个引用），要么key的值相等）
         *          判断标准(hash一致 && （e.key == key || e.key.equals(key)）)
         *          若满足条件，则说明该key已经在HashMap中，替换key对应节点的value值，并返回老值
         *      5.2、若e是一棵树，树的根节点的key和要添加的key不一致，则将这个要添加的节点插入到树中  即putTreeVal()
         *      5.3、若e是一个链表，遍历这个链表，
         *          5.3.1 如果链表中存在这个key，则替换这个节点对应的value值，并返回旧值
         *          5.3.2 如果链表中不存在这个key，则将这个key,value插入到链表的结尾，在1.8中是尾插法
         *              插入新值之后，判断是否需要树化,判断标准是链表长度 >=8 时,开始进行树化，binCount从0开始
         *              在树化的方法内部，还有一层判断，就是当前table数组的长度若小于64，则进行table的数组，并没有真正的将链表树化
         *              if (binCount >= 8 - 1) // -1 for 1st
         *                             treeifyBin(tab, hash)
         *
         *              treeifyBin(Node<K,V>[] tab, int hash) {
         *                  int n, index; Node<K,V> e
         *                  if (tab == null || (n = tab.length) < 64)
         *                      resize() ==> 先将老数组的长度扩容一倍，先后将老数组中的元素放到新数组中
         *                  else
         *                      链表转树...todo 看源码
         */
//        map.put(1, 1);
//
//        Set<Integer> set = map.keySet();
//        System.out.println(set);
        Map<String,String> keyMap = new HashMap<>();
        keyMap.put("Aa","Aa");
        keyMap.put("BB","BB");
        keyMap.put("三个","三个");
        keyMap.put("上下","上下");
        Set<String> keySet = keyMap.keySet();
        Set<Map.Entry<String, String>> entries = keyMap.entrySet();
        Iterator<String> iterator = keySet.iterator();
        Collection<String> values = keyMap.values();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


}
