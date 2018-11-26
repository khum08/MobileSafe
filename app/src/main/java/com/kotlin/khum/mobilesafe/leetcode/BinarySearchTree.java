package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     desc   : 二叉查找树/BST
 * </pre>
 */
public class BinarySearchTree {

    public static void main(String[] arg){
        BinarySearchTree tool = new BinarySearchTree();
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        n6.left = n4;
        n6.right = n7;
        n4.left = n2;
        n4.right = n5;
        n2.right = n3;
        n7.right = n9;
        n9.left = n8;
        n9.right = n10;
        tool.inOrderTraversal(n6);
    }

    //中序遍历
    private void inOrderTraversal(Node node){
        if (node != null){
            inOrderTraversal(node.left);
            System.out.println(node.val);
            inOrderTraversal(node.right);
        }
    }

    private Node tree;//根节点

    //删除
    public void delete(int value){
        Node temp = tree;
        Node pp = null;
        while (temp !=null && temp.val != value){
            pp = temp;
            if (value > temp.val){
                temp = temp.right;
            }else if (value < temp.val){
                temp = temp.left;
            }
        }
        if (temp == null){
            return;//没有找到
        }

        //1.待删除的节点有两个子节点
        if (temp.left != null && temp.right != null){
            Node minP = temp.right;
            Node minPP = temp;
            while(minP.left!=null){
                minPP = minP;
                minP = minP.left;
            }
            temp.val = minP.val;
            minPP.left = null;
        }
        //2.待删除的节点只有一个子节点
        if (temp.left != null || temp.right !=null){
            Node child = temp.left==null? temp.right: temp.left;
            if (value > pp.val) pp.right = child;
            else pp.left = child;
        }

        //3.待删除的节点没有子节点
        if (temp.left == null && temp.right == null){
            if (pp.left == temp ) pp.left = null;
            else pp.right = null;
        }
    }

    //插入
    public void insert(int value){
        Node insert = new Node(value);
        if (tree == null) {
            tree = insert;
            return;
        }
        Node r = tree;
        Node p = tree;
        while(r != null){
            p = r;
            if (value > r.val){
                r = r.right;
            }else{
                r = r.left;
            }
        }
        if (value > p.val){
            p.right = insert;
        }else{
            p.left = insert;
        }
    }

    //递归查找
    public Node find(Node tree, int value){
        if (tree == null){
            return null;
        }
        if (tree.val > value){
            return find(tree.left, value);
        }else if (tree.val < value){
            return find(tree.right, value);
        }else{
            return tree;
        }
    }

    //循环查找
    public Node find(int value){
        Node p = tree;
        while (p != null){
            if (p.val > value){
                p = p.left;
            }else if (p.val < value){
                p = p.right;
            }else{
                return p;
            }
        }
        return null;
    }

    //节点类
    static class Node{
        Node left;
        Node right;
        int val;
        public Node(int value){
            this.val = value;
        }
    }
}
