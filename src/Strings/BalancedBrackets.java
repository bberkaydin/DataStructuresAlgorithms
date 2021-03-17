package Interview.Strings;

import java.util.Stack;

public class BalancedBrackets {

    //Shorter Soln:
    public boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();
    for (char c : s.toCharArray()) {
        if (c == '(')
            stack.push(')');
        else if (c == '{')
            stack.push('}');
        else if (c == '[')
            stack.push(']');
        else if (stack.isEmpty() || stack.pop() != c)
            return false;
    }
    return stack.isEmpty();
    }


    public static boolean isBalanced(String s){
        if(s == null || s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else if(c == ')' || c == '}' || c == ']'){
                if(!stack.isEmpty()){
                    char latestOpenP = stack.pop();
                    if(latestOpenP == '(' && c != ')'){
                        return false;
                    } else if(latestOpenP == '{' && c != '}'){
                        return false;
                    } else if(latestOpenP == '[' && c != ']'){
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
