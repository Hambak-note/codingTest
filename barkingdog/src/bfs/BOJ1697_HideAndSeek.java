package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제 풀이 방식
 * 1. 2차원 배열이 아닌 1차원 배열으로 생각해서 문제를 푼다.
 * 2. 문제에서 주어진 범위가 0에서 100,000이지 해당 범위를 넘어가지
 *    못 하는 것은 아님. (앞 뒤로 이동이 가능하기 때문 범위를 넘었다가 다시 돌아올 수도)
 * 3. 그러나 2번의 경우 손해인 것을 인지
 *     100,000 범위를 벗어나는 것 자체가 손해. x2로 100,000을 넘어가더라도 이후 -1을 여러번해야함
 *     차라리 -1을 먼저하고 x2를 하는 것이 더 나음
 */
public class BOJ1697_HideAndSeek {

    private static int dist[] = new int[100002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int subin = Integer.parseInt(st.nextToken());
        int sister = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1);

        //시작 위치 지정
        dist[subin] = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(subin);

        //동생의 위치에 방문하지 않았다면 반복
        while(dist[sister] == -1){
            int cur = Q.poll();
            int[] possibleMoveArr = new int[]{cur - 1, cur + 1, 2 * cur};
            for (int next : possibleMoveArr) {
                if(next < 0 || next > 100000) continue;
                //이미 방문했다면
                if(dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                Q.add(next);
            }
        }

        System.out.println(dist[sister]);
    }
}
