package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Painting {

    private static int[][] board;
    private static boolean[][] isVisited;

    private static int vertical;
    private static int horizontal;

    private static final int[] directionX = {1,0,-1,0};
    private static final int[] directionY = {0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertical = Integer.parseInt(st.nextToken());
        horizontal = Integer.parseInt(st.nextToken());

        board = new int[vertical][horizontal];
        isVisited = new boolean[vertical][horizontal];

        for (int i = 0; i < vertical; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < horizontal; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int numberOfPictures = 0;
        int widestPictureArea = 0;

        for(int i = 0; i < vertical; i++){
            for(int j = 0; j < horizontal; j++){
                if(board[i][j] ==0 || isVisited[i][j]) continue;
                numberOfPictures++;
                Queue<int[]> positionStore = new LinkedList<>();
                isVisited[i][j] = true;
                positionStore.add(new int[]{i, j});

                int pictureArea = 0;
                while (!positionStore.isEmpty()) {
                    pictureArea++;
                    int[] currentPosition = positionStore.remove();
                    for(int direction = 0; direction < 4; direction++){
                        int nextX = currentPosition[0] + directionX[direction];
                        int nextY = currentPosition[1] + directionY[direction];
                        if(nextX < 0 || nextX >= vertical || nextY < 0 || nextY >= horizontal) continue;
                        if(isVisited[nextX][nextY] || board[nextX][nextY] != 1) continue;
                        isVisited[nextX][nextY] = true;
                        positionStore.add(new int[]{nextX, nextY});
                    }
                }
                widestPictureArea = Math.max(pictureArea, widestPictureArea);
            }
        }
        System.out.println(numberOfPictures);
        System.out.println(widestPictureArea);
    }
}
