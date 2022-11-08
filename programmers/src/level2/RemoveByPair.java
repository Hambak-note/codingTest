package level2;

import java.util.Stack;

public class RemoveByPair {

    public static void main(String[] args) {
        Solution s = new Solution();
        int answer1 = s.solution("baabaa");
        System.out.println("answer1 = " + answer1);
        int answer2 = s.solution("cdcd");
        System.out.println("answer2 = " + answer2);
    }

    static class Solution
    {
        public int solution(String s)
        {
            int answer = -1;

            boolean check = false;

            Stack<Character> charStack = new Stack<>();

            for(char c : s.toCharArray()){
                if(!charStack.isEmpty() && charStack.peek() == c){
                    charStack.pop();
                }else{
                    charStack.push(c);
                }
            }

            if(charStack.isEmpty()){
                answer = 1;
            }else {
                answer = 0;
            }
            return answer;
        }
    }
}
