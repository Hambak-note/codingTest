package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1012_OrganicCabbage {

    private static int[] dx = new int[]{1, 0, -1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());


        while (testCase-- != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int cabbageCount = Integer.parseInt(st.nextToken());

            boolean[][] visit = new boolean[M][N];
            int[][] cabbageField = new int[M][N];
            initCabbageField(br, cabbageCount, cabbageField);

            int numberOfEarthworm = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    //배추가 있는 곳이 아니거나 방문했던 곳이면 넘어간다.
                    if(cabbageField[i][j] == 0 || visit[i][j]) continue;

                    numberOfEarthworm++;

                    Queue<Pair> Q = new LinkedList<>();

                    visit[i][j] = true;
                    Q.add(new Pair(i, j));
                    while (!Q.isEmpty()) {
                        Pair cur = Q.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nextX = cur.x + dx[dir];
                            int nextY = cur.y + dy[dir];
                            if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
                            //다음 방문할 곳이 이미 방문한 곳이거나 배추가 없는 곳이라면
                            if(visit[nextX][nextY] || cabbageField[nextX][nextY] != 1) continue;
                            visit[nextX][nextY] = true;
                            Q.add(new Pair(nextX, nextY));
                        }
                    }
                }
            }

            System.out.println(numberOfEarthworm);

        }
    }

    private static void initCabbageField(BufferedReader br, int cabbageCount, int[][] cabbageField)
            throws IOException {
        StringTokenizer st;
        for(int i = 0; i < cabbageCount; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cabbageField[x][y] = 1;
        }
    }

    private static class Pair{

        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
