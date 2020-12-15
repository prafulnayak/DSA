package org.sairaa;

import java.util.Stack;

public class Parenthesis {
    public static boolean ispar(String x){
        if(x.length()%2 != 0)
            return false;
        char[] arr = x.toCharArray();
        Stack<Character> stack = new Stack<>();
        if(rightSide(arr[0]))
            return false;
        for (char c : arr) {
            if(rightSide(c)){
                if(stack.isEmpty())
                    return false;
                if(stack.pop() != getCorrespondingLeft(c))
                    return false;
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private static Character getCorrespondingLeft(char c) {
        if(c == ')')
            return '(';
        else if (c == '}')
            return '{';
        else if(c == ']')
            return '[';
        else
            return 'x';
    }

    private static boolean rightSide(char c) {
        return (c == ')' || c =='}' || c == ']') ;
    }
}
