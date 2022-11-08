package level2;

import java.util.Arrays;

public class KakaoFriendsColoringBook {
    public static void main(String[] args) {
        KakaoFriendsColoringBook kakaoFriendsColoringBook = new KakaoFriendsColoringBook();
        int m = 6;
        int n = 4;
        int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
        System.out.println(Arrays.toString(kakaoFriendsColoringBook.solution(6, 4, picture)));
    }

    static int[][] inputPicture;
    static boolean[][] isVisited;
    static int sizeOfOneArea;
    static int[] directionX = {-1,0,0,1};
    static int[] directionY = {0,1,-1,0};


    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        inputPicture = picture;
        isVisited = new boolean[m][n];
        sizeOfOneArea = 0;

        for(int i = 0; i < m; i++){
            for(int j=0; j < n; j++){
                if(picture[i][j] != 0 && !isVisited[i][j]){
                    numberOfArea++;
                    calculateArea(i, j);
                }
                if(sizeOfOneArea > maxSizeOfOneArea) maxSizeOfOneArea = sizeOfOneArea;
                sizeOfOneArea = 0;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    public void calculateArea(int x, int y){
        isVisited[x][y] = true;
        sizeOfOneArea++;

        for(int i=0; i<4; i++){
            int nextX = x + directionX[i];
            int nextY = y + directionY[i];

            if(nextX < 0 || nextX >= inputPicture.length || nextY <0 || nextY >= inputPicture[0].length) continue;

            if(inputPicture[x][y] == inputPicture[nextX][nextY] && !isVisited[nextX][nextY]){
                calculateArea(nextX, nextY);
            }
        }
    }

}
