package alogorithm.coding_test.programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class DefenseGame {
    public int solution(int numberOfSoldiers, int numberOfInvincibleTickets, int[] enemies){

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int round = 0;

        for(int enemy : enemies){

            priorityQueue.add(enemy);
            numberOfSoldiers -= enemy;

            if(numberOfSoldiers >= 0) {
                round++;
                continue;
            }

            if(numberOfInvincibleTickets >0 && !priorityQueue.isEmpty()){
                numberOfSoldiers += priorityQueue.poll();
                numberOfInvincibleTickets--;
                round++;
                continue;
            }

            break;
        }

        return round;
    }
}
