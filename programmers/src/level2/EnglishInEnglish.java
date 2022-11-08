package level2;

import java.util.ArrayList;
import java.util.List;

public class EnglishInEnglish {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words =
                {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] answer = s.solution(3, words);

        System.out.println(answer[0] + " " + answer[1]);

    }

    static class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer;

            List<String> usedWords = new ArrayList<>();

            char lastChar = words[0].charAt(0);

            int round = 1;
            int turn = 1;
            boolean checkSuccess = true;
            for(String str : words){
                //1. 한 글자인 단어
                //2. 이전에 등장했던 단어 사용
                //3. 마지막 글자로 시작하는 단어를 말하지 않은 경우
                if(str.length() == 0 || usedWords.contains(str) || lastChar != str.charAt(0)){
                    checkSuccess = false;
                    break;
                }
                usedWords.add(str);
                lastChar = str.charAt(str.length()-1);
                if(turn == n) {
                    turn = 1;
                    round++;
                    continue;
                 }
                turn++;
            }

            if(checkSuccess == false){
                answer = new int[] {turn, round};
                return answer;
            }

            answer = new int[] {0, 0};

            return answer;
        }

    }
}
