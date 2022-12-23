package alogorithm.coding_test.programmers.level2;

import java.util.Arrays;

public class TableHashFunction {

    public int Solution(int[][] data, int col, int row_begin, int row_end){

        int answer = 0;

        int[][] sortedData = sortDateArray(data, col);
        int[] S_i = calculateS_i(sortedData, row_begin, row_end);
        answer = calculateHash(S_i);

        return answer;
    }

    //주어진 정렬 기준으로 정렬
    public int[][] sortDateArray(int[][] data, int col){
        Arrays.sort(data, (d1, d2) -> {
            if(d1[col-1] == d2[col-1]){
                return Integer.compare(d2[0], d1[0]);
            }else{
                return Integer.compare(d1[col-1], d2[col-1]);
            }
        });

        return data;
    }

    public int[] calculateS_i(int[][] data, int row_begin, int row_end){
        int[] S_i = new int[row_end-row_begin+1];

        int index = 0;
        int sum = 0;
        for(int i = row_begin-1; i < row_end; i++){

            for(int j = 0; j < data[0].length; j++){
                sum += (data[i][j] % (i+1));
            }
            S_i[index] = sum;
            index++;
            sum = 0;
        }
        return S_i;
    }

    public int calculateHash(int[] S_i) {
        int hash = S_i[0];

        for(int i = 1; i < S_i.length; i++){
            hash = (hash^S_i[i]);
        }

        return hash;
    }
}
