package com.ciberaccion.certify;

public class Test {

    public static void main(String[] args) {
        String str = "({)}";
//        ((()))
//        ({}{})
//        ({)})
//        }{
//        )(
//        )()
//        ({)}
        String result = Test.isBalanced(str);
        System.out.println(result);
    }

    /**
     * My strategy: First test case check for even {} and even () other case return false
     * second test case if first character is ) or } or last character is { or ( then return false
     * third test case if closing parenthesis is after opening curly brace then return false, check same backwards
     * @param s
     * @return
     */
    static String isBalanced(String s)
    {
        int bracketsOpen=0, bracketsClose=0;
        int parenthesisOpen=0, parenthesisClose=0; char cc=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( i<=s.length()-2)
                cc = s.charAt(i+1);
            if (c == '{') bracketsOpen++;
            if (c == '}') bracketsClose++;
            if (c == '(') parenthesisOpen++;
            if (c == ')') parenthesisClose++;
            if (i==0 && (c == ')' || c=='}')) break;
            if (i==s.length()-1 && (c == '(' || c=='{')) break;
            if ((c == '{') && (cc ==')')) break;
            if ((c == '(') && (cc =='}')) break;
        }
        if ((bracketsOpen == bracketsClose) && (parenthesisOpen == parenthesisClose))
            return "true";
        else
            return "false";
        /* here ***** */
        /*


         //
         */
    }
}
