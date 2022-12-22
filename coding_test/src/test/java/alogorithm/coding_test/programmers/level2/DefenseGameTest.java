package alogorithm.coding_test.programmers.level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefenseGameTest {

    DefenseGame defenseGame = new DefenseGame();

    @Test
    @DisplayName("테스트 케이스 1")
    void testCase1(){

        int numberOfSoldiers = 7;
        int numberOfInvincibleTickets = 3;
        int[] enemies = {4, 2, 4, 5, 3, 3, 1};
        int expectResult = 5;

        int myResult = defenseGame.solution(numberOfSoldiers, numberOfInvincibleTickets, enemies);

        Assertions.assertThat(myResult).isEqualTo(expectResult);
    }

    @Test
    @DisplayName("테스트 케이스 2")
    void testCase2(){

        int numberOfSoldiers = 2;
        int numberOfInvincibleTickets = 4;
        int[] enemies = {3,3,3,3};
        int expectResult = 4;

        int myResult = defenseGame.solution(numberOfSoldiers, numberOfInvincibleTickets, enemies);

        Assertions.assertThat(myResult).isEqualTo(expectResult);
    }

}