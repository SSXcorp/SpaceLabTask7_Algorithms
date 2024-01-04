package Task4;

import java.util.Scanner;
import java.util.Stack;

public class BracketChecker {
    static boolean checkBrackets(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty() || !isMatching(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    static boolean isMatching(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '{' && closing == '}') ||
                (opening == '[' && closing == ']');
    }

    public static boolean isValid(String s) { // checks brackets ONLY
        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            if(x=='('){
                stack.push(')');
            } else if (x=='{') {
                stack.push('}');
            } else if (x=='[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop()!=x) {
                return false;
            }
        }
        return stack.isEmpty();

    }
}
