package com.ciberaccion.ipk.string.alternating;

public class Solution {

    public static void main(String[] args) {
//        String word= "AAAA";    //3
//        String word= "BBBBB";     //4
        String word= "ABABABAB";  //0
//        String word= "BABABA";    //0
//        String word= "AAABBB";    //4

        int result = Result.alternatingCharacters(word);
        System.out.println(result);
    }
}

class Result{
    public static int alternatingCharacters(String s) {
        // Write your code here
        int deletions=0;
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i)==s.charAt(i+1)){
                deletions++;
            }
        }
        return deletions;
    }
}
