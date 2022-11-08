package level2;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistance {
    public int solution(int[][] maps) {
        int answer = 0;

        int numberOfRows = maps.length;
        int numberOfColumns = maps[0].length;

        int[][] shortestDistanceMap = new int[numberOfRows][numberOfColumns];
        Queue<int[]> userPositionQueue = new LinkedList<>();

        int directionX[] = {1, 0, -1, 0};
        int directionY[] = {0, 1, 0, -1};

        for(int i = 0; i < numberOfRows; i++){
            for(int j = 0; j < numberOfColumns; j++){
                shortestDistanceMap[i][j] = -1;
            }
        }

        shortestDistanceMap[0][0] = 1;
        userPositionQueue.add(new int[] {0, 0});

        while(!userPositionQueue.isEmpty()){
            int[] current = userPositionQueue.remove();

            for(int direction=0; direction < 4; direction++){
                int nextX = current[0] + directionX[direction];
                int nextY = current[1] + directionY[direction];

                if(nextX < 0 || nextX>=numberOfRows || nextY < 0 || nextY >= numberOfColumns) continue;
                if(shortestDistanceMap[nextX][nextY] >= 0 || maps[nextX][nextY] == 0) continue;

                shortestDistanceMap[nextX][nextY] = shortestDistanceMap[current[0]][current[1]] + 1;
                userPositionQueue.add(new int[] {nextX, nextY});
            }
        }

        answer = shortestDistanceMap[numberOfRows-1][numberOfColumns-1];

        return answer;
    }

}
