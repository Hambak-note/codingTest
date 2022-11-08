package level2;

import java.util.Stack;

public class RotateParentheses {

    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution("[](){}");
        System.out.println(answer);
    }

    static class Solution {
        public int solution(String s) {
            int answer = 0;

            StringBuilder rotatingString = new StringBuilder(s);
            boolean isCorrect = false;

            for(int i = 0; i < s.length(); i++){

                //올바른 괄호인지 확인 후
                isCorrect = CheckForCorrectParentheses(new StringBuilder(rotatingString));
                if(isCorrect == true) answer++;

                //회전
                char firstChar = rotatingString.charAt(0);
                rotatingString.append(firstChar);
                rotatingString = new StringBuilder(rotatingString.substring(1));
            }

            return answer;
        }

        public boolean CheckForCorrectParentheses(StringBuilder input){
            Stack<Character> leftBracketStorage = new Stack<>();

            for (int i = 0; i < input.length(); i++) {
                char inputChr = input.charAt(i);

                if(inputChr == '(' || inputChr == '[' || inputChr == '{'){
                    leftBracketStorage.push(inputChr);
                    continue;
                }

                if(leftBracketStorage.isEmpty()) return false;

                char popChar = leftBracketStorage.pop();
                if(inputChr == ']' && popChar != '[') return false;
                if(inputChr == ')' && popChar != '(') return false;
                if(inputChr == '}' && popChar != '{') return false;
            }

            if(!leftBracketStorage.isEmpty()) return false;

            return true;

        }
    }
}
