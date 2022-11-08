package level2;

import java.util.LinkedList;
import java.util.Queue;

public class CheckDistance {

    public static void main(String[] args) {
    }

    static class Solution {

        int[] directionX = { -1, 1, 0, 0 };
        int[] directionY = { 0, 0, -1, 1 };

        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];



            for(int i=0; i < places.length; i++){

                String[] place = places[i];
                answer[i] = 1;
                Loop:
                for(int x = 0; x < 5; x++){
                    for(int y = 0; y < 5; y++){
                        if(place[x].charAt(y) == 'P'){
                            if(!checkPlace(x, y, place)){
                                answer[i] = 0;
                                break Loop;
                            }
                        }
                    }
                }
            }

            return answer;
        }

        public boolean checkPlace(int x, int y, String[] place){
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {x, y});

            while(!queue.isEmpty()){
                int[] current = queue.remove();

                for(int i =0; i < 4; i++){
                    int nextX = current[0] + directionX[i];
                    int nextY = current[1] + directionY[i];

                    if(nextX < 0 || nextY < 0 || nextX >= 5 || nextY >= 5 || (nextX == x && nextY == y))
                        continue;

                    int manhattanDistance = Math.abs(nextX - x) + Math.abs(nextY - y);

                    if(place[nextX].charAt(nextY) == 'P' && manhattanDistance <= 2)
                        return false;
                    else if(place[nextX].charAt(nextY) == 'O' && manhattanDistance < 2)
                        queue.add(new int[] {nextX, nextY});
                }
            }

            return true;
        }
    }
}
