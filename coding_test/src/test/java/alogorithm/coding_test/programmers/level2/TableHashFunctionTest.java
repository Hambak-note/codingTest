package alogorithm.coding_test.programmers.level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableHashFunctionTest {

    TableHashFunction tableHashFunction = new TableHashFunction();
    int col = 2;
    int row_begin = 2;
    int row_end = 3;
    int result = 4;
    int[][] data = {{2,2,6}, {1,5,10}, {4,2,9}, {3,8,3}};
    int[][] sortedData = {{4, 2, 9}, {2, 2, 6}, {1, 5, 10}, {3, 8, 3}};

    @Test
    @DisplayName("정렬 테스트")
    void sort_test(){
        Assertions.assertThat(tableHashFunction.sortDateArray(data, col)).isEqualTo(sortedData);
    }

    @Test
    @DisplayName("S_i 계산 결과 확인")
    void check_S_i(){

        int[] S_i = tableHashFunction.calculateS_i(sortedData, row_begin, row_end);
        int[] expectedS_i = {0, 4};
        Assertions.assertThat(S_i).isEqualTo(expectedS_i);
    }

    @Test
    @DisplayName("해시 계산 결과 확인")
    void calculate_hash_test(){

        int[] S_i = tableHashFunction.calculateS_i(sortedData, row_begin, row_end);
        int hash = tableHashFunction.calculateHash(S_i);
        Assertions.assertThat(hash).isEqualTo(result);
    }

}