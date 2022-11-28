package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HallOfFame {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> answer = s.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200});
        System.out.println(answer.toString());
    }

    static class Solution {
        public List<Integer> solution(int k, int[] score) {

            List<Integer> answer = new ArrayList<>();
            List<Integer> hallOfFameList = new ArrayList<>();



            for(int i = 0; i < score.length; i++){
                if(hallOfFameList.size() < k){
                    hallOfFameList.add(score[i]);
                    Collections.sort(hallOfFameList);
                    answer.add(hallOfFameList.get(0));
                    continue;
                }

                if(hallOfFameList.get(0) < score[i]){
                    hallOfFameList.remove(0);
                    hallOfFameList.add(score[i]);
                    Collections.sort(hallOfFameList);
                    answer.add(hallOfFameList.get(0));
                    continue;
                }

                answer.add(hallOfFameList.get(0));

            }

            return answer;
        }
    }
}
