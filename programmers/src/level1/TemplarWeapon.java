package level1;

public class TemplarWeapon {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(5, 3, 2);
    }

    /**
     * 약수의 개수를 구하는 함수
     *
     */

    static class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 0;

            for (int i = 1; i <= number; i++) {
                int divisor = calNumberOfDivisors(i);
                if (divisor > limit) divisor = power;
                answer += divisor;
            }

            return answer;
        }

        public static int calNumberOfDivisors(int number){

            int numberOfDivisors = 0;
            for(int i = 1; i <= number; i++){
                if(number % i == 0){
                    numberOfDivisors++;
                }
            }
            return numberOfDivisors;
        }
    }

}
