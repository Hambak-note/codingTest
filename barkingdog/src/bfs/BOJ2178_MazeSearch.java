package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 기존에 사용했던 방문했던 표시 대신에 해당 지점까지 이동한 거리를 기록한다.
 */


public class BOJ2178_MazeSearch {


    private static int[][] board;
    private static int[][] dist;

    private static int[] dx = new int[]{1, 0, -1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] splitInput = br.readLine().split("");
            for (int j = 0; j < splitInput.length; j++) {
                board[i][j] = Integer.parseInt(splitInput[j]);
                //-1로 초기화하면 방문 여부까지 확인 가능하다.
                dist[i][j] = -1;
            }
        }

        Queue<CustomPair<Integer, Integer>> Q = new LinkedList<>();
        Q.add(new CustomPair<>(0, 0));
        dist[0][0] = 0;

        while (!Q.isEmpty()) {
            CustomPair<Integer, Integer> cur = Q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nextX = cur.getFirst() + dx[dir];
                int nextY = cur.getSecond() + dy[dir];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(dist[nextX][nextY] >= 0 || board[nextX][nextY] != 1) continue;

                dist[nextX][nextY] = dist[cur.getFirst()][cur.getSecond()]+1;
                Q.add(new CustomPair<>(nextX, nextY));
            }
        }

        System.out.println(dist[N-1][M-1]+1);
    }

    static class CustomPair<T1, T2> {

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
}


