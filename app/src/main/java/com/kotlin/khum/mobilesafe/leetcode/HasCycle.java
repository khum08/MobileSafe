package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     desc   : 给定一个链表，判断链表中是否有环。141
 * </pre>
 */
public class HasCycle {

    public static void main(String[] arg){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n1.next.next = n3;
        n1.next.next.next = n4;
        n1.next.next.next.next = n5;

//        n1.next.next.next.next.next = n1;
        HasCycle hasCycle = new HasCycle();
//        boolean have = hasCycle.hasCycle(n1);
//        System.out.println(have);
        ListNode result = hasCycle.removeNthFromEnd(n1, 2);
        hasCycle.print(n1);
        System.out.println();
        hasCycle.print(result);
    }

    public boolean hasCycle(ListNode head) {
        if (head==null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    //给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        int i = 0;
        while(fast!=null && i< n){
            fast = fast.next;
            i++;
        }
        if(fast==null) return head;
        ListNode slow = head;
        ListNode pre = slow;
        ListNode result = slow;
        while(fast!=null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre==null){
            result=result.next;
        }else{
            pre.next = pre.next.next;
        }
        return result;
    }

    private void print(ListNode node){
        if (node==null) return;
        System.out.println(node.val);
        print(node.next);
    }
}
