package com.ciberaccion.ipk.hashmaps;

public class TwoStrings {

    public static void main(String[] args) {
        String s1 = "alfonso";
        String s2 = "al";
        System.out.println(Result2.twoStrings(s1,s2));
    }
}

class Result2 {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) {
        // Write your code here
        boolean flag = false;
        for (int i = 0; i < s1.length(); i++) {
            char curremt = s1.charAt(i);
            if(s2.contains(String.valueOf(curremt))){
                flag = true;
                break;
            }
        }
        if (flag)
            return "YES";
        else
            return "NO";
    }

}

