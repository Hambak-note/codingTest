package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {

    //토마토 보관 상자
    static int[][] tomatoStorageBox;
    //상자의 행과 열
    static int rowOfBox;
    static int columnOfBox;
    //토마토가 익기 위해 필요한 일 수
    static int[][] numberOfDays;
    //상하좌우를 방문하기 위한 좌표
    static int directionX[] = {1, 0, -1, 0};
    static int directionY[] = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        columnOfBox = Integer.parseInt(st.nextToken());
        rowOfBox = Integer.parseInt(st.nextToken());

        tomatoStorageBox = new int[rowOfBox][columnOfBox];
        numberOfDays = new int[rowOfBox][columnOfBox];

        Queue<int[]> ripeTomatoQueue = new LinkedList<>();

        for(int i=0; i <rowOfBox; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < columnOfBox; j++){
                tomatoStorageBox[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoStorageBox[i][j] == 1){
                    ripeTomatoQueue.add(new int[] {i, j});
                }
                if(tomatoStorageBox[i][j] == 0){
                    numberOfDays[i][j] = -1;
                }
            }
        }



        while(!ripeTomatoQueue.isEmpty()){
            int[] current = ripeTomatoQueue.remove();
            for(int direction = 0; direction < 4; direction++){
                int nx = current[0] + directionX[direction];
                int ny = current[1] + directionY[direction];
                if(nx < 0 || nx >= rowOfBox || ny < 0 || ny >= columnOfBox){
                    continue;
                }
                if(numberOfDays[nx][ny] >=0){
                    continue;
                }
                numberOfDays[nx][ny] = numberOfDays[current[0]][current[1]]+1;
                ripeTomatoQueue.add(new int[] {nx, ny});
            }
        }


        int minimumDate = 0;
        loopOut:
        for(int i=0; i < rowOfBox; i++){
            for(int j=0; j < columnOfBox; j++){
                if(numberOfDays[i][j] == -1){
                    minimumDate = -1;
                    break loopOut;
                }
                minimumDate = Math.max(minimumDate, numberOfDays[i][j]);
            }
        }
        System.out.println(minimumDate);
    }
}
