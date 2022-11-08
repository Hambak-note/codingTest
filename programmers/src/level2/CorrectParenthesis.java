package level2;

import java.util.Stack;

public class CorrectParenthesis {

    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> parenthesisStack = new Stack<>();
        int inputStrLength = s.length();

        for(int i=0; i < inputStrLength; i++){

            if(s.charAt(i) == '('){
                parenthesisStack.push(s.charAt(i));
            }else{
                if(parenthesisStack.isEmpty()){
                    return false;
                }else{
                    parenthesisStack.pop();
                }
            }
        }

        if(!parenthesisStack.isEmpty()) {
            return false;
        }

        return answer;
    }

}
