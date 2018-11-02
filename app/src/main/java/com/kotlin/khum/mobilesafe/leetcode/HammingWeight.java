package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/17
 *     desc   :
 * </pre>
 */
public class HammingWeight {

    public static void main(String[] arg){
        HammingWeight tool = new HammingWeight();
        tool.binary(1);
    }


    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {



        return 0;
    }

    public void binary(int num){
        int oneNum = 0;
        int isOne;
        for (int i = 32; i > 0; i--) {
            isOne = num>>i &1;
            if (isOne==1) oneNum++;
        }
        System.out.print(oneNum+" ");
    }

}
