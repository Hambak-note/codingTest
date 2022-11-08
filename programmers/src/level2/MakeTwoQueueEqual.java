package level2;

import java.util.LinkedList;
import java.util.Queue;

public class MakeTwoQueueEqual {

    public static void main(String[] args) {
        Solution s = new Solution();
        int answer;
        answer = s.solution(new int[]{3, 2, 7, 2}, new int[] {4, 6, 5, 1});
        System.out.println("answer1 = " + answer);

        answer = s.solution(new int[]{1, 2, 1, 2}, new int[] {1, 10, 1, 2});
        System.out.println("answer2 = " + answer);

        answer = s.solution(new int[]{1, 1}, new int[] {1, 5});
        System.out.println("answer3 = " + answer);


    }

    static class Solution {
        public int solution(int[] queue1, int[] queue2) {
            int answer = -2;

            int maxValue = queue1[0];

            long q1Sum = 0;
            long q2Sum = 0;
            long goalSum;

            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();

            for(int i = 0; i < queue1.length; i++){
                q1Sum += queue1[i];
                q2Sum += queue2[i];

                q1.add(queue1[i]);
                q2.add(queue2[i]);

                if(maxValue < queue1[i]) maxValue = queue1[i];
                if(maxValue < queue2[i]) maxValue = queue2[i];
            }

            if((q1Sum+q2Sum) % 2 != 0){
                return -1;
            }else{
                goalSum = (q1Sum+q2Sum) / 2;
            }

            if(goalSum < maxValue){
                return -1;
            }

            answer = 0;
            int moveValue;

            while(q1Sum != q2Sum){

                if(answer > queue1.length*3) return -1;

                if(q1Sum > q2Sum){
                    moveValue = q1.poll();
                    q1Sum -= moveValue;
                    q2Sum += moveValue;
                    q2.add(moveValue);
                } else{
                    moveValue = q2.poll();
                    q1Sum += moveValue;
                    q2Sum -= moveValue;
                    q1.add(moveValue);
                }
                answer++;
            }

            return answer;
        }
    }
}
