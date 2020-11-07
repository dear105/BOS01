package com.bosssoft.hr.train.collectionframwork;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ListTest {
    public void testArrayList(){
        List list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        System.out.println(list.get(0));
    }
    public void testLinkedList(){
        List list = new LinkedList<Integer>();
        list.add(0, 1);
        list.add(1, 2);
        System.out.println(list.get(1));
    }
    public void testTreeSet(){
        TreeSet set = new TreeSet<Integer>();
        set.add(2);
        set.add(4);
        set.add(6);
        Iterator ite = set.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());
        }
    }
    public void testQueue(){
        Queue<String> queue = new LinkedList<String>();
        queue.offer("a");
        queue.offer("b");
        queue.remove();
        System.out.println(queue.element());
    }
    public void testHashMap(){
        HashMap map = new HashMap<String,Integer>();
        map.put("value", 1);
        map.put("value2", 2);

    }
    public void testTreeMap(){
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("value", 1);
        map.put("value", 2);
        Set<String> keys = map.keySet();
        Iterator<String> ite = keys.iterator();
        while(ite.hasNext()){
            String key = ite.next();
            System.out.println(map.get(key));
        }
    }
    public void testConcurrentHashMap(){
        ConcurrentHashMap map = new ConcurrentHashMap<Integer,Integer>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key + ","+ map.get(key));
            if (key.equals("3")) {
                map.put(key + "key", "3");
            }
        }

    }
}
