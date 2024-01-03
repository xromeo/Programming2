package easy;

import java.util.Stack;

/*
 A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is balanced if the following conditions are met:

It contains no unmatched brackets.
The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
Given n strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.
 */

public class BalancedBrackets {
    public static String isBalanced(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.add(ch);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                char sch = stack.pop();
                if (ch == ')' && sch != '(') {
                    return "NO";
                } else if (ch == ']' && sch != '[') {
                    return "NO";
                } else if (ch == '{' && sch == '}') {
                    return "NO";
                }

            }
        }
        return stack.isEmpty() ? "YES" : "NO";

    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}")); // YES
        System.out.println(isBalanced("{[(])}")); // NO
        System.out.println(isBalanced("{{[[(())]]}}")); // YES
        System.out.println(isBalanced("()[{}()]([[][]()[[]]]{()})([]()){[]{}}{{}}{}(){([[{}([]{})]])}")); // YES
        System.out.println(isBalanced("[)](][[([]))[)")); // NO
    }
}
