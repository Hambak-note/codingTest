package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int myLocation = Integer.parseInt(st.nextToken());
        int brotherLocation = Integer.parseInt(st.nextToken());

        int[] distance = new int[100002];
        Arrays.fill(distance, -1);

        distance[myLocation] = 0;

        Queue<Integer> locationQueue = new LinkedList();
        locationQueue.add(myLocation);

        while(distance[brotherLocation] == -1){
            int current = locationQueue.remove();

            int[] movementRange = {current-1, current+1, current*2};
            for(int next : movementRange){
                if(next < 0 || next > 100000) continue;
                if(distance[next] != -1) continue;
                distance[next] = distance[current]+1;
                locationQueue.add(next);
            }
        }
        System.out.println(distance[brotherLocation]);
    }
}
