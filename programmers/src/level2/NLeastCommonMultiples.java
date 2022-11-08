package level2;

public class NLeastCommonMultiples {

    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(new int[]{2, 6, 8, 14});
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int[] arr) {
            int answer = 0;

            int currentLCM = arr[0];

            if(arr.length == 1) return currentLCM;

            currentLCM = arr[0];
            for(int i=1; i < arr.length; i++){
                currentLCM = makeLeastCommonMultiple(currentLCM, arr[i]);
            }

            answer = currentLCM;

            return answer;
        }


        //최대 공약수
        public int makeGreatestCommonFactor(int num1, int num2){
            if(num1 == 0){
                return num2;
            }

            return makeGreatestCommonFactor(num2%num1, num1);
        }

        //최소 공배수
        public int makeLeastCommonMultiple(int num1, int num2){
            return num1 * num2 / makeGreatestCommonFactor(num1, num2);
        }

    }


}
