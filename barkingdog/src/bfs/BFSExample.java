package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSExample {

    private static int[][] board;
    private static boolean[][] vis;
    private static int[] dx = new int[]{1, 0, -1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};


    public static void main(String[] args) {

        int n = 7;
        int m = 10;

        Queue<Pair<Integer, Integer>> Q = new LinkedList<>();
        board = new int[502][502];
        vis = new boolean[502][502];

        vis[0][0] = true;

        Q.add(new Pair<>(0, 0));

        while (!Q.isEmpty()) {
            Pair<Integer, Integer> cur = Q.peek();
            Q.poll();

            System.out.print("(" + cur.getFirst() + ", " + cur.getSecond() + ") ->");
            //상하좌우 4방향 반복
            for(int dir = 0; dir < 4; dir++){
                int nextX = cur.getFirst() + dx[dir];
                int nextY = cur.getSecond() + dy[dir];
                //범위를 벗어나는지 검사
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                //board의 해당 칸이 1이 아니면 방문 불가능한 곳이라고 가정
                //방문 했는지와 방문 가능한 board인지 확인
                if(vis[nextX][nextY] || board[nextX][nextY] != 1) continue;
                vis[nextX][nextY] = true;
                Q.add(new Pair<>(nextX, nextY));
            }

        }
    }
}
