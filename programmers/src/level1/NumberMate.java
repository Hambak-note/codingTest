package level1;

import java.util.Arrays;

public class NumberMate {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("3403", "13203");
        s.solution("12321", "42531");
        s.solution("5525", "1255");
    }

    static class Solution {
        public String solution(String X, String Y) {
            String answer = "";

            char[] xArr = X.toCharArray();
            char[] yArr = Y.toCharArray();
            Arrays.sort(xArr);
            Arrays.sort(yArr);

            StringBuilder mate = new StringBuilder(X.length());

            int xPos = 0;
            int yPos = 0;

            while(xPos != xArr.length && yPos != yArr.length){
                if(xArr[xPos] < yArr[yPos]){
                    xPos++;
                    continue;
                }

                if(xArr[xPos] > yArr[yPos]){
                    yPos++;
                    continue;
                }

                mate.append(xArr[xPos]);
                xPos++;
                yPos++;

            }

            if(mate.length() == 0){
                return "-1";
            }

            answer = mate.reverse().toString();

            if(answer.charAt(0) == '0') return "0";

            return answer;
        }
    }
}

