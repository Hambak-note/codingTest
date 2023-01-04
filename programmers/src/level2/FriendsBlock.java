package level2;

import java.util.Arrays;
import java.util.Stack;

public class FriendsBlock {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        int answer =  s.solution(6, 6, board);
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int m, int n, String[] board) {
            int answer = 0;

            char[][] charBoard = makeCharBoard(m, n, board);
            boolean[][] fourBlockCheckArr = makeFourBlocksCheckArr(m, n, charBoard);
            char[][] fourBlockRemovedBoard = makeFourBlockRemoveBoard(m, n, charBoard, fourBlockCheckArr);

            boolean isRemainFourBoard = true;
            while(isRemainFourBoard){

                fourBlockCheckArr = makeFourBlocksCheckArr(m, n, fourBlockRemovedBoard);
                fourBlockRemovedBoard = makeFourBlockRemoveBoard(m, n, fourBlockRemovedBoard,fourBlockCheckArr);

                int removeBoardCount = countRemovedBoard(m, n, fourBlockRemovedBoard);
                if(answer == removeBoardCount){
                    isRemainFourBoard = false;
                    break;
                }
                answer = removeBoardCount;
            }

            return answer;
        }

        public char[][] makeCharBoard(int m, int n, String[] board){
            char[][] newBoard = new char[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    newBoard[i][j] = board[i].charAt(j);
                }
            }
            return newBoard;
        }

        public boolean[][] makeFourBlocksCheckArr(int m, int n, char[][] board){
            int[] dirX = {0, 1, 1};
            int[] dirY = {1, 0, 1};
            boolean[][] fourBlockCheck = new boolean[m][n];

            char currentChar;
            boolean isFourBlock;
            for(int i = 0; i < m-1; i++){
                for(int j = 0; j < n-1; j++){
                    currentChar = board[i][j];
                    isFourBlock = true;
                    for(int k = 0; k < 3; k++){
                        int nextX = i + dirX[k];
                        int nextY = j + dirY[k];
                        if(currentChar == board[nextX][nextY] && board[nextX][nextY] != 'X') continue;
                        isFourBlock = false;
                        break;
                    }

                    if(isFourBlock){
                        for(int k = 0; k < 3; k++) {
                            int nextX = i + dirX[k];
                            int nextY = j + dirY[k];
                            fourBlockCheck[nextX][nextY] = true;
                        }
                        fourBlockCheck[i][j] = true;
                    }
                }
            }
            return fourBlockCheck;
        }

        public char[][] makeFourBlockRemoveBoard(int m, int n, char[][] board, boolean[][] checkArr){
            char[][] fourBlockRemoveBoard = new char[m][n];
            Stack<Character> notRemovedBlockStore = new Stack<>();

            for(int i = 0; i < m; i++){
                Arrays.fill(fourBlockRemoveBoard[i], 'x');
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(checkArr[j][i] == true) continue;
                    notRemovedBlockStore.push(board[j][i]);
                }
                for(int j = m-1; j >= 0; j--){
                    if(notRemovedBlockStore.isEmpty()) break;
                    fourBlockRemoveBoard[j][i] = notRemovedBlockStore.pop();
                }
            }

            return fourBlockRemoveBoard;
        }

        public int countRemovedBoard(int m, int n, char[][] removedBoard){
            int count = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(removedBoard[i][j] == 'x') count++;
                }
            }

            return count;
        }

    }

}

