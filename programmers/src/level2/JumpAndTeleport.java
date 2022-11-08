package level2;

public class JumpAndTeleport {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5));
    }

    static public class Solution {
        public int solution(int n) {
            int ans = 0;

            while(n > 0){
                if(n % 2 == 0){
                    n /= 2;
                    continue;
                }
                if(n % 2 != 0){
                    n -= 1;
                    ans++;
                }
            }

            return ans;
        }
    }
}
