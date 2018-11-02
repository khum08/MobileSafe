package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/17
 *     desc   :
 * </pre>
 */
public class MergeTwoLists {

    public static void main(String[] arg){
        AddTwoNumber tool = new AddTwoNumber();
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode l1 = tool.parseLink(347);
        ListNode l2 = tool.parseLink(235);
        MergeTwoLists merge = new MergeTwoLists();
        ListNode result = merge.mergeTwoLists(l1, l2);
        int anInt = tool.getInt(result);
        System.out.println(anInt);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        int v1 = l1.val;
        int v2 = l2.val;
        ListNode result = l1;
        ListNode currentl1 = null;
        ListNode next2 = null;
        ListNode next1 = l1;
        if (v2<=v1){
            next2 = l2.next;
            currentl1 = l2;
            next1 = currentl1;
            l1 = l2;
            v1 = v2;
            v2 = next2.val;
        }else{
            l1 = next1;
            next1 = l1.next;
            v1 = next1.val;
        }
        return result;
    }

}
