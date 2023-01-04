package alogorithm.coding_test.programmers.level2;

public class App {



    public static void main(String[] args) {
        int col = 2;
        int row_begin = 2;
        int row_end = 3;
        int result = 4;
        int[][] data = {{2,2,6}, {1,5,10}, {4,2,9}, {3,8,3}};
        int[][] sortedData = {{4, 2, 9}, {2, 2, 6}, {1, 5, 10}, {3, 8, 3}};
        TableHashFunction tableHashFunction = new TableHashFunction();
        tableHashFunction.calculateS_i(sortedData, row_begin, row_end);
    }
}
