package level1;

import java.util.Arrays;

public class FruitSeller {

    public static void main(String[] args) {

    }

    static class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;

            Arrays.sort(score);

            for(int i = score.length; i >= m; i -= m){
                answer += score[i - m] * m;
            }


            return answer;
        }
    }
}


/*

사과 1점 ~ k점
한 상자에 사과 m개
사과 중 가장 낮은 점수가 p(1 <= p <= k) 인경우 한 상자는 p * m
가능한 많은 사과를 팔았을 때, 얻을 수 있는 최대 이익
상자단위로만 판매, 나머지 버림
사과의 최대 점수 k
한 상자에 들어가는 사과의 수 m
사과들의 점수 score
score.길이는 사과의 개수


*/