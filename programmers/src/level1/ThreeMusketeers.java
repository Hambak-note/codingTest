package level1;

public class ThreeMusketeers {



    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{-2,3,0,2,-5});
        s.solution(new int[]{-3, -2, -1, 0, 1, 2, 3});
        s.solution(new int[]{-1, 1, -1, 1});
    }

    static class Solution {

        int[] inputNumber;
        boolean[] isUsed;

        int numberOfThreeMusketeers;
        public int solution(int[] number) {
            int answer = 0;

            inputNumber = number;
            isUsed = new boolean[inputNumber.length];
            numberOfThreeMusketeers = 0;

            makeThreeMusketeers(0, inputNumber.length, 3, 0);

            answer = numberOfThreeMusketeers;
            System.out.println("answer = " + answer);

            return answer;
        }

        void makeThreeMusketeers(int index, int n, int r, int sum){
            if(r == 0 && sum == 0){
                numberOfThreeMusketeers++;
                return;
            }

            for(int i = index; i < n; i++){
                isUsed[i] = true;
                makeThreeMusketeers(i+1, n, r-1, sum+inputNumber[i]);
                isUsed[i] = false;
            }
        }
    }
}
