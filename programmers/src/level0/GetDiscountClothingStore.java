package level0;

public class GetDiscountClothingStore {

    public static void main(String[] args) {

    }

    static class Solution {
        public int solution(int price) {
            int answer = 0;

            if(price >= 500000){
                answer = (int) (price - price * 0.2);
                return answer;
            }

            if(price >= 300000){
                answer = (int) (price - price * 0.1);
                return answer;
            }

            if(price >= 100000){
                answer = (int) (price - price * 0.05);
                return answer;
            }

            answer = price;

            return answer;
        }
    }
}
