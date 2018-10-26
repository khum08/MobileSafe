package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/16
 *     desc   :
 * </pre>
 */
public class AddTwoNumber {

    public static void main(String[] arg){
        AddTwoNumber add = new AddTwoNumber();
        ListNode node1 = add.parseLink(123);
        ListNode node2 = add.parseLink(113);
        ListNode result = add.addTwoNumbers(node1, node2);
        System.out.println("result:"+add.getInt(result));
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        traversal(sb1, l1);
        String str1 = sb1.toString();
        StringBuilder sb2 = new StringBuilder();
        traversal(sb2, l2);
        String str2 = sb2.toString();
        int int1 = getInt(str1);
        int int2 = getInt(str2);
        int result = int1 + int2;
        return parseLink(result);
    }

    public void traversal(StringBuilder sb, ListNode node){
        sb.append(node.val);
//        System.out.println(node.val+":");
        if (node.next!=null){
            traversal(sb, node.next);
        }
    }

    public int getInt(String s){
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = chars.length-1; i>=0; i--){
            sb.append(chars[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    public int getInt(ListNode ln){
        StringBuilder sb2 = new StringBuilder();
        traversal(sb2, ln);
        String str2 = sb2.toString();
        return getInt(str2);
    }

    public ListNode parseLink(int result){
        char[] chars = String.valueOf(result).toCharArray();
//        System.out.println(chars);
//        System.out.println();
        ListNode lastNode = null;
        ListNode first = null;
        for(int i = chars.length - 1; i>=0; i--){
//            System.out.println(chars[i]);
            ListNode next = new ListNode(chars[i]-48);
            if(lastNode!=null){
                lastNode.next = next;
            }else{
                first = next;
            }
            lastNode = next;
        }
        return first;
    }

}
