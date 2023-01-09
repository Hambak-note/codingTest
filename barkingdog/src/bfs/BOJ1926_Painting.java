package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1926_Painting {

    private static int[][] board;
    private static boolean[][] vis;

    private static int[] dx = new int[]{1, 0, -1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //가로크기
        int m = Integer.parseInt(st.nextToken()); //세로크기

        board = new int[n][m];
        vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int numberOfPainting = 0;
        int maxSizeOfPainting= 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //그림이 있는 곳이 아니거나 방문했던 곳이면 넘어간다.
                if(board[i][j] == 0 || vis[i][j]) continue;

                numberOfPainting++;

                Queue<CustomPair<Integer, Integer>> Q = new LinkedList<>();

                vis[i][j] = true;
                Q.add(new CustomPair<>(i, j));
                int area = 0;
                while (!Q.isEmpty()) {
                    area++;
                    CustomPair<Integer, Integer> cur = Q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nextX = cur.getFirst()+dx[dir];
                        int nextY = cur.getSecond() + dy[dir];
                        if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                        if(vis[nextX][nextY] || board[nextX][nextY] != 1) continue;
                        vis[nextX][nextY] = true;
                        Q.add(new CustomPair<>(nextX, nextY));
                    }
                }

                maxSizeOfPainting = Math.max(maxSizeOfPainting, area);
            }
        }

        System.out.println(numberOfPainting);
        System.out.println(maxSizeOfPainting);
    }
}


class CustomPair<T1, T2> {

    private T1 first;
    private T2 second;

    public CustomPair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }
}

