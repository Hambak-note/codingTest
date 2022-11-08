package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FindTheNumberOfDecimalsInKNumber {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(110011, 10));
    }

    static class Solution {
        public int solution(int n, int k) {
            int answer = 0;
            List<Long> confirmedValueList = new ArrayList<>();
            String convertedStr;

            convertedStr = convertToGivenDecimal(n, k);
            confirmedValueList = findValuesThatMatchACondition(convertedStr);
            for(long num : confirmedValueList){
                if(num == 1) continue;
                if(checkPrimeOrNot(num)) answer++;
            }

            return answer;
        }

        //k진법으로 변환하는 메서드
        public String convertToGivenDecimal(int n, int decimal){
            return Integer.toString(n, decimal);
        }

        //조건에 맞게 수를 분리하는 함수
        public List<Long> findValuesThatMatchACondition(String number) {
            List<Long> confirmedValueList = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(number, "0");
            while(st.hasMoreTokens()){
                confirmedValueList.add(Long.valueOf(st.nextToken()));
            }
            return confirmedValueList;
        }

        //소수 판별 함수
        public boolean checkPrimeOrNot(long num){
            for(int i = 2; i <= (long)Math.sqrt(num); i++){
                if(num % i == 0){
                    return false;
                }
            }

            return true;
        }
    }


}
