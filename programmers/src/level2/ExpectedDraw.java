package level2;

public class ExpectedDraw {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(8, 4, 5));
    }

    static class Solution
    {
        public int solution(int n, int a, int b)
        {
            int answer = 0;

            while(true){
                answer++;
                a = a / 2 + a % 2;
                b = b / 2 + b % 2;
                if(a == b)
                    break;
            }

            return answer;
        }
    }
}
