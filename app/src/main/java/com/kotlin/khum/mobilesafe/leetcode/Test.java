package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/18
 *     desc   :
 * </pre>
 */
public class Test {

    public static void main(String[] arg){
        Test test = new Test();
//        String result = test.addBinary("1010", "1011");
//        System.out.println(result);

    }


    public String addBinary(String a, String b) {
        char[] chars_a = a.toCharArray();
        char[] chars_b = b.toCharArray();
        int length_a = chars_a.length;
        int length_b = chars_b.length;
        StringBuilder sb = new StringBuilder();
        int temp;
        int up = 0;
        if (length_a>=length_b){
            for(int i = 0; i<length_a; i++){
                if (i<length_b){
                    temp = chars_a[length_a-i-1] + chars_b[length_b-i-1]+up -96;
                    if(temp>=2){
                        up = 1;
                        sb.append(temp-2);
                    }else{
                        up = 0;
                        sb.append(temp);
                    }
                }else{
                    temp = chars_a[length_a-i-1]+up - 48;
                    if(temp>=2){
                        up = 1;
                        sb.append(temp-2);
                    }else{
                        up = 0;
                        sb.append(temp);
                    }
                }
            }
        }else{
            for(int i = 0; i<length_b; i++){
                if (i<length_a){
                    temp = (int)chars_a[length_a-i-1] + (int)chars_b[length_b-i-1]+up -96;
                    if(temp>=2){
                        up = 1;
                        sb.append(0);
                    }else{
                        up = 0;
                        sb.append(temp);
                    }
                }else{
                    temp = (int)chars_b[length_b-i-1]+up- 48;
                    if(temp>=2){
                        up = 1;
                        sb.append(0);
                    }else{
                        up = 0;
                        sb.append(temp);
                    }
                }
            }
        }
        if (up!=0)sb.append(up);
        return sb.reverse().toString();
    }
}
