package com.kotlin.khum.mobilesafe.bintree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/11/1
 *     desc   :
 * </pre>
 */
public class Traversal {

    public static void main(String[] arg){
        Traversal tool = new Traversal();
        BinTreeNode topNode = createBinTree();
//        tool.preOrderRecursion(topNode);
        tool.preOrder(topNode);
    }

    public static BinTreeNode createBinTree(){
        BinTreeNode f = new BinTreeNode('F', 0, null, null);
        BinTreeNode e = new BinTreeNode('E', 0, null, f);
        BinTreeNode d = new BinTreeNode('D', 0, null, null);
        BinTreeNode b = new BinTreeNode('B', 0, d, e);
        BinTreeNode c = new BinTreeNode('C', 0, null, null);
        BinTreeNode a = new BinTreeNode('A', 0, b, c);
        return a;
    }

    //前序遍历
    private void preOrder(BinTreeNode topNode){
        Stack<BinTreeNode> stack = new Stack<>();
        BinTreeNode p = topNode;
        while (p!=null || !stack.empty()){
            if (p!=null){
                System.out.println(p.data);
                stack.push(p);
                p = p.lChild;
            }else{
                p = stack.pop();
                p = p.rChild;
            }
        }
    }
    //前序遍历
    private void preOrder2(BinTreeNode topNode){
        LinkedList<BinTreeNode> stack = new LinkedList<>();
        BinTreeNode p = topNode;
        while (p!=null || !stack.isEmpty()){
            if (p!=null){
                System.out.println(p.data);
                stack.push(p);
                p = p.lChild;
            }else{
                p = stack.pop();
                p = p.rChild;
            }
        }
    }

    //中序遍历
    private void inOrder(BinTreeNode topNode){
        Stack<BinTreeNode> stack = new Stack<>();
        while (topNode!=null || !stack.empty()){
            if (topNode!=null){
                stack.push(topNode);
                topNode = topNode.lChild;
            }else{
                topNode = stack.pop();
                System.out.println(topNode.data);
                topNode = topNode.rChild;
            }

        }
    }

    //后序遍历
    private void postOrder(BinTreeNode topNode){

    }


    //前序递归
    private void preOrderRecursion(BinTreeNode top){
        if(top!=null){
            System.out.println(top.data);
            preOrderRecursion(top.lChild);
            preOrderRecursion(top.rChild);
        }

    }
    //中序递归
    private void inOrderRecursion(BinTreeNode top){
        if(top!=null){
            System.out.println(top.data);
            inOrderRecursion(top.lChild);
            inOrderRecursion(top.rChild);
        }

    }

    //后序递归
    private void postOrderRecursion(BinTreeNode top){
        if(top!=null){
            System.out.println(top.data);
            postOrderRecursion(top.lChild);
            postOrderRecursion(top.rChild);
        }

    }

}
