package com.kotlin.khum.mobilesafe.leetcode;

import java.util.HashSet;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/11/5
 *     desc   :
 * </pre>
 */
public class DeleteDuplicates {

    public static void main(String[] arg){
        DeleteDuplicates tool = new DeleteDuplicates();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode lx = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = lx;
        lx.next = l3;
        l3.next = l4;
        l4.next = l5;
        traversal(l1);
        ListNode listNode = tool.deleteDuplicates(l1);
        traversal(listNode);
    }

    private static void traversal (ListNode node){
        if (node==null) return;
        System.out.println(node.val);
        traversal(node.next);
    }

    private ListNode deleteDuplicates(ListNode head){
        HashSet<Integer> set = new HashSet<>();
        int val;
        ListNode previous = head;
        ListNode current = head;
        ListNode next = head.next;
        while (current != null){
            val = current.val;
            if (set.contains(val)){
                previous.next = next;
                current = next;
                if (next !=null ||next.next!=null)
                next = next.next;
            }else{
                set.add(val);
                if (next == null)
                    return head;
                previous = current;
                current = next;
                next = next.next;
            }
        }
        return head;
    }
}
