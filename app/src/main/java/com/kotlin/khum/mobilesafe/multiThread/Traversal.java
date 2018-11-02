package com.kotlin.khum.mobilesafe.multiThread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/16
 *     desc   :
 * </pre>
 */
public class Traversal {

    public static void main(String[] arg){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        Iterator<String> iterator = list.iterator();
        String next;
        while (iterator.hasNext()){
            next = iterator.next();
            if (next.equals("C")){
                iterator.remove();
            }else{
                System.out.println(next);
            }
        }

    }

}
