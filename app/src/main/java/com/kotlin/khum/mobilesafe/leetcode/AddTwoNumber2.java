package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/16
 *     desc   :
 * </pre>
 */
public class AddTwoNumber2 {

    public static void main(String[] arg){
        AddTwoNumber2 test = new AddTwoNumber2();
        AddTwoNumber num = new AddTwoNumber();
        ListNode node1 = num.parseLink(15);
        ListNode node2 = num.parseLink(17);
        ListNode listNode = test.addTwoNumbers(node1, node2);

        System.out.println(num.getInt(num.addTwoNumbers(node1, node2)));
        System.out.println(num.getInt(listNode));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        link(l1, l2);
        return first;
    }

    private void link(ListNode l1, ListNode l2){
        if (l1!=null){
            n1 = l1.val;
            n1Next = l1.next;
            sum += n1;
        }
        if (l2!=null){
            n2 = l2.val;
            n2Next = l2.next;
            sum += n2;
        }
        sum += nextAdd;
        if (sum>=10){
            nextAdd = 1;
            val = sum-10;
        }else{
            nextAdd = 0;
            val = sum;
        }
        sum = 0;
        ListNode next = new ListNode(val);
        if (first == null){
            first = next;
            lastNode = next;
        }else{
            lastNode.next = next;
            lastNode = next;
        }
        if (n1Next!=null || n2Next!=null || nextAdd!=0){
            addTwoNumbers(n1Next, n2Next);
        }
    }

    ListNode lastNode = null;
    ListNode first = null;
    ListNode n1Next = null;
    int n1;
    ListNode n2Next = null;
    int n2;
    int val;
    int nextAdd;
    int sum;



}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
