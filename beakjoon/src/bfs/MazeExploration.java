package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeExploration {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertical = Integer.parseInt(st.nextToken());
        int horizontal = Integer.parseInt(st.nextToken());

        int[][] board = new int[vertical][horizontal];
        int[][] distance = new int[vertical][horizontal];

        int directionX[] = {1, 0, -1, 0};
        int directionY[] = {0, 1, 0, -1};

        for(int i = 0; i < vertical; i++){
            String input = br.readLine();
            for (int j = 0; j < horizontal; j++) {
                board[i][j] = input.charAt(j) - '0';
                distance[i][j] = -1;
            }
        }

        Queue<int[]> currentPositionQueue = new LinkedList<>();
        currentPositionQueue.add(new int[]{0, 0});
        distance[0][0] = 0;

        while(!currentPositionQueue.isEmpty()){
            int[] currentPosition = currentPositionQueue.remove();

            for(int direction = 0; direction < 4; direction++){
                int nextX = currentPosition[0] + directionX[direction];
                int nextY = currentPosition[1] + directionY[direction];

                if (nextX < 0 || nextX >= vertical || nextY < 0 || nextY >= horizontal) {
                    continue;
                }
                if(distance[nextX][nextY] >= 0 || board[nextX][nextY] != 1){
                    continue;
                }

                distance[nextX][nextY] = distance[currentPosition[0]][currentPosition[1]] + 1;
                currentPositionQueue.add(new int[]{nextX, nextY});
            }
        }

        System.out.println(distance[vertical-1][horizontal-1]+1);
    }
}
