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

            for(int a = 0; a <=d; a++){

                for(int b = 0; b <=d; b++){
                    if(isCurrentPositionWithinDistance(a*k, b*k, d)){
                        answer++;
                        continue;
                    }
                    break;
                }
            }
            return answer;
        }

        private boolean isCurrentPositionWithinDistance(int x, int y, int d){
            //두 점 사이의 거리 구하는 공식
            double distanceBetweenTowPoints = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));

            return distanceBetweenTowPoints <= d;
        }
    }
}
