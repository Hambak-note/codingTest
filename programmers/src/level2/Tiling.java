package level2;

public class Tiling {

    public static void main(String[] args) {

    }

    static class Solution {
        public int solution(int n) {
            int answer = 1;

            int a = 1;
            int b = 1;

            for (int i = 1; i < n; i++) {
                answer = (a + b) % 1000000007;

                a = b;
                b = answer;
            }

            return answer;
        }
    }

}
