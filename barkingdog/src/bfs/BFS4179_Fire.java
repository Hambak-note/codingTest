package bfs;

import javax.swing.plaf.BorderUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS4179_Fire {

    private static  String[] maze;
    private static int[][] firePropagationBoard;
    private static int[][] personMoveBoard;

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        maze = new String[R];
        firePropagationBoard = new int[R][C];
        personMoveBoard = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(firePropagationBoard[i], -1);
            Arrays.fill(personMoveBoard[i], -1);
        }

        for (int i = 0; i < R; i++) {
            maze[i] = br.readLine();
        }

        Queue<Pair<Integer, Integer>> fireQ = new LinkedList<>();
        Queue<Pair<Integer, Integer>> personQ = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                //불의 초기 위치를 fire 큐에 저장 및 불의 전파 배열에 위치 지정
                if(maze[i].charAt(j) == 'F'){
                    fireQ.add(new Pair<>(i, j));
                    firePropagationBoard[i][j] = 0;
                    continue;
                }
                //지훈이의 초기 위치를 person 큐에 저장 및 지훈이의 이동 배열에 위치 지정
                if (maze[i].charAt(j) == 'J') {
                    personQ.add(new Pair<>(i, j));
                    personMoveBoard[i][j] = 0;
                }
            }
        }

        //불에 대한 BFS
        bfsFire(R, C, fireQ);

        //지훈이에 대한 BFS
        bfsPerson(R, C, personQ);
    }

    private static void bfsFire(int R, int C, Queue<Pair<Integer, Integer>> fireQ) {
        while (!fireQ.isEmpty()) {
            Pair<Integer, Integer> cur = fireQ.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nextX = cur.first + dx[dir];
                int nextY = cur.second + dy[dir];
                if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
                //이미 방문했거나 벽이라면
                if(firePropagationBoard[nextX][nextY] >= 0 || maze[nextX].charAt(nextY) == '#') continue;
                firePropagationBoard[nextX][nextY] = firePropagationBoard[cur.first][cur.second] + 1;
                fireQ.add(new Pair<>(nextX, nextY));
            }
        }
    }

    private static void bfsPerson(int R, int C, Queue<Pair<Integer, Integer>> personQ) {
        while (!personQ.isEmpty()) {
            Pair<Integer, Integer> cur = personQ.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nextX = cur.first + dx[dir];
                int nextY = cur.second + dy[dir];
                //범위를 벗어났다는 것은 탈출에 성공했다는 의미, 큐에 거리 순으로 들어가므로 최초의 탈출 시간을 출력
                if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C){
                    System.out.println(personMoveBoard[cur.first][cur.second]+1);
                    return;
                }
                //이미 방문했거나 벽이라면
                if(personMoveBoard[nextX][nextY] >= 0 || maze[nextX].charAt(nextY) == '#') continue;
                //다음 칸에 불이 있으며 불의 전파 시간이 지훈이의 방문시간보다 빠른 경우
                if(firePropagationBoard[nextX][nextY] != -1 &&
                        firePropagationBoard[nextX][nextY] <= personMoveBoard[cur.first][cur.second] + 1) continue;
                personMoveBoard[nextX][nextY] = personMoveBoard[cur.first][cur.second] + 1;
                personQ.add(new Pair<>(nextX, nextY));
            }
        }

        //while문이 끝나고 나왔다는 것은 탈출에 실패했음을 의미
        System.out.println("IMPOSSIBLE");
    }

    private static class Pair<T1, T2>{
        private T1 first;
        private T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }
}
