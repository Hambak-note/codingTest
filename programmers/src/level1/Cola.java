package level1;

public class Cola {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(2, 1, 20));
        System.out.println(s.solution(3, 1, 20));
    }

    /**
     * 빈병 a 개 주면 b개를 준다.
     * 상빈이가 가지고 있는 빈병의 개수 n
     */

    static class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;


            int cokes = n;

            while(cokes >= a){

                int share = cokes / a;
                int remainder = cokes % a;
                int exchange = share * b;
                cokes = exchange + remainder;
                answer += exchange;
            }

            return answer;
        }

    }
}
