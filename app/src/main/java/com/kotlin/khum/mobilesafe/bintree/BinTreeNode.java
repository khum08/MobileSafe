package com.kotlin.khum.mobilesafe.bintree;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/11/1
 *     desc   : 二叉树节点
 * </pre>
 */
public class BinTreeNode {

    BinTreeNode lChild, rChild;
    char data;
    int flag;
    BinTreeNode(char data, int flag, BinTreeNode lChild, BinTreeNode rChild){
        this.data = data;
        this.flag = flag;
        this.lChild = lChild;
        this.rChild = rChild;
    }

}
