package level2;

public class Dot {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(2, 4));
        System.out.println(s.solution(1, 5));

    }

    static class Solution {
        public long solution(int k, int d) {
            long answer = 0;

            for(int i = 0; i <= d; i+= k){
                int yMaxValue = calculateMaxYAtCurrentXPosition(i, d);
                answer += findPossibleY(yMaxValue, k);
            }
            return answer;
        }

        private int calculateMaxYAtCurrentXPosition(int x, int d){
            long xSquared = (long) Math.pow(x, 2);
            long dSquared = (long) Math.pow(d, 2);

            //return max Y value at this x position
            return (int) Math.sqrt(dSquared - xSquared);
        }

        private int findPossibleY(int yMaxValue,int k){
            return (yMaxValue/k) + 1;
        }



    }
}
