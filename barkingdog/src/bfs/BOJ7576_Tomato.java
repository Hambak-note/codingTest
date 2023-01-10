package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576_Tomato {

    private static int[][] tomatoBox;

    private static int[][] dist;

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Queue<Pair<Integer, Integer>> Q = new LinkedList<>();
        tomatoBox = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomatoBox[i][j] = Integer.parseInt(st.nextToken());
                //익은 토마토를 큐에 저장
                if(tomatoBox[i][j] == 1){
                    Q.add(new Pair<>(i, j));
                    continue;
                }
                //익지 않은 토마토가 들어있는 칸은 거리배열을 -1로 초기화
                if(tomatoBox[i][j] == 0){
                    dist[i][j] = -1;
                }
            }
        }

        while(!Q.isEmpty()){
            Pair<Integer, Integer> cur = Q.poll();
            for(int dir = 0; dir < 4; dir++){
                int nextX = cur.first + dx[dir];
                int nextY = cur.second + dy[dir];
                if(nextX < 0 || nextX >= n || nextY <0 || nextY >= m) continue;
                //dist 배열에 들어있는 값이 0보다 크거나 같다는 것은
                //이미 방문했거나, 토마토가 들어있지 않은 칸을 의미
                if(dist[nextX][nextY] >= 0) continue;
                dist[nextX][nextY] = dist[cur.first][cur.second] + 1;
                Q.add(new Pair<>(nextX, nextY));
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dist[i][j] == -1){
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, dist[i][j]);
            }
        }

        System.out.println(answer);
    }


    static class Pair<T1, T2> {

        private T1 first;
        private T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }


}

